package model.wanAndroid

import model.wanAndroid.data.BannerInfo
import model.wanAndroid.data.BasicBean
import network.ServiceCreator
import network.service.WanAndroidService

object WanAndroidNetwork {

    private val wanAndroidService = ServiceCreator.create(WanAndroidService::class.java)

    suspend fun getBannerInfo(): BasicBean<ArrayList<BannerInfo>> {
        return wanAndroidService.getBanner()
    }
}