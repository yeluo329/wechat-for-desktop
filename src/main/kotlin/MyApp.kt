
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import router.NavGraph
import ui.main.WxMainLeftMenu


@Composable
fun MyApp() {
    Column {
        Box(modifier = Modifier.weight(1f)) {
            Row(modifier = Modifier.fillMaxSize()) {
                WxMainLeftMenu()
                NavGraph()
            }
        }
    }

}






