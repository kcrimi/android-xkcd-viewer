package com.skillshare.xkcd.view.fullscreen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.skillshare.xkcd.data.api.XkcdApi
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FullscreenViewModel {

    var title = MutableLiveData<String>()
    var altText = MutableLiveData<String>()
    var url = MutableLiveData<String>()
    private val compositeDisposable = CompositeDisposable()

    fun attach(comicId: Int) {
        val disposable = XkcdApi.getComic(comicId)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(
                {
                    title.postValue(it.title)
                    altText.postValue(it.altText)
                    url.postValue(it.imageUrl)
                },
                {
                    Log.e("FullScreenVideoModel", "Error retrieving comic data")
                })
        compositeDisposable.add(disposable)
    }

    fun detach() {
        compositeDisposable.clear()
    }
}