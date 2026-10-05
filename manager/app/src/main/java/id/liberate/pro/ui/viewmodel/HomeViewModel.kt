package id.liberate.pro.ui.viewmodel

import android.content.Context
import android.os.Build
import android.system.Os
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import id.liberate.pro.BuildConfig
import id.liberate.pro.Natives
import id.liberate.pro.data.repository.SettingsRepository
import id.liberate.pro.data.repository.SettingsRepositoryImpl
import id.liberate.pro.getKernelVersion
import id.liberate.pro.ksuApp
import id.liberate.pro.ui.screen.home.HomeUiState
import id.liberate.pro.ui.screen.home.SystemInfo
import id.liberate.pro.ui.screen.home.getManagerVersion
import id.liberate.pro.ui.util.checkNewVersion
import id.liberate.pro.ui.util.getSELinuxStatusRaw
import id.liberate.pro.ui.util.module.LatestVersionInfo
import id.liberate.pro.ui.util.resolveDeviceName
import id.liberate.pro.ui.util.rootAvailable

class HomeViewModel(
    private val settingsRepo: SettingsRepository = SettingsRepositoryImpl()
) : ViewModel() {

    private val _uiState = MutableStateFlow(buildState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun refresh() {
        viewModelScope.launch {
            val baseState = withContext(Dispatchers.IO) { buildState() }
            _uiState.update { baseState }
            if (baseState.checkUpdateEnabled) {
                val latestVersionInfo = withContext(Dispatchers.IO) { checkNewVersion() }
                _uiState.update { it.copy(latestVersionInfo = latestVersionInfo) }
            }
        }
    }

    private fun buildState(): HomeUiState {
        val kernelVersion = getKernelVersion()
        val isManager = Natives.isManager
        val ksuVersion = if (isManager) Natives.version else null
        val kernelUAPIVersion = if (isManager) Natives.kernelUAPIVersion else null
        val managerUAPIVersion = Natives.managerUAPIVersion
        val lkmMode = ksuVersion?.let { if (kernelVersion.isGKI()) Natives.isLkmMode else null }
        val isRootAvailable = rootAvailable()
        val managerVersion = getManagerVersion(ksuApp)
        val kernelFullVersion = if (isManager) Natives.getFullVersion() else null

        val zygiskImplementation = if (isManager && isRootAvailable) {
            id.liberate.pro.ui.screen.home.getZygiskImplementation(
                notInstalledText = ksuApp.getString(id.liberate.pro.R.string.home_zygisk_not_installed),
                disabledText = ksuApp.getString(id.liberate.pro.R.string.home_zygisk_disabled),
                rebootRequiredText = ksuApp.getString(id.liberate.pro.R.string.home_zygisk_reboot_required),
            )
        } else null

        return HomeUiState(
            kernelVersion = kernelVersion,
            ksuVersion = ksuVersion,
            lkmMode = lkmMode,
            isLkmBundled = lkmMode == true && Natives.isLkmBundled,
            isManager = isManager,
            isManagerPrBuild = BuildConfig.IS_PR_BUILD,
            isKernelPrBuild = Natives.isPrBuild,
            requiresNewKernel = isManager && Natives.managerUAPIVersion > Natives.kernelUAPIVersion,
            requiresNewManager = isManager && Natives.managerUAPIVersion < Natives.kernelUAPIVersion,
            kernelUAPIVersion = kernelUAPIVersion,
            managerUAPIVersion = managerUAPIVersion,
            isRootAvailable = isRootAvailable,
            isSafeMode = Natives.isSafeMode,
            isLateLoadMode = Natives.isLateLoadMode,
            checkUpdateEnabled = settingsRepo.checkUpdate,
            showFullStatus = ksuApp.getSharedPreferences("settings", Context.MODE_PRIVATE)
                .getBoolean("show_fingerprint", true),
            latestVersionInfo = LatestVersionInfo(),
            currentManagerVersionCode = managerVersion.versionCode,
            systemInfo = SystemInfo(
                kernelVersion = Os.uname().release,
                managerVersion = "${managerVersion.versionName} (${managerVersion.versionCode}-${managerUAPIVersion})",
                deviceModel = resolveDeviceName(),
                kernelFullVersion = kernelFullVersion,
                fingerprint = Build.FINGERPRINT,
                selinuxStatus = getSELinuxStatusRaw(),
                seccompStatus = runCatching {
                    Os.prctl(21 /* PR_GET_SECCOMP */, 0, 0, 0, 0)
                }.getOrDefault(-1),
                zygiskImplementation = zygiskImplementation,
            ),
        )
    }
}
