package com.skillshare.xkcd.view.main.tabs.todayscomic;

import android.util.Log;

import com.skillshare.xkcd.data.api.XkcdApi;
import com.skillshare.xkcd.data.model.Comic;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TodaysComicPresenter {

    TodaysComicFragment view;
    Comic comic;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    TodaysComicPresenter(TodaysComicFragment view) {
        this.view = view;
    }

    public void attach() {
        Disposable disposable = XkcdApi.INSTANCE.getTodaysComic()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(retrievedComic -> {
                    comic = retrievedComic;
                    updateView();
                }, throwable -> Log.e("TodaysComicPresenter", "Error retrieving comic from API"));
        compositeDisposable.add(disposable);
    }

    private void updateView() {
        view.setAltText(comic.getAltText());
        view.setTitle(comic.getTitle());
        view.setComicImageViewComic(comic.getImageUrl());
    }

    public void onClickComic() {
        if (comic != null) {
            view.launchFullscreenActivity(comic.getId());
        }
    }
}
