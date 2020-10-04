package com.skillshare.xkcd.view.main.tabs.todayscomic;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skillshare.xkcd.R;
import com.skillshare.xkcd.view.component.comicimageview.ComicImageView;

public class TodaysComicFragment extends Fragment {

    private ComicImageView comicImageView;
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
        comicImageView = view.findViewById(R.id.todays_comic_comic_image);
        titleView = view.findViewById(R.id.todays_comic_title);
        altTextView = view.findViewById(R.id.todays_comic_alt_text);
        return view;
    }
}