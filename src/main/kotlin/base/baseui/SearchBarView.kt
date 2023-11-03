package base.baseui

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun SearchBarView(
    modifier: Modifier,
    keyWord: String,
    onValueChange: (text: String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    TextField(
        value = keyWord, onValueChange = {
            onValueChange(it)
        }, modifier = modifier, colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent
        ), leadingIcon = leadingIcon, placeholder = {
            Text(text = "搜索", color = Color(0xff999999), fontSize = 16.sp) }
    )

}