package ui.main.cpn

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.onClick
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import base.AppConfig
import com.sencent.xmj.compose.modifier
import router.NavGraph
import router.NavigatorManager
import theme.AppColorsProvider


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CommonTitleBar(
    title: String = "",
    showBackButton: Boolean = true,
    customerContent: (@Composable () -> Unit)? = null
) {
    Box(
        modifier = Modifier.fillMaxWidth().height(AppConfig.topBarHeight)
            .background(AppColorsProvider.current.pure), contentAlignment = Alignment.CenterStart
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (showBackButton) {
                val navigator = NavigatorManager.navigator
                Icon(
                    painterResource("image/ic_back.webp"),
                    modifier = Modifier.padding(start = 20.dp).clip(RoundedCornerShape(50)).onClick {
                        navigator.popBackStack()
                    }.padding(4.dp).size(18.dp),
                    contentDescription = "返回上一页",
                    tint = AppColorsProvider.current.firstIcon
                )
            }

            Text(
                title,
                color = AppColorsProvider.current.firstText,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
    }

}