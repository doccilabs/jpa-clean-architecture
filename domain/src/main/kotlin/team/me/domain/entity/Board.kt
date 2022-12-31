package team.me.domain.entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import team.me.domain.entity.common.BaseTimeEntity
import javax.persistence.*

/**
 * @author Doyeop Kim
 * @since 2022/12/31
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "board")
class Board(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    var id: Long = 0L,
    @Column(name = "title", nullable = false)
    var title: String = "",
    @Column(name = "content", nullable = false)
    var content: String = "",
    @Column(name = "user_id", nullable = false)
    var userId: Long = 0L
): BaseTimeEntity()