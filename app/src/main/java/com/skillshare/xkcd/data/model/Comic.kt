package com.skillshare.xkcd.data.model

import com.google.gson.annotations.SerializedName

data class Comic(
    @SerializedName("num")
    val id: Int,

    @SerializedName("img")
    val imageUrl: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("alt")
    val altText: String
)