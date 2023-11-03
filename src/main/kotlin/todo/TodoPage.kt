package todo

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sencent.xmj.compose.modifier
import theme.AppColorsProvider
import ui.main.cpn.CommonTitleBar

@Preview
@Composable
fun TodoPage(tag: String, showTitle: Boolean = true) {
    Column {
        if (showTitle) {
            CommonTitleBar(tag, true)
        }

        Box(
            Modifier.fillMaxSize().background(AppColorsProvider.current.pure),
            contentAlignment = Alignment.Center
        ) {
            Text("todo-${tag}", color = AppColorsProvider.current.firstText)
        }

    }
}