package dev.faderainbow.circlep.ui.helper

import dev.faderainbow.circlep.utils.RandomUtils
import kotlin.random.Random

/**
 *@author FadeRainbow
 *@date 2023/7/9
 *@time 11:05
 */
object GiftHelper {
    /**
     * 祈愿系统辅助
     */
    private val playerList = listOf(
        "白术",
        "迪希雅",
        "艾尔海森",
        "流浪者",
        "纳西妲",
        "妮露",
        "赛诺",
        "提纳里",
        "夜兰",
        "神里绫人",
        "八重神子",
        "申鹤",
        "荒泷一斗",
        "珊瑚宫心海",
        "埃洛伊",
        "雷电将军",
        "宵宫",
        "神里绫华",
        "枫原万叶",
        "优菈",
        "胡桃",
        "魈",
        "甘雨",
        "阿贝多",
        "钟离",
        "达达利亚",
        "可莉",
        "温迪",
        "七七",
        "刻晴",
        "旅行者 (无)",
        "旅行者 派蒙 旅行者 (草)",
        "旅行者/草 旅行者 (岩)",
        "旅行者/岩 旅行者 (雷)",
        "旅行者/雷 旅行者 (风)",
        "旅行者/风",
        "琴",
        "莫娜",
        "迪卢克,",
        "绮良良",
        "卡维",
        "米卡",
        "瑶瑶",
        "珐露珊",
        "莱依拉",
        "坎蒂丝",
        "多莉",
        "柯莱",
        "鹿野院平藏",
        "久岐忍",
        "云堇",
        "五郎",
        "托马",
        "九条裟罗",
        "早柚",
        "烟绯",
        "罗莎莉亚",
        "辛焱",
        "迪奥娜",
        "丽莎",
        "凝光",
        "凯亚",
        "北斗",
        "安柏",
        "班尼特",
        "砂糖",
        "芭芭拉",
        "菲谢尔",
        "行秋",
        "诺艾尔",
        "重云",
        "雷泽",
        "香菱"
    )

     fun randomPlayer(): String {
        val sb = StringBuilder()
        repeat(1) {
            sb.append(playerList[Random.nextInt(playerList.size)])
        }
        return sb.toString()
    }
}