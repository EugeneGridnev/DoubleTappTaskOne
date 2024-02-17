class GenderAgePush(
    override val text: String,
    override val age: Int,
    override val gender: Gender
) : Push, AgeData, GenderData {
    override val type: PushType = PushType.GenderAgePush
}