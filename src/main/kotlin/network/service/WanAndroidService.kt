package network.service

import model.wanAndroid.data.BannerInfo
import model.wanAndroid.data.BasicBean
import retrofit2.http.GET

interface WanAndroidService {

    @GET("banner/json")
    suspend fun getBanner(): BasicBean<ArrayList<BannerInfo>>
}