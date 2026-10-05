package id.liberate.pro.ui.screen.susfs.component

import androidx.compose.runtime.Composable
import id.liberate.pro.ui.LocalUiMode
import id.liberate.pro.ui.UiMode
import id.liberate.pro.ui.screen.susfs.component.miuix.AddAppPathDialogMiuix
import id.liberate.pro.ui.screen.susfs.component.material.AddAppPathDialogMaterial
import id.liberate.pro.ui.screen.susfs.util.AppInfo

@Composable
fun AddAppPathDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: (List<String>) -> Unit,
    isLoading: Boolean,
    apps: List<AppInfo> = emptyList(),
    onLoadApps: () -> Unit,
    existingSusPaths: Set<String> = emptySet()
) {
    when (LocalUiMode.current) {
        UiMode.Miuix -> AddAppPathDialogMiuix(
            showDialog = showDialog,
            onDismiss = onDismiss,
            onConfirm = onConfirm,
            isLoading = isLoading,
            apps = apps,
            onLoadApps = onLoadApps,
            existingSusPaths = existingSusPaths
        )
        UiMode.Material -> AddAppPathDialogMaterial(
            showDialog = showDialog,
            onDismiss = onDismiss,
            onConfirm = onConfirm,
            isLoading = isLoading,
            apps = apps,
            onLoadApps = onLoadApps,
            existingSusPaths = existingSusPaths
        )
    }
}
