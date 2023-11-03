package ui.collect.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.wanAndroid.data.BannerInfo
import moe.tlaster.precompose.navigation.rememberNavigator
import router.CollectNavGraph

import ui.collect.model.CollectViewAction
import ui.collect.model.CollectViewEvent
import ui.collect.model.CollectViewModel
import ui.common.AsyncImage


@Composable
fun CollectMainView() {
    var rememberNavigator = rememberNavigator()
    Row {
        CollectCenterView(rememberNavigator)
        CollectNavGraph(rememberNavigator)
//        if (type != null) {
//            Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.White)) {
//                Text(type.toString())
//            }
//        } else {
//            //viewModel会不会内存泄露
//            val viewModel = CollectViewModel()
//            viewModel.dispatch(CollectViewAction.Require)
//            var banners by remember { mutableStateOf(ArrayList<BannerInfo>()) }
//            LaunchedEffect(Unit) {
//                viewModel.viewEvent.collect {
//                    if (it is CollectViewEvent.SuccessMessage) {
//                        banners = it.bannerInfo as ArrayList<BannerInfo>
//                    }
//                }
//            }
//
//            if (banners.isNotEmpty()) {
//                LazyColumn {
//                    items(banners.size) {
//                        val bannerInfo = banners[it]
//                        AsyncImage(
//                            modifier = Modifier.clip(RoundedCornerShape(10.dp)).width(320.dp).wrapContentHeight(),
//                            url = bannerInfo.imagePath
//                        )
////                        WeatherText("名字", bannerInfo.title)
//                    }
//                }
//            }
//        }

    }


}



