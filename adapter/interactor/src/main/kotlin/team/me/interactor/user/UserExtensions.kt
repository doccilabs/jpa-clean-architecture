package team.me.interactor.user

import team.me.domain.entity.User
import team.me.dto.user.UserInbound
import team.me.dto.user.UserOutbound

fun UserInbound.CreateRequest.toEntity(): User = User(
    id = 0L,
    username = this.username,
    password = this.password,
    email = this.email
)

fun User.toSimpleResponse(): UserOutbound.SimpleResponse = UserOutbound.SimpleResponse(
    id = this.id,
    username = this.username,
    email = this.email
)