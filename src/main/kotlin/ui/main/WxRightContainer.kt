package ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sencent.xmj.compose.modifier
import router.NavGraph

@Composable
fun WxConversionView(index: Int?) {
    Row(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        centerView()
        Spacer(modifier = Modifier.width(2.dp).fillMaxHeight().background(Color.LightGray))
        WxConversionContainer(index)
    }
}