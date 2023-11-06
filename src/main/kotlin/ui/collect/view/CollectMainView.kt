package ui.collect.view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import moe.tlaster.precompose.navigation.rememberNavigator
import router.CollectNavGraph

@Composable
fun CollectMainView() {
    val rememberNavigator = rememberNavigator()
    Row {
        CollectCenterView(rememberNavigator)
        CollectNavGraph(rememberNavigator)
    }


}



