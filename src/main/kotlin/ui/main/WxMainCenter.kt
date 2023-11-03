package ui.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import router.NavigatorManager
import router.RouterUrls
import ui.common.AsyncImage
import ui.main.data.WxViewModel

@Composable
fun centerView() {
    var inputValue by remember { mutableStateOf("") }
    val scrollLazyState = rememberLazyListState()
    var selectedIndex by remember { mutableStateOf(-1) }
    val navigator = NavigatorManager.navigator
    val messageList = WxViewModel.contactList
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(320.dp).background(Color.White).padding(8.dp)
        ) {
            SearchBarView(Modifier.height(50.dp).width(250.dp).background(
                color = Color(247, 242, 243), shape = RoundedCornerShape(20),
            ), inputValue, {
                inputValue = it
            }) {
                Icon(
                    painter = painterResource("image/search.png"), "", modifier = Modifier.size(18.dp)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier.size(48.dp).background(
                    color = Color(247, 242, 243), shape = RoundedCornerShape(20)
                ).clip(shape = RoundedCornerShape(20))
            ) {
                AsyncImage(modifier = Modifier.size(48.dp).padding(8.dp), url = "image/add.png")
            }
        }

        LazyColumn(
            state = scrollLazyState, modifier = Modifier.width(320.dp)
        ) {
            items(messageList.size) { index ->
                Row(Modifier.background(if (selectedIndex == index) Color.LightGray else Color.White).clickable {
                        selectedIndex = index
                        val url = "${RouterUrls.CONVERSION}?id=${messageList[index].userId}"
                        navigator.navigate(url)
                    }.padding(top = 10.dp, start = 15.dp, bottom = 10.dp, end = 15.dp)) {
                    Image(
                        painter = painterResource(messageList[index].head), "", modifier = Modifier.width(45.dp).clip(
                            RoundedCornerShape(50)
                        )
                    )
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.width(300.dp).padding(start = 10.dp)
                    ) {
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.width(300.dp)) {
                            Text(messageList[index].name, fontSize = 14.sp)
                            Text(messageList[index].time, fontSize = 11.sp, color = Color(111, 111, 111))
                        }
                        Spacer(Modifier.height(6.dp))
                        Text(messageList[index].message, fontSize = 12.sp, color = Color(111, 111, 111))
                    }

                }
            }
        }

    }
}