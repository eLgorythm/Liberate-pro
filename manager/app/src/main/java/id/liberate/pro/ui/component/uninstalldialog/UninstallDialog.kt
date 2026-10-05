package id.liberate.pro.ui.component.uninstalldialog

import androidx.compose.runtime.Composable
import id.liberate.pro.ui.LocalUiMode
import id.liberate.pro.ui.UiMode

@Composable
fun UninstallDialog(
    show: Boolean,
    onDismissRequest: () -> Unit
) {
    when (LocalUiMode.current) {
        UiMode.Miuix -> UninstallDialogMiuix(show, onDismissRequest)
        UiMode.Material -> UninstallDialogMaterial(show, onDismissRequest)
    }
}
