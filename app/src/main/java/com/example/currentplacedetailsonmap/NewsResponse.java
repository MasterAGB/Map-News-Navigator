package com.example.currentplacedetailsonmap;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public class NewsResponse {
    private List<News> articles;

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }
}
