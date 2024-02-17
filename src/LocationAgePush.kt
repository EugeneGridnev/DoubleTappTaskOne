class LocationAgePush(
    override val text: String,
    override val xCoord: Float,
    override val yCoord: Float,
    override val radius: Int,
    override val age: Int
) : Push, AgeData, LocationData {
    override val type: PushType = PushType.LocationAgePush
}