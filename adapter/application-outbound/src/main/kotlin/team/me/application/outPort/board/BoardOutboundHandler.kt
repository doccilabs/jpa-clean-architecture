package team.me.application.outPort.board

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import team.me.dto.board.BoardOutbound
import team.me.usecases.board.BoardOutboundUsecase
import java.lang.RuntimeException

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
@RestController
@RequestMapping("/api/v1/board")
class BoardOutboundHandler(
    private val boardOutboundUsecase: BoardOutboundUsecase
) {
    @GetMapping("/simple")
    fun getSimpleBoardById(@RequestParam id: Long): ResponseEntity<BoardOutbound.SimpleResponse> {
        val foundBoardResponse = boardOutboundUsecase.findSimpleById(id)
            ?: throw RuntimeException()

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(foundBoardResponse)
    }
}