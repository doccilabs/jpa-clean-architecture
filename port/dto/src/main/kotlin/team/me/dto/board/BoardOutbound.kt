package team.me.dto.board

sealed class BoardOutbound {
    data class SimpleResponse(
        var id: Long,
        var title: String
    )
}