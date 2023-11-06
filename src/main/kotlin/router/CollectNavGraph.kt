package router

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import ui.collect.view.CollectRightView

@Composable
fun CollectNavGraph(navigator: Navigator) {
    NavHost(
        navigator = navigator,
        navTransition = remember {
            NavTransition(
                createTransition = fadeIn(),
                destroyTransition = fadeOut(),
                pauseTransition = fadeOut(),
                resumeTransition = fadeIn()
            )
        }, initialRoute = RouterUrls.CONTACT_ALL
    ) {
        scene(RouterUrls.CONTACT_MENU) {
            Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.White)) {
                Text("文件")
            }
        }
        scene(RouterUrls.CONTACT_PICTURE) {
            Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.White)) {
                Text("图片")
            }
        }
        scene(RouterUrls.CONTACT_MESSAGE) {
            Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.White)) {
                Text("消息")
            }
        }
        scene(RouterUrls.CONTACT_VOICE) {
            Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.White)) {
                Text("语音")
            }
        }

        scene(RouterUrls.CONTACT_LINK) {
            Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.White)) {
                Text("链接")
            }
        }
        scene(RouterUrls.CONTACT_ALL) {
            CollectRightView()
        }
    }
}