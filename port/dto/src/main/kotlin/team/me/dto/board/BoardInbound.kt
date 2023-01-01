package team.me.dto.board

import team.me.domain.entity.Board

sealed class BoardInbound {
    data class CreateRequest(
        var title: String,
        var content: String,
        var userId: Long
    )
}