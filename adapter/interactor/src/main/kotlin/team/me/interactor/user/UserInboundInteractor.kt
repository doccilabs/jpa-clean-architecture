package team.me.interactor.user

import org.springframework.stereotype.Service
import team.me.domain.entity.User
import team.me.dto.user.UserInbound
import team.me.dto.user.UserOutbound
import team.me.repository.user.UserRepository
import team.me.usecases.user.UserInboundUsecase

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
@Service
class UserInboundInteractor(
    private val userRepository: UserRepository
) : UserInboundUsecase {

    override fun register(createRequest: UserInbound.CreateRequest): User {
        val user = createRequest.toEntity()
        val createdUser = userRepository.save(user)

        return createdUser
    }
}