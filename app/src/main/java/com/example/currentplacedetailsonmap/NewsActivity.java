package com.example.currentplacedetailsonmap;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        // Get yesterday's date
        LocalDate yesterday = LocalDate.now().minusDays(3);

// Format as string in 'YYYY-MM-DD' format
        String yesterdayStr = yesterday.format(DateTimeFormatter.ISO_LOCAL_DATE);


        Call<NewsResponse> call = newsAPI.getNews("tesla", yesterdayStr, "publishedAt", "80b0943235d84bf58911365012903eba");
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                NewsResponse newsResponse = response.body();
                if (newsResponse == null || newsResponse.getArticles() == null || newsResponse.getArticles().isEmpty()) {
                    Log.e("NewsActivity", "No news found or there was an error retrieving the news.");
                    // If the response body is null, log the entire response for debugging.
                    if (response.errorBody() != null) {
                        try {
                            // Log the error body
                            Log.e("NewsActivity", "Error response: " + response.errorBody().string());
                        } catch (IOException e) {
                            Log.e("NewsActivity", "Error while reading the error response", e);
                        }
                    } else {
                        // Log the raw response if the error body is also null
                        Log.e("NewsActivity", "Response was null. Raw response: " + response.raw().toString());
                    }
                    // Handle the case when the newsResponse is null or the articles list is empty
                    // You can update the UI here to inform the user that no news was found.
                    return;
                }
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
