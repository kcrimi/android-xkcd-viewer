package com.skillshare.xkcd.view.main.tabs.todayscomic;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.skillshare.xkcd.R;
import com.skillshare.xkcd.view.fullscreen.FullscreenActivity;

public class TodaysComicFragment extends Fragment {

    private TodaysComicPresenter presenter = new TodaysComicPresenter(this);
    private ImageView comicImageView;
    private TextView altTextView;
    private TextView titleView;

    public TodaysComicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todays_comic, container, false);
        comicImageView = view.findViewById(R.id.todays_comic_image);
        titleView = view.findViewById(R.id.todays_comic_title);
        altTextView = view.findViewById(R.id.todays_comic_alt_text);
        comicImageView.setOnClickListener(v -> presenter.onClickComic());
        return view;
    }

    public void setAltText(String text) {
        altTextView.setText(text);
    }

    public void setTitle(String text) {
        titleView.setText(text);
    }

    public void setComicImageViewComic(String url) {
        Glide.with(this).load(url).into(comicImageView);
    }

    public void launchFullscreenActivity(int comicId) {
        Intent intent = FullscreenActivity.getLaunchIntent(getContext(), comicId);
        getContext().startActivity(intent);
    }
}