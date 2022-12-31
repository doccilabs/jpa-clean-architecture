package team.me.repository

import org.springframework.data.jpa.repository.JpaRepository
import team.me.domain.Board

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
interface BoardRepository : JpaRepository<Board, Long> {

}