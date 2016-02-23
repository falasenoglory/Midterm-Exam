package com.shayian.midtermexam.apis;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.shayian.midtermexam.models.Book;
import com.shayian.midtermexam.utils.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 2/23/2016.
 */
public class BookApi {

    public static ArrayList<Book> LBook;
    public static final String BASE_URL     = "http://172.17.3.51:5856/api/books";

    public static ArrayList<Book> getBook(String uri, @NonNull String requestMethod) {
        String json = HttpUtils.getResponse(uri, requestMethod);

        if (TextUtils.isEmpty(json)) {
            return null;
        }

        String id;
        String title;
        String genre;
        String author;
        boolean isRead;


            try {
                JSONArray jsonarray = new JSONArray(json);
                for(int i=0;i<jsonarray.length();i++) {

                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    id=jsonobject.getString("_id");
                    title=jsonobject.getString("title");
                    genre=jsonobject.getString("genre");
                    author=jsonobject.getString("author");
                    isRead=jsonobject.getBoolean("isRead");

                    LBook.add(new Book(id,title,genre,author,isRead));
                }
                return LBook;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }




    }


}
