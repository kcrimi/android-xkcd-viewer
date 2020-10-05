package com.skillshare.xkcd.data.api

import com.skillshare.xkcd.data.model.Comic
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object XkcdApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://xkcd.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private val service  = retrofit.create(XkcdService::class.java)

    fun getTodaysComic(): Single<Comic> {
        return service.getTodaysComic()
    }

    fun getComic(comicId: Int): Single<Comic> {
        return service.getComic(comicId)
    }
}