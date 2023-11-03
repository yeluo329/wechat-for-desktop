package ui.collect.model

import moe.tlaster.precompose.viewmodel.ViewModel
import router.RouterUrls


class CollectCenterViewModel : ViewModel() {
    var menuList = mutableListOf<CollectMenuData>()
        private set
    init {
        menuList.add(CollectMenuData("collect/collect_collect.png", "全部收藏", RouterUrls.CONTACT_ALL))
        menuList.add(CollectMenuData("collect/collect_picture.png", "图片与视频", RouterUrls.CONTACT_PICTURE))
        menuList.add(CollectMenuData("collect/collect_message.png", "聊天记录", RouterUrls.CONTACT_MESSAGE))
        menuList.add(CollectMenuData("collect/collect_voice.png", "语音", RouterUrls.CONTACT_VOICE))
        menuList.add(CollectMenuData("collect/collect_menu.png", "文件", RouterUrls.CONTACT_MENU))
        menuList.add(CollectMenuData("collect/collect_link.png", "链接", RouterUrls.CONTACT_LINK))
        menuList.add(CollectMenuData("collect/collect_collect.png", "全部收藏", RouterUrls.CONTACT_ALL))
        menuList.add(CollectMenuData("collect/collect_picture.png", "图片与视频", RouterUrls.CONTACT_PICTURE))
        menuList.add(CollectMenuData("collect/collect_message.png", "聊天记录", RouterUrls.CONTACT_MESSAGE))
        menuList.add(CollectMenuData("collect/collect_voice.png", "语音", RouterUrls.CONTACT_VOICE))
        menuList.add(CollectMenuData("collect/collect_menu.png", "文件", RouterUrls.CONTACT_MENU))
        menuList.add(CollectMenuData("collect/collect_link.png", "链接", RouterUrls.CONTACT_LINK))
        menuList.add(CollectMenuData("collect/collect_collect.png", "全部收藏", RouterUrls.CONTACT_ALL))
        menuList.add(CollectMenuData("collect/collect_picture.png", "图片与视频", RouterUrls.CONTACT_PICTURE))
        menuList.add(CollectMenuData("collect/collect_message.png", "聊天记录", RouterUrls.CONTACT_MESSAGE))
        menuList.add(CollectMenuData("collect/collect_voice.png", "语音", RouterUrls.CONTACT_VOICE))
        menuList.add(CollectMenuData("collect/collect_menu.png", "文件", RouterUrls.CONTACT_MENU))
        menuList.add(CollectMenuData("collect/collect_link.png", "链接", RouterUrls.CONTACT_LINK))
    }

}

data class CollectMenuData(val imgUrl: String, val text: String, val deepUrl: String)