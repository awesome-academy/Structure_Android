package com.sun.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieDbData(
    @PrimaryKey
    var id: Int = -1,
    val description: String,
    val image: String,
    val backgroundUrl: String,
    val title: String,
    val category: String,
    )
