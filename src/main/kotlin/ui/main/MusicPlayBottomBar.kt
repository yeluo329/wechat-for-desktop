package ui.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.onClick
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import theme.AppColorsProvider
import ui.common.AsyncImage

/**
 * 主页底部音乐播放组件
 */
@Composable
fun MusicPlayBottomBar() {
    Column(modifier = Modifier.background(color = AppColorsProvider.current.pure).fillMaxWidth().height(80.dp)) {

        Row(
            modifier = Modifier.padding(horizontal = 20.dp).fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CpnMusicInfo()
//            CpnMiddleActionButtons()
//            CpnRightActionButtons()
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun RowScope.CpnMusicInfo() {
    Row(
        modifier = Modifier.weight(1.5f).onClick {
//            MusicPlayController.showMusicPlayDrawer = !MusicPlayController.showMusicPlayDrawer
        },
        verticalAlignment = Alignment.CenterVertically
    ) {

//        AsyncImage(
//            Modifier.padding(end = 10.dp).size(48.dp).clip(RoundedCornerShape(4.dp)),
//            url = ""
//        )

    }

}
