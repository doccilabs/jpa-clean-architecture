package team.me.interactor.board

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import team.me.domain.entity.Board
import team.me.dto.board.BoardInbound
import team.me.dto.board.BoardOutbound
import team.me.repository.board.BoardRepository
import team.me.usecases.board.BoardInboundUsecase

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
@Service
class BoardInboundInteractor(
    private val boardRepository: BoardRepository
) : BoardInboundUsecase {
    override fun postBoard(createRequest: BoardInbound.CreateRequest): Board {
        val board = createRequest.toEntity()
        val createdBoard = boardRepository.save(board)

        return createdBoard
    }
}