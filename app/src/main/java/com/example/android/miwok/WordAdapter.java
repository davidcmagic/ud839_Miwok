package com.example.android.miwok;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by David on 2/23/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }

        Word currentWord = getItem(position);


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
                               imageView.setVisibility(View.VISIBLE);
                   } else {
                                imageView.setVisibility(View.GONE);
                    }

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
