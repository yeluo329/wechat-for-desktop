package ui.main

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.NavOptions
import router.NavigatorManager
import router.RouterUrls
import ui.common.AsyncImage
import ui.main.data.UserManager
import ui.main.data.WxSelectBean
import ui.main.data.WxViewModel


@Preview
@Composable
fun WxMainLeftMenu() {
    val navigator = NavigatorManager.navigator
    var selectedIndex by remember { mutableStateOf(0) }
    val WxData by remember { mutableStateOf(WxViewModel.position) }
    Box(modifier = Modifier.width(74.dp).fillMaxHeight().background(Color.LightGray)) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(12.dp))
            AsyncImage(
                modifier = Modifier.clip(RoundedCornerShape(50)).size(50.dp), UserManager.myHeadUrl,
                "image/ic_default_avator.webp",
                "image/ic_default_avator.webp"
            )
            for (i in 0 until (WxData.size - 1)) {
                Spacer(modifier = Modifier.height(18.dp))
                AsyncImage(
                    modifier = Modifier.size(24.dp).clickable {
                        selectedIndex = i
                        navigator.navigate(WxData[selectedIndex].routeUrl, NavOptions(launchSingleTop = true))
                    },
                    getPath(WxData, selectedIndex, i),
                    "image/ic_default_avator.webp",
                    "image/ic_default_avator.webp"
                )
            }
        }

        Box(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            contentAlignment = Alignment.Center
        ) {
            Column {
                AsyncImage(
                    modifier = Modifier.size(24.dp).clickable {
                        selectedIndex = WxData.size - 1
                        navigator.navigate(WxData[selectedIndex].routeUrl, NavOptions(launchSingleTop = true))
                    },
                    getPath(WxData, selectedIndex, WxData.size - 1),
                    "image/ic_default_avator.webp",
                    "image/ic_default_avator.webp"
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

    }
}

private fun getPath(wxData: ArrayList<WxSelectBean>, selectedIndex: Int, currentIndex: Int): String {
    return if (selectedIndex == currentIndex) {
        wxData[currentIndex].selectedPath
    } else {
        wxData[currentIndex].defaultPath
    }
}
