package com.example.currentplacedetailsonmap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> newsList) {
        super(context, 0, newsList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView titleView = convertView.findViewById(R.id.news_title);
        titleView.setText(currentNews.getTitle());

        TextView descriptionView = convertView.findViewById(R.id.news_description);
        descriptionView.setText(currentNews.getDescription());

        return convertView;
    }
}
