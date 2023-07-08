package dev.faderainbow.circlep.utils

import kotlin.random.Random

/**
 *@author FadeRainbow
 *@date 2023/7/8
 *@time 12:14
 */
object RandomUtils {
private val CODE_SEQ = charArrayOf(
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
    'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
    'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j',
    'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
    'x', 'y', 'z','1', '2', '3', '4', '5', '6', '7', '8', '9' ,
    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
    'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
    'x', 'y', 'z',
)
    fun randomString(length: Int): String {
        val sb = StringBuilder()
        repeat(length) {
            sb.append(CODE_SEQ[Random.nextInt(CODE_SEQ.size)])
        }
        return sb.toString()
    }

    fun randomLength(min: Int, max: Int): Int {
        return Random.nextInt(min, max)
    }
}