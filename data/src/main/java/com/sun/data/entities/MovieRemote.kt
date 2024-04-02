package com.sun.data.entities

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sun.data.Mapper
import com.sun.domain.entities.MovieEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieRemote(
    @SerializedName("id")
    @Expose
    var id: Int = -1,
    @SerializedName("backdrop_path")
    @Expose
    var backDropImage: String = "",
    @SerializedName("overview")
    @Expose
    var overView: String = "",
    @SerializedName("vote_average")
    @Expose
    var vote: Double = 0.0,
    @SerializedName("vote_count")
    @Expose
    var voteCount: Int = 0,
    @SerializedName("title")
    @Expose
    var title: String = "",
    @SerializedName("poster_path")
    @Expose
    var urlImage: String = "",
    @SerializedName("original_title")
    @Expose
    var originalTitle: String = ""
) : Parcelable, Mapper<MovieEntity, MovieLocal, Any>() {
    override fun mapToEntity(): MovieEntity {
        return MovieEntity(
            id = id,
            title = title,
            description = overView,
            image = urlImage,
            category = "ABC",
            backgroundUrl = backDropImage
        )
    }

    override fun mapToLocal(): MovieLocal {
        return MovieLocal(
            id = id,
            description = overView,
            image = urlImage,
            backgroundUrl = backDropImage,
            title = title,
            category = "ABC"
        )
    }
}
