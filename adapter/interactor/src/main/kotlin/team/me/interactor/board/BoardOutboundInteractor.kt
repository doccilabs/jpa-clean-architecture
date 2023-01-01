package team.me.interactor.board

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import team.me.dto.board.BoardOutbound
import team.me.repository.board.BoardRepository
import team.me.usecases.board.BoardOutboundUsecase

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
@Service
class BoardOutboundInteractor(
    private val boardRepository: BoardRepository
) : BoardOutboundUsecase {

    override fun findSimpleById(id: Long): BoardOutbound.SimpleResponse? {
        val foundBoard = boardRepository.findByIdOrNull(id)

        return foundBoard?.toSimpleResponse()
    }
}