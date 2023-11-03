package model.wanAndroid.data

import com.google.gson.annotations.SerializedName


data class BasicBean<T>(
    val data: T? = null,
    @SerializedName("errorCode")
    var code: Int = 0,
    @SerializedName("errorMsg")
    var errorMsg: String = "",
)
