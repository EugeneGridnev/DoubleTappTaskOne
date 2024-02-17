class TechPush(
    override val text: String,
    override val osVersion: Int
) : Push, OSData {
    override val type: PushType = PushType.TechPush
}