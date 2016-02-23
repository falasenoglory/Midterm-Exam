package com.shayian.midtermexam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.shayian.midtermexam.R;
import com.shayian.midtermexam.models.Book;

import java.util.List;

/**
 * Created by Shanyl Jimenez on 2/23/2016.
 */
public class BookAdapter extends ArrayAdapter<Book> {

    private Context mContext;
    private int    mLayoutId;
    private List<Book> mBooks;

    public BookAdapter(Context context, int resource, List<Book> movies) {
        super(context, resource, movies);

        mContext = context;
        mLayoutId = resource;
        mBooks = movies;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            // Inflate the layout
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);

            // create the view holder
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.txtBookName);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set the movie data
        Book book = mBooks.get(position);

        if (book != null) {
            if (viewHolder.tvName != null) {
                viewHolder.tvName.setText(book.getTitle());
            }
        }

        return convertView;
    }

    private static class ViewHolder {
        public TextView  tvName;
    }



}
