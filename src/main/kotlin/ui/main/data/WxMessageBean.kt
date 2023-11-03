package ui.main.data


data class WxMessageBean(
    var message: String,
    var messageImg: String,
    var messageType: MessageType,
    var userId: Int
)


enum class MessageType {
    MESSAGE, IMAGE
}