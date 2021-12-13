package com.fourthwall.infrastructure.repository

import com.fourthwall.infrastructure.model.MovieEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MovieRepository : JpaRepository<MovieEntity, UUID>