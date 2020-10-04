package com.skillshare.xkcd.view.main.tabs.todayscomic;

import com.skillshare.xkcd.data.model.Comic;

public class TodaysComicPresenter {

    TodaysComicFragment view;

    TodaysComicPresenter(TodaysComicFragment view) {
        this.view = view;
    }

    public void attach() {
        // TODO call for todays comic
    }

    private void setComic(Comic comic) {
        view.setAltText(comic.getAltText());
        view.setTitle(comic.getTitle());
        view.setComicImageViewComic(comic.getImageUrl(), comic.getId());
    }
}
