package com.shayian.midtermexam.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shayian.midtermexam.R;
import com.shayian.midtermexam.adapter.BookAdapter;
import com.shayian.midtermexam.apis.BookApi;
import com.shayian.midtermexam.models.Book;

import java.util.List;

/**
 * A placeholder fragment containing a {@link ListView}.
 */
public class ListViewFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mListView;

    private List<Book> LBook;

    public static ListViewFragment newInstance() {
        return new ListViewFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LBook= BookApi.getBook(" http://joseniandroid.herokuapp.com/api/books", "GET");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listview, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // find all the views
        mListView = (ListView) view.findViewById(R.id.listView);

        // create a new instance of adapter
        BookAdapter adapter = new BookAdapter(getActivity(),
                R.layout.list_item, LBook);

        // set the adapter
        mListView.setAdapter(adapter);

        // set item click listener
        mListView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
