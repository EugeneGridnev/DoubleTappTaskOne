
fun main() {
    val system: System = enterSysParams()
    val pushCount = enterPushCount()
    var pushList = (1..pushCount).map {enterPushParam()}
    var result = pushList.filter { system.filterByLocation(it) }
        .filter { system.filterByAge(it) }
        .filter { system.filterByOSVersion(it) }
        .filter { system.filterByExpDate(it) }
        .filter { system.filterByGender(it) }
        .map { it.text }
    if (result.isEmpty()) {
        println(-1)
    } else {
        result.forEach{println(it)}
    }
}

fun enterSysParams(): System {
    var time: Long = 0
    var age: Int = 0
    var gender: Gender = Gender.Female
    var osVersion: Int = 0
    var xCoord: Float = 0.0F
    var yCoord: Float = 0.0F

    for (i in 1..6) {
        val (param, value ) = enterPushParamValue()
        when (param) {
            "time" -> time = value.toLong()
            "age" -> age = value.toInt()
            "gender" -> gender = Gender.entries.first{ it.s == value}
            "os_version" -> osVersion = value.toInt()
            "x_coord" -> xCoord = value.toFloat()
            "y_coord" -> yCoord = value.toFloat()
        }
    }

    return System(
        time = time,
        age = age,
        gender = gender,
        osVersion = osVersion,
        xCoord = xCoord,
        yCoord = yCoord
    )

}

fun enterPushCount(): Int{
    return readln().toInt()
}

fun enterPushParamValue(): Pair<String, String> {
    val (a, b) = readln().split(" ")
    return a to b
}

fun enterPushParam(): Push {
    val map: Map<String, String> = (1..enterPushCount()).associate { enterPushParamValue() }
    return when(PushType.valueOf(map["type"]!!)){
        PushType.LocationPush -> LocationPush(map["text"]!!, map["x_coord"]!!.toFloat(), map["y_coord"]!!.toFloat(), map["radius"]!!.toInt(), map["expiry_date"]!!.toLong())
        PushType.AgeSpecificPush -> AgeSpecificPush(map["text"]!!, map["age"]!!.toInt(), map["expiry_date"]!!.toLong())
        PushType.TechPush -> TechPush(map["text"]!!, map["os_version"]!!.toInt())
        PushType.LocationAgePush -> LocationAgePush(map["text"]!!, map["x_coord"]!!.toFloat(), map["y_coord"]!!.toFloat(), map["radius"]!!.toInt(), map["age"]!!.toInt())
        PushType.GenderAgePush -> GenderAgePush(map["text"]!!, map["age"]!!.toInt(), Gender.entries.first{ it.s == map["gender"]})
        PushType.GenderPush -> GenderPush(map["text"]!!, Gender.entries.first{ it.s == map["gender"]})
    }
}