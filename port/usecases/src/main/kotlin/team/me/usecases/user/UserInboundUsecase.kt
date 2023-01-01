package team.me.usecases.user

import team.me.domain.entity.User
import team.me.dto.user.UserInbound

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
interface UserInboundUsecase {
    fun register(createRequest: UserInbound.CreateRequest): User
}