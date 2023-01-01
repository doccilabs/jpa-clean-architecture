package team.me.repository.board

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.me.domain.entity.Board

/**
 * @author Doyeop Kim
 * @since 2023/01/01
 */
@Repository
interface BoardRepository : JpaRepository<Board, Long>, BoardCustomRepository {

}