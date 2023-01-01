package team.me.interactor.user

import team.me.domain.entity.User
import team.me.dto.user.UserInbound

fun UserInbound.CreateRequest.toEntity(): User = User(
    id = 0L,
    username = this.username,
    password = this.password,
    email = this.email
)