package com.skillshare.xkcd.view.main.tabs.todayscomic;

import com.skillshare.xkcd.data.model.Comic;

public class TodaysComicPresenter {

    TodaysComicFragment view;
    Comic comic;

    TodaysComicPresenter(TodaysComicFragment view) {
        this.view = view;
    }

    public void attach() {
        // TODO call for todays comic
    }

    private void updateView() {
        view.setAltText(comic.getAltText());
        view.setTitle(comic.getTitle());
        view.setComicImageViewComic(comic.getImageUrl(), comic.getId());
    }

    public void onClickComic() {
        if (comic != null) {
            view.launchFullscreenActivity(comic.getId());
        }
    }
}
