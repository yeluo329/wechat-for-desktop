package view

import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.MenuBar

/**
 * mac左上角
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FrameWindowScope.MenuBarWeChat(
    isOpen: MutableState<Boolean>, showTray: MutableState<Boolean>
): Boolean {
    var isSubmenuShowing by remember { mutableStateOf(true) }
    var action by remember { mutableStateOf("Last action: None") }

    MenuBar {
        Menu("文件", mnemonic = 'F') {
            Item(
                "发起会话", onClick = { action = "Last action:send" }, shortcut =
                KeyShortcut(meta = true, key = Key.N)
            )
        }
        Menu("编辑", mnemonic = 'D') {

        }
        Menu("显示", mnemonic = 'B') {

        }
        Menu("窗口", mnemonic = 'A') {

        }
        Menu("帮助", mnemonic = 'H') {
            Item("帮助中心", onClick = { action = "Last action: Help" })
        }

    }



    return showTray.value
}