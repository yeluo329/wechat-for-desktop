package ui.main.data

/**
 * @param defaultPath 默认图片路径
 * @param selectPath 选择路径
 * @param path 实际路径
 * @param selected 是否选中
 */
data class WxSelectBean(
    val defaultPath: String,
    var selectedPath: String,
    var path: String,
    var selected: Boolean,
    var routeUrl: String
)
