package team.me.dto.user

sealed class UserOutbound {
    data class SimpleResponse(
        var id: Long,
        var username: String,
        var email: String
    )
}