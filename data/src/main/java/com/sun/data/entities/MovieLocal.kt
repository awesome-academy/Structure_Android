package com.sun.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sun.data.Mapper
import com.sun.domain.entities.MovieEntity

@Entity(tableName = "movies")
data class MovieLocal(
    @PrimaryKey
    var id: Int = -1,
    val description: String,
    val image: String,
    val backgroundUrl: String,
    val title: String,
    val category: String,
) : Mapper<MovieEntity, Any, MovieRemote>() {
    override fun mapToEntity(): MovieEntity {
        return MovieEntity(id = id,title = title, description = description, image = image, category = "ABC", backgroundUrl = backgroundUrl )
    }

    override fun mapToRemote(): MovieRemote {
        return MovieRemote()
    }
}
