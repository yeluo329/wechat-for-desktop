package ui.main.data

import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.mutableStateOf
import router.RouterUrls

object WxViewModel : RememberObserver {
    val isAppReady = mutableStateOf(false)
    val position = ArrayList<WxSelectBean>()
    val contactList = ArrayList<WxListBean>()

    val messageMap = HashMap<Int, ArrayList<WxMessageBean>>()
    fun initData() {
        val arrayListOf = arrayListOf<WxSelectBean>()

        val list = arrayListOf<WxListBean>()

        val map = HashMap<Int, ArrayList<WxMessageBean>>()

        arrayListOf.add(
            WxSelectBean(
                "image/message_no_select.png",
                "image/message_select.webp",
                "image/message_select.webp",
                true,
                RouterUrls.CONVERSION
            )
        )
        arrayListOf.add(
            WxSelectBean(
                "image/contact_no_select.png",
                "image/contact_select.png",
                "image/contact_no_select.png",
                false,
                RouterUrls.CONTACT
            )
        )
        arrayListOf.add(
            WxSelectBean(
                "image/collect_no_select.png",
                "image/collect_select.png",
                "image/collect_no_select.png",
                false,
                RouterUrls.COLLECT
            )
        )
        arrayListOf.add(
            WxSelectBean(
                "image/setting_no_select.png",
                "image/setting_select.png",
                "image/setting_no_select.png",
                false,
                RouterUrls.SETTING
            )
        )

        list.add(WxListBean("CSDN社区专家", "image/head_1.png", "不是每个人都可以坐吃享受天下美食...", "7:45", 1))
        list.add(WxListBean("郭比蓝", "image/head_11.png", "撸啊撸", "7:45", 2))
        list.add(WxListBean("公众号", "image/head_3.png", "郭霖:Compose UI 带来的精彩...", "10:45", 3))
        list.add(WxListBean("Flutter交流群", "image/head_4.png", "java Dart Kotlin js ...", "12:35", 4))
        list.add(WxListBean("小江", "image/head_5.png", "clickable点击水波纹能去掉不？", "13:45", 5))
        list.add(WxListBean("lemone", "image/head_6.png", "我来了带他过来,如果他来了就可以面试了", "19:45", 6))
        list.add(WxListBean("窒息", "image/head_7.png", "撸啊撸", "11:45", 7))
        list.add(WxListBean("公众健康", "image/head_8.png", "郭霖:Compose UI 带来的精彩...", "17:45", 8))
        list.add(WxListBean("路飞", "image/head_9.png", "不是每个人都可以坐吃享受天下美食...", "21:45", 9))
        list.add(WxListBean("索罗", "image/head_10.png", "撸啊撸", "22:45", 10))
        list.add(WxListBean("鸣人", "image/head_11.png", "郭霖:Compose UI 带来的精彩...", "10:15", 11))
        list.add(WxListBean("佐助", "image/head_12.png", "java Dart Kotlin js ...", "10:35", 12))
        list.add(WxListBean("姿态", "image/head_1.png", "这次旅游回来后我不会再找他了", "9:45", 13))
        list.add(WxListBean("散人哈哈", "image/head_2.png", "@洛克斯•山海 觉醒必须拉满的", "15:45", 14))
        list.add(WxListBean("窒息", "image/head_12.png", "今天过来挑选一下宠物吗周末优惠力度很大", "2:35", 15))
        list.add(WxListBean("公共学习", "image/head_4.png", "您好，请问您这边还需要继续观影吗？", "14:45", 16))

        val messageList1 = ArrayList<WxMessageBean>()
        val messageList2 = ArrayList<WxMessageBean>()
        val messageList3 = ArrayList<WxMessageBean>()
        val messageList4 = ArrayList<WxMessageBean>()
        val messageList5 = ArrayList<WxMessageBean>()
        val messageList6 = ArrayList<WxMessageBean>()
        val messageList7 = ArrayList<WxMessageBean>()
        messageList1.add(WxMessageBean("看你想不想赌了", "", MessageType.MESSAGE, 1))
        messageList1.add(
            WxMessageBean(
                "关键是罗宾已经强势一年了快 现在花两个月升罗宾",
                "image/message_1.png",
                MessageType.IMAGE,
                1
            )
        )
        messageList1.add(WxMessageBean("@洛克斯·小也 这有啥，你其他的辅助都不如罗宾", "", MessageType.MESSAGE, 2))
        messageList1.add(WxMessageBean("升级了又没啥用", "", MessageType.MESSAGE, 2))
        messageList1.add(WxMessageBean("等出了超过罗宾的了", "", MessageType.MESSAGE, 2))
        messageList1.add(WxMessageBean("对 现在是除了罗宾其他没想升的了", "", MessageType.MESSAGE, 1))
        messageList1.add(WxMessageBean("", "image/message_2.png", MessageType.IMAGE, 2))
        messageList1.add(WxMessageBean("", "image/message_4.png", MessageType.IMAGE, 1))
        messageList1.add(WxMessageBean("", "image/message_3.png", MessageType.IMAGE, 2))
        messageList1.add(WxMessageBean("", "image/message_5.png", MessageType.IMAGE, 1))
        messageList1.add(WxMessageBean("", "image/message_6.png", MessageType.IMAGE, 2))
        messageList1.add(WxMessageBean("有美女照片没有?", "", MessageType.MESSAGE, 2))

        map[1] = messageList1
        messageList2.add(WxMessageBean("没事", "", MessageType.MESSAGE, 3))
        messageList2.add(WxMessageBean("习惯了", "", MessageType.MESSAGE, 1))
        messageList2.add(WxMessageBean("", "image/message_7.png", MessageType.IMAGE, 3))
        messageList2.add(WxMessageBean("搞得", "", MessageType.MESSAGE, 3))
        messageList2.add(WxMessageBean("之前超过三次分了三次", "", MessageType.MESSAGE, 3))
        messageList2.add(WxMessageBean("感觉自己不能难受了", "", MessageType.MESSAGE, 1))
        messageList2.add(WxMessageBean("", "image/message_8.png", MessageType.IMAGE, 3))
        messageList2.add(WxMessageBean("再也不想谈恋爱了", "", MessageType.MESSAGE, 3))
        messageList2.add(WxMessageBean("谁信呀", "", MessageType.MESSAGE, 3))
        messageList2.add(WxMessageBean("", "image/message_9.png", MessageType.IMAGE, 1))
        messageList2.add(WxMessageBean("真不想谈了", "", MessageType.MESSAGE, 1))
        messageList2.add(WxMessageBean("", "image/message_10.png", MessageType.IMAGE, 3))
        messageList2.add(WxMessageBean("好好赚钱", "", MessageType.MESSAGE, 3))

        map[2] = messageList2

        messageMap.putAll(map)
        contactList.addAll(list)
        position.addAll(arrayListOf)
    }

    override fun onAbandoned() {
        TODO("Not yet implemented")
    }

    override fun onForgotten() {
        TODO("Not yet implemented")
    }

    override fun onRemembered() {
        TODO("Not yet implemented")
    }
}