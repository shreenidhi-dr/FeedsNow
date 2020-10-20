package com.feedsnow.sagar.feedsnow.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/*
import com.example.prans.news.R;
import com.example.prans.news.model.News;*/
import com.feedsnow.sagar.feedsnow.R;
import com.feedsnow.sagar.feedsnow.model.News;
import com.squareup.picasso.Picasso;

import java.util.List;



public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(@NonNull Context context, List<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.news_item, parent, false);
        }

        News news = getItem(position);

        TextView tv_title = view.findViewById(R.id.title);
        if (news != null) {
            tv_title.setText(news.getTitle());
        }

        ImageView urlToImage = view.findViewById(R.id.urlToImage);

        if (TextUtils.isEmpty(news.getUrlToImage())) {
            Picasso.get()
                    .load(news.getUrlToImage())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(urlToImage);
        } else {
            Picasso
                    .get()
                    .load(news.getUrlToImage())

                    .resize(150, 150)
                    .centerCrop()
                    .into(urlToImage);
        }
        Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.fade);
        view.startAnimation(animation);
        return view;

    }

}