package team.me.interactor.board

import team.me.domain.entity.Board
import team.me.dto.board.BoardInbound
import team.me.dto.board.BoardOutbound

fun BoardInbound.CreateRequest.toEntity(): Board = Board(
    id = 0L,
    title = this.title,
    content = this.content,
    userId = this.userId
)

fun Board.toSimpleResponse(): BoardOutbound.SimpleResponse = BoardOutbound.SimpleResponse(
    id = this.id,
    title = this.title
)