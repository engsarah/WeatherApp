package com.iotblue.weatherapp.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.iotblue.weatherapp.R;
import com.iotblue.weatherapp.data.domain.entities.Bookmark;
import com.iotblue.weatherapp.presentation.views.IOnItemClickListener;

import java.util.List;

public class BookmarksListAdapter extends RecyclerView.Adapter<BookmarksListAdapter.ItemViewHolder> {

    List<Bookmark> bookmarks;
    Context mContext;
    IOnItemClickListener iOnItemClickListener;

    public BookmarksListAdapter(List<Bookmark> bookmarkList, Context mContext, IOnItemClickListener iOnItemClickListener) {
        this.bookmarks = bookmarkList;
        this.mContext = mContext;
        this.iOnItemClickListener = iOnItemClickListener;
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
    public void onBindViewHolder(ItemViewHolder holder, final int position) {

        final Bookmark bookmark = bookmarks.get(position);
        holder.addressTxtVw.setText(bookmark.getAddress());
        holder.addressTxtVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnItemClickListener.onItemClick(v, position, bookmark);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnItemClickListener.onItemClick(v, position, bookmark);
            }
        });
        //  String url = character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension();
        //  Glide.with(mContext).load(url).centerCrop().into(holder.weatherIcon);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return bookmarks.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView addressTxtVw;
        public ItemViewHolder(View v) {

            super(v);
            addressTxtVw = v.findViewById(R.id.location_name);


        }


    }
}