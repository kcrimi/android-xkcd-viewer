package com.skillshare.xkcd.view.component.comicimageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.skillshare.xkcd.R;

public class ComicImageView extends RelativeLayout {

    private final ImageView comicImageView;

    public ComicImageView(Context context) {
        this(context, null);
    }

    public ComicImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ComicImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);

    }

    public ComicImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        View view = View.inflate(context, R.layout.view_comic_view, this);
        comicImageView = view.findViewById(R.id.comic_image_view);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Open full screen activity
            }
        });
    }
}