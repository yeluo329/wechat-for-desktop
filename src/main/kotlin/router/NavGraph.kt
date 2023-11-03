package router

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sencent.xmj.compose.modifier
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.query
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import todo.TodoPage
import ui.collect.view.CollectMainView
import ui.main.WxConversionView

object NavigatorManager {
    lateinit var navigator: Navigator
}

@Composable
fun NavGraph() {
    val navigator = NavigatorManager.navigator
    NavHost(
        navigator = navigator, navTransition = remember {
            NavTransition(
                createTransition = fadeIn(),
                destroyTransition = fadeOut(),
                pauseTransition = fadeOut(),
                resumeTransition = fadeIn()
            )
        }, initialRoute = RouterUrls.CONVERSION
    ) {
        //聊天
        scene("${RouterUrls.CONVERSION}") { backStackEntry ->
            val index = backStackEntry.query<Int>("id")
            WxConversionView(index)
        }
        scene(RouterUrls.COLLECT) {
            CollectMainView()
        }
        scene(RouterUrls.SETTING) {
            TodoPage("设置")
        }
        scene(RouterUrls.CONTACT) {
           TodoPage("联系人")
        }


    }
}

