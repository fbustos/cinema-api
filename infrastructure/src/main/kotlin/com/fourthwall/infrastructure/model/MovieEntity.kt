package com.fourthwall.infrastructure.model

import com.fourthwall.core.domain.model.Movie
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "movie")
class MovieEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    @Column(nullable = false)
    val id: UUID? = null,

    @Column(nullable = false)
    val imdbId: String? = null,

    @Column(nullable = false)
    val title: String? = null,

    @Column(nullable = false)
    val price: BigDecimal? = null,

    @Column(nullable = true)
    @OneToMany(cascade = [CascadeType.ALL])
    val times: List<MovieTimeEntity>? = null
) {
    fun toDomain(): Movie {
        return Movie(id!!.toString(), imdbId!!, title!!, price!!, times?.map { it.toDomain() } ?: emptyList())
    }
}