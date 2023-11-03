package ui.collect.model

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import model.wanAndroid.WanAndroidNetwork
import model.wanAndroid.data.BannerInfo
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class CollectViewModel : ViewModel() {

    private val _viewEvents = Channel<CollectViewEvent>(Channel.UNLIMITED)
    val viewEvent = _viewEvents.receiveAsFlow()
    fun dispatch(action: CollectViewAction) {
        when (action) {
            is CollectViewAction.Require -> fetchData()
        }
    }

    private fun fetchData() {
        viewModelScope.launch {
            flow {
                emit(WanAndroidNetwork.getBannerInfo())
            }.map { bean ->
                //将值映射成另外一个值
                val result = mutableListOf<BannerInfo>()
                bean.data?.forEach {
                    result.add(BannerInfo(it.title ?: "", it.imagePath ?: "", it.url ?: ""))
                }
                result
            }.onEach {
                _viewEvents.send(CollectViewEvent.SuccessMessage(it))
            }.collect{}
        }
    }

}


sealed class CollectViewEvent {

    data class SuccessMessage(val bannerInfo: MutableList<BannerInfo>) : CollectViewEvent()
}

//意图
sealed class CollectViewAction {
    object Require : CollectViewAction()
}