package com.sun.data.source.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sun.data.entities.MovieLocal

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movies: List<MovieLocal>)

    @Update
    suspend fun update(movie: MovieLocal)

    @Delete
    suspend fun delete(movie: MovieLocal)

    @Query("SELECT * from movies WHERE id = :id")
    suspend fun getMovie(id: Int): MovieLocal

    @Query("SELECT * from movies")
    suspend fun getAllMovies(): List<MovieLocal>
}
