class AgeSpecificPush(
    override val text: String,
    override val age: Int,
    override val expiryDate: Long
) : Push, AgeData, DateData{
    override val type: PushType = PushType.AgeSpecificPush
}