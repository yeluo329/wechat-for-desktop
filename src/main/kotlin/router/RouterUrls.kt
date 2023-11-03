package router

import ui.collect.*

object RouterUrls {
    // 发现音乐
    const val DISCOVERY = "discovery"

    // 播客
    const val PODCAST = "podcast"

    //私人FM
    const val PERSONAL_FM = "personalFm"

    //视频
    const val VIDEO = "video"

    //关注
    const val FOLLOW = "follow"


    const val CONVERSION = "conversion/{id}"

    const val CONTACT = "contact"

    const val COLLECT = "collect/{type}"

    const val SETTING = "setting"


    const val CONTACT_ALL = "$COLLECT/${COLLECT_ALL}"
    const val CONTACT_PICTURE = "$COLLECT/${COLLECT_PICTURE}"
    const val CONTACT_MESSAGE = "$COLLECT/${COLLECT_MESSAGE}"
    const val CONTACT_VOICE = "$COLLECT/${COLLECT_VOICE}"
    const val CONTACT_MENU = "$COLLECT/${COLLECT_MENU}"
    const val CONTACT_LINK = "$COLLECT/${COLLECT_LINK}"

}

const val COLLECT_ALL = "all"
const val COLLECT_MESSAGE = "message"
const val COLLECT_PICTURE = "picture"
const val COLLECT_VOICE = "voice"
const val COLLECT_MENU = "menu"
const val COLLECT_LINK = "link"