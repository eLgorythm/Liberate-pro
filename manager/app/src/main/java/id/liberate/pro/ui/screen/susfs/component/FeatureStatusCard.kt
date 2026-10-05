package id.liberate.pro.ui.screen.susfs.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.liberate.pro.ui.LocalUiMode
import id.liberate.pro.ui.UiMode
import id.liberate.pro.ui.screen.susfs.component.miuix.FeatureStatusCardMiuix
import id.liberate.pro.ui.screen.susfs.component.material.FeatureStatusCardMaterial
import id.liberate.pro.ui.screen.susfs.util.EnabledFeature

@Composable
fun FeatureStatusCard(
    feature: EnabledFeature,
    onRefresh: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    when (LocalUiMode.current) {
        UiMode.Miuix -> FeatureStatusCardMiuix(
            feature = feature,
            onRefresh = onRefresh,
            modifier = modifier
        )
        UiMode.Material -> FeatureStatusCardMaterial(
            feature = feature,
            onRefresh = onRefresh,
            modifier = modifier
        )
    }
}
