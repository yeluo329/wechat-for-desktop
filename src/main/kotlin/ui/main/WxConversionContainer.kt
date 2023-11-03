package ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ui.common.AsyncImage
import ui.main.data.*


@Composable
fun WxConversionContainer(id: Int?) {
    val contactList = WxViewModel.contactList
    val scrollState = rememberLazyListState()
    var inputText by remember { mutableStateOf("") }
    val wxMessage = WxViewModel.messageMap[id]
    val rememberCoroutineScope = rememberCoroutineScope()


    if (id == null) {
        Box(
            modifier = Modifier.fillMaxHeight().width(606.dp).background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                modifier = Modifier.clip(RoundedCornerShape(50)).size(150.dp), "image/wechat.png",
                "image/ic_default_avator.webp",
                "image/ic_default_avator.webp"
            )
        }
    } else {
        Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.White)) {
            Row(
                modifier = Modifier.height(55.dp).fillMaxWidth().background(Color(247, 242, 243, 100))
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                var message: WxListBean? = null
                contactList.forEach {
                    if (it.userId == id) {
                        message = it

                    }
                }
                message?.let {
                    Text(it.name)
                }

                Image(
                    painter = painterResource("image/more.png"),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
            }

            Spacer(Modifier.height(1.dp).fillMaxWidth().background(Color(222, 222, 222)))
            //消息列表
            LazyColumn(
                Modifier.weight(1f).fillMaxWidth().background(Color(247, 242, 243, 100)),
                state = scrollState
            ) {
                if (wxMessage != null && wxMessage.size != 0) {
                    rememberCoroutineScope.launch {
                        scrollState.animateScrollToItem(wxMessage.size)
                    }
                    items(wxMessage.size) { index ->
                        val message = wxMessage[index]
                        if (message.userId != UserManager.userId) {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(15.dp),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                //对面的头像
                                var parHead = ""
                                WxViewModel.contactList.forEach {
                                    if (it.userId == id) {
                                        parHead = it.head
                                    }
                                }
                                if (parHead == "") parHead = "image/head_1/png"

                                Image(
                                    painter = painterResource(parHead),
                                    contentDescription = "",
                                    modifier = Modifier.padding(end = 10.dp)
                                        .size(40.dp).clip(RoundedCornerShape(10.dp)),
                                    contentScale = ContentScale.FillBounds
                                )
                                if (message.messageType == MessageType.MESSAGE) {
                                    Text(
                                        text = message.message,
                                        fontSize = 13.sp,
                                        modifier = Modifier.wrapContentWidth().background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(20)
                                        ).clip(shape = RoundedCornerShape(20)).padding(10.dp)
                                    )
                                } else {
                                    Image(
                                        painter = painterResource(message.messageImg),
                                        contentDescription = "",
                                        modifier = Modifier.size(80.dp).clickable {
                                            val wxListBean = WxViewModel.messageMap[id]
                                            if (wxListBean != null && wxListBean.size != 0) {
                                                wxListBean.add(WxMessageBean("哈哈", "", MessageType.MESSAGE, 1))
                                            }
                                        }
                                    )
                                }

                            }

                        } else {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(15.dp),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Row {
                                    if (message.messageType == MessageType.MESSAGE) {
                                        Text(
                                            text = message.message,
                                            fontSize = 13.sp,
                                            modifier = Modifier.wrapContentWidth().background(
                                                color = Color.White,
                                                shape = RoundedCornerShape(20)
                                            ).clip(shape = RoundedCornerShape(20)).padding(10.dp)
                                        )
                                    } else {
                                        Image(
                                            painter = painterResource(message.messageImg),
                                            contentDescription = "",
                                            modifier = Modifier.size(80.dp)
                                        )

                                    }
                                    Image(
                                        painter = painterResource(UserManager.myHeadUrl),
                                        contentDescription = "",
                                        modifier = Modifier.padding(start = 10.dp)
                                            .size(40.dp).clip(RoundedCornerShape(10.dp)),
                                        contentScale = ContentScale.FillBounds
                                    )
                                }
                            }
                        }
                    }
                }

            }
            Spacer(Modifier.height(1.dp).fillMaxWidth().background(Color(222, 222, 222)))
            Row(
                modifier = Modifier.background(Color(247, 242, 243, 100))
                    .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconImage("image/face.png")
                    IconImage("image/document.png")
                    IconImage("image/cut.png")
                    IconImage("image/message.png") {
                        wxMessage!!.apply {
                            add(WxMessageBean(inputText, "", MessageType.MESSAGE, 1))
                        }
                        inputText = ""
                        rememberCoroutineScope.launch {
                            scrollState.animateScrollToItem(wxMessage.size)
                        }
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconImage("image/telphone.png")
                    IconImage("image/video.png")
                }
            }

            TextField(
                value = inputText, onValueChange = {
                    inputText = it
                }, modifier = Modifier.height(226.dp).fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.Gray,
                    backgroundColor = Color(247, 242, 243, 100),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                ), placeholder = { Text(text = "请输入内容", color = Color(0xff999999), fontSize = 14.sp) }
            )

        }

    }


}

@Composable
fun IconImage(route: String, onClick: (() -> Unit)? = null) {
    Image(
        painter = painterResource(route),
        "",
        modifier = Modifier.padding(horizontal = 5.dp).size(24.dp).clickable { onClick?.invoke() },
    )
}