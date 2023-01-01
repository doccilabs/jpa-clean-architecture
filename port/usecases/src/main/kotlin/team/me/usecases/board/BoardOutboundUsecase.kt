package team.me.usecases.board

import team.me.dto.board.BoardOutbound

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
interface BoardOutboundUsecase {

    fun findSimpleById(id: Long): BoardOutbound.SimpleResponse?
}