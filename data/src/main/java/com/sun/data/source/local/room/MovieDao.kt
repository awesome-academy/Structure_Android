package com.sun.data.source.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movies: List<com.sun.data.entities.MovieData>)

    @Update
    suspend fun update(movie: com.sun.data.entities.MovieData)

    @Delete
    suspend fun delete(movie: com.sun.data.entities.MovieData)

    @Query("SELECT * from movies WHERE id = :id")
    suspend fun getMovie(id: Int): com.sun.data.entities.MovieData

    @Query("SELECT * from movies")
    suspend fun getAllMovies(): List<com.sun.data.entities.MovieData>
}
