package com.fourthwall.infrastructure.model

import com.fourthwall.core.domain.model.Movie
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "movie_time")
class MovieTimeEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    @Column(nullable = false)
    val id: UUID? = null,

    @Column(nullable = false)
    val time: String? = null
) {
    fun toDomain(): Movie.MovieTime {
        return Movie.MovieTime(id!!.toString(), time!!.toString())
    }
}