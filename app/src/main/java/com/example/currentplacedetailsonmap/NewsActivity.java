package com.example.currentplacedetailsonmap;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        listView = findViewById(R.id.listView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsAPI newsAPI = retrofit.create(NewsAPI.class);

        Call<NewsResponse> call = newsAPI.getNews("tesla", "2023-09-27", "publishedAt", "80b0943235d84bf58911365012903eba");

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                NewsResponse newsResponse = response.body();
                List<News> newsList = newsResponse.getArticles();

                // Create an adapter and attach it to the ListView
                NewsAdapter adapter = new NewsAdapter(NewsActivity.this, newsList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }
}
