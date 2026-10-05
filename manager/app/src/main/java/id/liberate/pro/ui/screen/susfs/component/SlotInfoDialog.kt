package id.liberate.pro.ui.screen.susfs.component

import androidx.compose.runtime.Composable
import id.liberate.pro.ui.LocalUiMode
import id.liberate.pro.ui.UiMode
import id.liberate.pro.ui.screen.susfs.component.miuix.SlotInfoDialogMiuix
import id.liberate.pro.ui.screen.susfs.component.material.SlotInfoDialogMaterial
import id.liberate.pro.ui.screen.susfs.util.SlotInfo

@Composable
fun SlotInfoDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    slotInfoList: List<SlotInfo>,
    currentActiveSlot: String,
    isLoadingSlotInfo: Boolean,
    onRefresh: () -> Unit,
    onUseUname: (String) -> Unit,
    onUseBuildTime: (String) -> Unit
) {
    when (LocalUiMode.current) {
        UiMode.Miuix -> SlotInfoDialogMiuix(
            showDialog = showDialog,
            onDismiss = onDismiss,
            slotInfoList = slotInfoList,
            currentActiveSlot = currentActiveSlot,
            isLoadingSlotInfo = isLoadingSlotInfo,
            onRefresh = onRefresh,
            onUseUname = onUseUname,
            onUseBuildTime = onUseBuildTime
        )
        UiMode.Material -> SlotInfoDialogMaterial(
            showDialog = showDialog,
            onDismiss = onDismiss,
            slotInfoList = slotInfoList,
            currentActiveSlot = currentActiveSlot,
            isLoadingSlotInfo = isLoadingSlotInfo,
            onRefresh = onRefresh,
            onUseUname = onUseUname,
            onUseBuildTime = onUseBuildTime
        )
    }
}
