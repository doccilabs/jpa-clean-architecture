package team.me.domain

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import team.me.domain.common.BaseTimeEntity
import javax.persistence.*

/**
 * @author Doyeop Kim
 * @since 2022/12/31
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    var id: Long = 0L,
    @Column(name = "username", nullable = false)
    var username: String = "",
    @Column(name = "password", nullable = false)
    var password: String = "",
    @Column(name = "email", nullable = false)
    var email: String = ""
): BaseTimeEntity()