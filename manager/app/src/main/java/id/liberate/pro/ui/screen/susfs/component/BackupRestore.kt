package id.liberate.pro.ui.screen.susfs.component

import androidx.compose.runtime.Composable
import id.liberate.pro.ui.LocalUiMode
import id.liberate.pro.ui.UiMode
import id.liberate.pro.ui.screen.susfs.component.miuix.BackupRestoreComponentMiuix
import id.liberate.pro.ui.screen.susfs.component.material.BackupRestoreComponentMaterial

@Composable
fun BackupRestoreComponent(
    isLoading: Boolean,
    onLoadingChange: (Boolean) -> Unit,
    onConfigReload: () -> Unit
) {
    when (LocalUiMode.current) {
        UiMode.Miuix -> BackupRestoreComponentMiuix(
            isLoading = isLoading,
            onLoadingChange = onLoadingChange,
            onConfigReload = onConfigReload
        )
        UiMode.Material -> BackupRestoreComponentMaterial(
            isLoading = isLoading,
            onLoadingChange = onLoadingChange,
            onConfigReload = onConfigReload
        )
    }
}
