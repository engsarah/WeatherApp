package com.iotblue.weatherapp.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.iotblue.weatherapp.R;
import com.iotblue.weatherapp.data.domain.entities.Bookmark;

import java.util.List;

public class BookmarksListAdapter extends RecyclerView.Adapter<BookmarksListAdapter.ItemViewHolder> {

    List<Bookmark> bookmarks;
    Context mContext;

    public BookmarksListAdapter(List<Bookmark> bookmarkList, Context mContext) {
        this.bookmarks = bookmarkList;
        this.mContext = mContext;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BookmarksListAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bookmark_item, parent, false);

        ItemViewHolder viewHolder = new ItemViewHolder(view);

        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        final Bookmark bookmark = bookmarks.get(position);
        holder.cityTxtVw.setText(bookmark.getCountryCode() + ", " + bookmark.getCityName());
        holder.temperatureTxtVw.setText(bookmark.getMaxTemperature());
        holder.updatedAtTxtVw.setText(bookmark.getDate());
//        String url = character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension();
//        Glide.with(mContext).load(url).centerCrop().into(holder.weatherIcon);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return bookmarks.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView cityTxtVw, temperatureTxtVw, updatedAtTxtVw;
        ImageView weatherIcon;

        public ItemViewHolder(View v) {

            super(v);
            cityTxtVw = v.findViewById(R.id.location_name);
            temperatureTxtVw = v.findViewById(R.id.temperature);
            updatedAtTxtVw = v.findViewById(R.id.updatedAt);
            weatherIcon = v.findViewById(R.id.icon);

        }


    }
}