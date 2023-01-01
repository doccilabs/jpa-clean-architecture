package team.me.interactor.user

import org.springframework.stereotype.Service
import team.me.dto.user.UserOutbound
import team.me.repository.user.UserRepository
import team.me.usecases.user.UserOutboundUsecase

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
@Service
class UserOutboundInteractor(
    private val userRepository: UserRepository
) : UserOutboundUsecase {

    override fun findById(id: Long): UserOutbound.SimpleResponse {
        TODO("Not yet implemented")
    }
}