package team.me.application.outPort.user

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import team.me.dto.user.UserOutbound
import team.me.usecases.user.UserOutboundUsecase
import java.lang.RuntimeException

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
@RestController
@RequestMapping("/api/v1/user")
class UserOutboundHandler(
    private val userOutboundUsecase: UserOutboundUsecase
) {

    @GetMapping("/simple")
    fun getSimpleUser(@RequestParam id: Long): ResponseEntity<UserOutbound.SimpleResponse> {
        val foundUserResponse = userOutboundUsecase.findById(id)
            ?: throw RuntimeException()

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(foundUserResponse)
    }
}