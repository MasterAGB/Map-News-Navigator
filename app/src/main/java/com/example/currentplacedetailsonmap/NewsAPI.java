package com.example.currentplacedetailsonmap;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPI {
    @GET("v2/everything")
    Call<NewsResponse> getNews(@Query("q") String query,
                               @Query("from") String from,
                               @Query("sortBy") String sortBy,
                               @Query("apiKey") String apiKey);
}
