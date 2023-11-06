package ui.collect.view

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sencent.xmj.compose.modifier
import model.wanAndroid.data.ArticleListInfo
import ui.collect.model.CollectRightViewAction
import ui.collect.model.CollectRightViewEvent
import ui.collect.model.CollectRightViewModel
import javax.swing.text.html.HTML.Tag.H6


//重组导致  两次请求
@Composable
fun CollectRightView() {
    val viewModel = CollectRightViewModel()

    viewModel.dispatch(CollectRightViewAction.Require)
    var info by remember { mutableStateOf(ArticleListInfo()) }
    LaunchedEffect(Unit) {
        viewModel.viewEvent.collect {
            if (it is CollectRightViewEvent.SuccessMessage) {
                info = it.articleInfo
            } else if (it is CollectRightViewEvent.ErrorMessage) {

            }
        }
    }

    if (info.datas == null) {
        Text("文件")
    } else {
        val scrollState = rememberScrollState(0)

        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
                .verticalScroll(scrollState)
        ) {
            info.datas!!.forEach {
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .height(140.dp).padding(
                            horizontal = 16.dp, vertical = 8.dp
                        ), elevation = 6.dp
                ) {
                    Column(modifier = Modifier.padding(start = 6.dp,top = 4.dp)) {
                        Text(
                            it.shareUser, modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentHeight()
                                .clip(RoundedCornerShape(20.dp / 2)),
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            it.title, modifier = Modifier
                                .width(400.dp)
                                .wrapContentHeight()
                                .clip(RoundedCornerShape(20.dp / 2)),
                            textAlign = TextAlign.Start,
                            fontSize = 14.sp,
                            color = Color.LightGray
                        )
                    }


                }

            }
        }
    }
}

