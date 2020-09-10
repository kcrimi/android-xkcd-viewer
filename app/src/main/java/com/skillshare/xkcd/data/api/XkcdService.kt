package com.skillshare.xkcd.data.api

import com.skillshare.xkcd.data.model.Comic
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface XkcdService {
    @GET("info.0.json")
    fun getCurrentComic() : Single<Comic>

    @GET("{comicId}/info.0.json")
    fun getComic(@Path("comicId") comicId: Int) : Single<Comic>
}