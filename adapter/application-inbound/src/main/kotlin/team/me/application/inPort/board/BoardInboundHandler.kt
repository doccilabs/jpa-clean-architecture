package team.me.application.inPort.board

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.me.domain.entity.Board
import team.me.dto.board.BoardInbound
import team.me.usecases.board.BoardInboundUsecase

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
@RestController
@RequestMapping("/api/v1/board")
class BoardInboundHandler(
    private val boardInboundUsecase: BoardInboundUsecase
) {

    @PostMapping("/")
    fun postBoard(@RequestBody request: BoardInbound.CreateRequest): ResponseEntity<Board> {
        val postResult = boardInboundUsecase.postBoard(request)

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(postResult)
    }
}