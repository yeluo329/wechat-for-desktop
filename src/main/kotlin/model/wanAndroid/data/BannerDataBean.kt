package model.wanAndroid.data

import com.google.gson.annotations.SerializedName


data class BannerInfo(
    val title: String,
    val imagePath: String,
    var url: String,
)


data class ArticleListInfo(
    val curPage: Int = 0,
    val offset: Int = 0,
    val over: Boolean = false,
    var pageCount: Int = 0,
    val size: Int = 0,
    val total: Int = 0,
    val datas: List<ArticleInfo>? = null
)

data class ArticleInfo(
    val title: String,
    val shareUser: String,
    val niceShareDate: String,
)