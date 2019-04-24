package com.iotblue.weatherapp.presentation.views;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iotblue.weatherapp.R;
import com.iotblue.weatherapp.data.domain.entities.Bookmark;
import com.iotblue.weatherapp.presentation.adapters.BookmarksListAdapter;
import com.iotblue.weatherapp.presentation.viewmodels.BookmarksListViewModel;
import com.iotblue.weatherapp.presentation.viewmodels.SharedViewModel;

import java.util.List;

public class BookmarksListFragment extends Fragment implements IOnItemClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private BookmarksListViewModel mBookmarksListViewModel;
    private SharedViewModel sharedViewModel;
    private BookmarksListFragment.OnFragmentInteractionListener mListener;

    public static BookmarksListFragment newInstance() {
        return new BookmarksListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_marks_list_fragment, container, false);
        initUIElements(view);
        return view;
    }

    public void initUIElements(View view) {
        //setup recyclerview
        recyclerView = view.findViewById(R.id.bookmarks_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        mBookmarksListViewModel = ViewModelProviders.of(this).get(BookmarksListViewModel.class);
        mBookmarksListViewModel.getAllBookmarks().observe(this, new Observer<List<Bookmark>>() {
            @Override
            public void onChanged(@Nullable List<Bookmark> bookmarkList) {

                //setAdapter for recyclerview
                mAdapter = new BookmarksListAdapter(bookmarkList, getActivity(), BookmarksListFragment.this);
                recyclerView.setAdapter(mAdapter);

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BookmarksListFragment.OnFragmentInteractionListener) {
            mListener = (BookmarksListFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onItemClick(View view, int position, Bookmark bookmark) {

        sharedViewModel.select(bookmark);
        mListener.onFragmentCallback();


    }

    public interface OnFragmentInteractionListener {

        void onFragmentCallback();
    }
}
