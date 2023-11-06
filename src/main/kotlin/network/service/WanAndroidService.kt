package network.service

import model.wanAndroid.data.ArticleListInfo
import model.wanAndroid.data.BannerInfo
import model.wanAndroid.data.BasicBean
import retrofit2.http.GET

interface WanAndroidService {

    @GET("banner/json")
    suspend fun getBanner(): BasicBean<ArrayList<BannerInfo>>

    @GET("article/list/0/json")
    suspend fun getArticle():BasicBean<ArticleListInfo>
}