class LocationPush(
    override val text: String,
    override val xCoord: Float,
    override val yCoord: Float,
    override val radius: Int,
    override val expiryDate: Long
) : Push, DateData, LocationData {
    override val type: PushType = PushType.LocationPush
}