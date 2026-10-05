package id.liberate.pro.ui.screen.susfs.content

import androidx.compose.runtime.Composable
import id.liberate.pro.ui.LocalUiMode
import id.liberate.pro.ui.UiMode
import id.liberate.pro.ui.screen.susfs.content.miuix.BasicSettingsContentMiuix
import id.liberate.pro.ui.screen.susfs.content.material.BasicSettingsContentMaterial

@Composable
fun BasicSettingsContent(
    unameValue: String,
    onUnameValueChange: (String) -> Unit,
    buildTimeValue: String,
    onBuildTimeValueChange: (String) -> Unit,
    executeInPostFsData: Boolean,
    onExecuteInPostFsDataChange: (Boolean) -> Unit,
    autoStartEnabled: Boolean,
    canEnableAutoStart: Boolean,
    isLoading: Boolean,
    onAutoStartToggle: (Boolean) -> Unit,
    onShowSlotInfo: () -> Unit,
    enableHideBl: Boolean,
    onEnableHideBlChange: (Boolean) -> Unit,
    enableCleanupResidue: Boolean,
    onEnableCleanupResidueChange: (Boolean) -> Unit,
    enableAvcLogSpoofing: Boolean,
    onEnableAvcLogSpoofingChange: (Boolean) -> Unit,
    hideSusMountsForAllProcs: Boolean,
    onHideSusMountsForAllProcsChange: (Boolean) -> Unit,
    cmdlineOrBootconfigPath: String = "",
    onCmdlineOrBootconfigApply: (String) -> Unit = {},
    onReset: (() -> Unit)? = null,
    onApply: (() -> Unit)? = null,
    onConfigReload: () -> Unit
) {
    when (LocalUiMode.current) {
        UiMode.Miuix -> BasicSettingsContentMiuix(
            unameValue = unameValue,
            onUnameValueChange = onUnameValueChange,
            buildTimeValue = buildTimeValue,
            onBuildTimeValueChange = onBuildTimeValueChange,
            executeInPostFsData = executeInPostFsData,
            onExecuteInPostFsDataChange = onExecuteInPostFsDataChange,
            autoStartEnabled = autoStartEnabled,
            canEnableAutoStart = canEnableAutoStart,
            isLoading = isLoading,
            onAutoStartToggle = onAutoStartToggle,
            onShowSlotInfo = onShowSlotInfo,
            enableHideBl = enableHideBl,
            onEnableHideBlChange = onEnableHideBlChange,
            enableCleanupResidue = enableCleanupResidue,
            onEnableCleanupResidueChange = onEnableCleanupResidueChange,
            enableAvcLogSpoofing = enableAvcLogSpoofing,
            onEnableAvcLogSpoofingChange = onEnableAvcLogSpoofingChange,
            hideSusMountsForAllProcs = hideSusMountsForAllProcs,
            onHideSusMountsForAllProcsChange = onHideSusMountsForAllProcsChange,
            cmdlineOrBootconfigPath = cmdlineOrBootconfigPath,
            onCmdlineOrBootconfigApply = onCmdlineOrBootconfigApply,
            onReset = onReset,
            onApply = onApply,
            onConfigReload = onConfigReload
        )
        UiMode.Material -> BasicSettingsContentMaterial(
            unameValue = unameValue,
            onUnameValueChange = onUnameValueChange,
            buildTimeValue = buildTimeValue,
            onBuildTimeValueChange = onBuildTimeValueChange,
            executeInPostFsData = executeInPostFsData,
            onExecuteInPostFsDataChange = onExecuteInPostFsDataChange,
            autoStartEnabled = autoStartEnabled,
            canEnableAutoStart = canEnableAutoStart,
            isLoading = isLoading,
            onAutoStartToggle = onAutoStartToggle,
            onShowSlotInfo = onShowSlotInfo,
            enableHideBl = enableHideBl,
            onEnableHideBlChange = onEnableHideBlChange,
            enableCleanupResidue = enableCleanupResidue,
            onEnableCleanupResidueChange = onEnableCleanupResidueChange,
            enableAvcLogSpoofing = enableAvcLogSpoofing,
            onEnableAvcLogSpoofingChange = onEnableAvcLogSpoofingChange,
            hideSusMountsForAllProcs = hideSusMountsForAllProcs,
            onHideSusMountsForAllProcsChange = onHideSusMountsForAllProcsChange,
            cmdlineOrBootconfigPath = cmdlineOrBootconfigPath,
            onCmdlineOrBootconfigApply = onCmdlineOrBootconfigApply,
            onReset = onReset,
            onApply = onApply,
            onConfigReload = onConfigReload
        )
    }
}
