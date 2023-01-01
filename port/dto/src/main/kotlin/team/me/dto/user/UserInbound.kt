package team.me.dto.user

sealed class UserInbound {
    data class CreateRequest(
        var username: String,
        var password: String,
        var email: String
    )
}