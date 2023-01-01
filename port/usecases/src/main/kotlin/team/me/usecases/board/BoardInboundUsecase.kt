package team.me.usecases.board

import team.me.domain.entity.Board
import team.me.dto.board.BoardInbound

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
interface BoardInboundUsecase {
    fun postBoard(createRequest: BoardInbound.CreateRequest): Board
}