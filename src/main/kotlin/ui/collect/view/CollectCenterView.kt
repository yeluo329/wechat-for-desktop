package ui.collect.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import base.baseui.SearchBarView
import com.sencent.xmj.compose.modifier
import moe.tlaster.precompose.navigation.Navigator
import router.NavigatorManager
import router.RouterUrls
import ui.collect.model.CollectCenterViewModel
import ui.common.AsyncImage

@Preview
@Composable
fun CollectCenterView(navigator: Navigator) {
    val viewModel = CollectCenterViewModel()
    var inputWord by remember { mutableStateOf("") }
    Column(modifier = Modifier.width(320.dp).fillMaxHeight().background(Color.White)) {
        Spacer(modifier = Modifier.height(8.dp))
        SearchBarView(Modifier.height(50.dp).padding(start = 8.dp, end = 8.dp).fillMaxWidth().background(
            color = Color(247, 242, 243), shape = RoundedCornerShape(20),
        ), inputWord, { inputWord = it }) {
            Icon(
                painter = painterResource("image/search.png"), "", modifier = Modifier.size(18.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.height(45.dp).padding(start = 8.dp, end = 8.dp).clip(RoundedCornerShape(4.dp))
                .fillMaxWidth().background(Color.LightGray)
        ) {
            Row {
                AsyncImage(modifier = Modifier.size(24.dp), url = "collect/collect_add.png")
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = "新建笔记", color = Color.White, fontSize = 16.sp)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Column{
            viewModel.menuList.forEach {
                CollectMenuItemView(it.imgUrl, it.text) {
                    navigator.navigate(it.deepUrl)
                }
            }

        }

    }
}

@Composable
fun CollectMenuItemView(imgUrl: String, text: String, onClick: (() -> Unit)? = null) {
    Row(
        modifier = Modifier.fillMaxWidth().height(36.dp).clickable { onClick?.invoke() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        AsyncImage(modifier = Modifier.size(26.dp), imgUrl)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = text, fontSize = 14.sp)
    }
}

