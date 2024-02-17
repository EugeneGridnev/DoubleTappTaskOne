import kotlin.math.pow
import kotlin.math.sqrt

class System(
    val time: Long,
    val age: Int,
    val gender: Gender,
    val osVersion: Int,
    val xCoord: Float,
    val yCoord: Float
) {
    fun filterByLocation(push: Push): Boolean {
        if (push !is LocationData) return true

        return (sqrt((push.xCoord - this.xCoord).pow(2) + (push.yCoord - this.yCoord).pow(2)) <= push.radius)
    }

    fun filterByAge(push: Push): Boolean {
        if (push !is AgeData) return true

        return (push.age <= this.age)
    }

    fun filterByOSVersion(push: Push): Boolean {
        if (push !is OSData) return true

        return (this.osVersion <= push.osVersion)
    }

    fun filterByExpDate(push: Push): Boolean {
        if (push !is DateData) return true

        return (push.expiryDate >= this.time)
    }

    fun filterByGender(push: Push): Boolean {
        if (push !is GenderData) return true

        return (push.gender == this.gender)
    }


}