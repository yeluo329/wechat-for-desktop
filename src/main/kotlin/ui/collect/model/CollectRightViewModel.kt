package ui.collect.model

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import model.wanAndroid.WanAndroidNetwork
import model.wanAndroid.data.ArticleListInfo
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.jetbrains.skia.impl.Log
import javax.swing.text.View


class CollectRightViewModel : ViewModel() {

    private val _viewEvents = Channel<CollectRightViewEvent>(Channel.UNLIMITED)

    val viewEvent = _viewEvents.receiveAsFlow()

    fun dispatch(action: CollectRightViewAction) {
        when (action) {
            is CollectRightViewAction.Require -> fetchData()
        }
    }

    private fun fetchData() {
        viewModelScope.launch {
            flow {
                emit(WanAndroidNetwork.getArticleInfo())
            }.onStart {
                println("开始了")
            }.map { bean ->
                bean.data
            }.onEach {
                if (it == null) {
                    _viewEvents.send(CollectRightViewEvent.ErrorMessage("数据为空"))
                } else {
                    _viewEvents.send(CollectRightViewEvent.SuccessMessage(it))
                }
            }.collect {}
        }
    }
}

//一次性事件

sealed class CollectRightViewEvent {
    data class ErrorMessage(val message: String) : CollectRightViewEvent()
    data class SuccessMessage(val articleInfo: ArticleListInfo) : CollectRightViewEvent()
}


//意图
sealed class CollectRightViewAction {
    object Require : CollectRightViewAction()
}