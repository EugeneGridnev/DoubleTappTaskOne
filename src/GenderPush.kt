class GenderPush(
    override val text: String,
    override val gender: Gender
) : Push, GenderData {
    override val type: PushType = PushType.GenderAgePush
}