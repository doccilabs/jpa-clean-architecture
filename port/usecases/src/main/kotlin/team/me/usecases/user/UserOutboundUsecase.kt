package team.me.usecases.user

import team.me.dto.user.UserOutbound

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
interface UserOutboundUsecase {

    fun findById(id: Long): UserOutbound.SimpleResponse?
}