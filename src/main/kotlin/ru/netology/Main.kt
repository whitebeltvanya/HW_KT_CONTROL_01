package ru.netology

fun main() {

    val visitInSecond = listOf(45, 60, 700, 3600, 4500, 75_430, 86_400, 172_800, 259_200, 1000_000)

    for (seconds in visitInSecond) {
        println(agoToText(seconds))
    }

}

fun agoToText(seconds: Int): String {
    val hours = seconds / HOUR_SECOND
    val minutes = (seconds % HOUR_SECOND) / MINUTE_SECOND

    val result = when {
        seconds in 0..MINUTE_SECOND -> "был(а) только что"
        seconds in MINUTE_SECOND+1 until HOUR_SECOND -> "был(а) $minutes ${getMinuteDescr(minutes)} назад"
        seconds in HOUR_SECOND..DAY_SECOND ->
            "был(а) $hours ${getHourDescr(hours)} $minutes ${getMinuteDescr(minutes)} назад"

        seconds in DAY_SECOND + 1..2 * DAY_SECOND -> "был(а) вчера"
        seconds in 2 * DAY_SECOND + 1..3 * DAY_SECOND -> "был(а) позавчера"
        seconds > 3 * DAY_SECOND -> "был(а) давно"
        else -> "Некорректное значение"
    }

    return result
}


fun getHourDescr(hour: Int): String = when (hour) {
    in HOUR_ARR_FIRST -> HOUR_ARR_FIRST_DESCR
    in HOUR_ARR_SECOND -> HOUR_ARR_SECOND_DESCR
    else -> HOUR_DEFAULT_DESCR
}

fun getMinuteDescr(minutes: Int): String = when (minutes) {
    in MINUTE_ARR_FIRST -> MINUTE_ARR_FIRST_DESCR
    in MINUTE_ARR_SECOND -> MINUTE_ARR_SECOND_DESCR
    else -> MINUTE_DEFAULT_DESCR
}