package team.me.repository.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.me.domain.entity.User

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
@Repository
interface UserRepository : JpaRepository<User, Long>, UserCustomRepository {

}