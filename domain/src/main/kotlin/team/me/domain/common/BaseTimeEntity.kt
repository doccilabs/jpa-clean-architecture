package team.me.domain.common

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

/**
 * @author Doyeop Kim
 * @since 2022/12/31
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseTimeEntity(
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null,
    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null
)