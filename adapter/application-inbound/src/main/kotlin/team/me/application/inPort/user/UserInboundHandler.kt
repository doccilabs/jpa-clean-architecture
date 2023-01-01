package team.me.application.inPort.user

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.me.domain.entity.User
import team.me.dto.user.UserInbound
import team.me.usecases.user.UserInboundUsecase

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
@RestController
@RequestMapping("/api/v1/user")
class UserInboundHandler(
    private val userInboundUsecase: UserInboundUsecase
) {

    @PostMapping("/")
    fun register(request: UserInbound.CreateRequest): ResponseEntity<User> {
        val registerResult = userInboundUsecase.register(request)

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(registerResult)
    }
}