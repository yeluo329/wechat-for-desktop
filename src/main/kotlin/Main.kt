import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import base.AppConfig
import moe.tlaster.precompose.PreComposeWindow
import moe.tlaster.precompose.navigation.rememberNavigator
import router.NavigatorManager
import theme.AppTheme
import theme.themeTypeState
import ui.main.cpn.CpnWinodwsPlatformDecorateButtons
import ui.main.data.WxViewModel
import util.EnvUtil
import view.MenuBarWeChat
import java.awt.Dimension

@Composable
@Preview
fun App() {
    AppTheme(themeTypeState.value) {
        NavigatorManager.navigator = rememberNavigator()
        MyApp()
    }
}

fun main() = application {
    val isOpen = rememberSaveable { mutableStateOf(true) }
    val showTray = rememberSaveable { mutableStateOf(true) }

    val windowState = rememberWindowState(size = DpSize(AppConfig.windowMinWidth, AppConfig.windowMinHeight))
    PreComposeWindow(
        state = windowState,
        onCloseRequest = ::exitApplication,
        undecorated = EnvUtil.isWindows(),
        title = "微信"
    ) {
        //Mac中左上角菜单
        showTray.value = MenuBarWeChat(isOpen, showTray)
       //最小size
        window.minimumSize =
            Dimension(AppConfig.windowMinWidth.value.toInt(), AppConfig.windowMinHeight.value.toInt())
        WxViewModel.initData()
        //content
        App()
//        CpnWinodwsPlatformDecorateButtons(windowState)

    }
}
