package com.feedsnow.sagar.feedsnow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.feedsnow.sagar.feedsnow.R;
import com.feedsnow.sagar.feedsnow.activity.WebViewActivity;
import com.feedsnow.sagar.feedsnow.adapter.NewsAdapter;
import com.feedsnow.sagar.feedsnow.model.News;
import com.feedsnow.sagar.feedsnow.model.NewsResource;
import com.feedsnow.sagar.feedsnow.util.ApiClient;
import com.feedsnow.sagar.feedsnow.util.ApiResponse;
import com.feedsnow.sagar.feedsnow.util.Internet;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.feedsnow.sagar.feedsnow.model.Contents.API_KEY;
import static com.feedsnow.sagar.feedsnow.model.Contents.CATEGORY_SCIENCE;
import static com.feedsnow.sagar.feedsnow.model.Contents.COUNTRY;

public class ScienceFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    View view;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<News> newsArrayList = new ArrayList<>();
    private NewsAdapter mAdapter;
    private ListView listView;

    public ScienceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fragment_news, container, false);
        initViews();

        return view;
    }

    private void initViews() {

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.colorAccent,
                R.color.colorGreen,
                R.color.colorBlue,
                R.color.colorOrange);
        loadJSON();

        listView = view.findViewById(R.id.list_View);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news = mAdapter.getItem(position);
                Intent title_Intent = new Intent(getActivity(), WebViewActivity.class);
                title_Intent.putExtra("url", news.getUrl());
                startActivity(title_Intent);
            }
        });
    }

    private void loadJSON() {
        swipeRefreshLayout.setRefreshing(true);

        if (Internet.checkConnection(getContext())) {
            ApiResponse request = ApiClient.getApiService();

            Call<NewsResource> call = request.getCategoryOfHeadlines(COUNTRY, CATEGORY_SCIENCE, API_KEY);
            call.enqueue(new Callback<NewsResource>() {

                @Override
                public void onResponse(Call<NewsResource> call, Response<NewsResource> response) {

                    if (response.isSuccessful() && response.body().getArticles() != null) {
                        swipeRefreshLayout.setRefreshing(false);
                        if (!newsArrayList.isEmpty()) {
                            newsArrayList.clear();
                        }

                        newsArrayList = response.body().getArticles();
                        mAdapter = new NewsAdapter(getActivity(), newsArrayList);
                        listView.setAdapter(mAdapter);
                    }
                }

                @Override
                public void onFailure(Call<NewsResource> call, Throwable t) {
                    swipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(getActivity(), "Something went wrong...", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(getActivity(), "Internet connection not Available", Toast.LENGTH_SHORT).show();
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        loadJSON();
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}
