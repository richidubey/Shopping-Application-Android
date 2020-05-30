package com.example.shopnow;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * Created by user on 11-07-2017.
 */

public class ItemAdapter extends ArrayAdapter<Items>{

    ItemAdapter(Activity context, List<Items> arraylist){
        super(context,0,arraylist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Items items = getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.activity_home_layout,parent,false);
        }

        ImageView imageView = (ImageView)convertView.findViewById(R.id.image_view);
        imageView.setImageBitmap(items.getmImageBitmap());

        TextView textView1 = (TextView)convertView.findViewById(R.id.head_text_view);
        textView1.setText(items.getmNewsHead());

        TextView textView2 = (TextView)convertView.findViewById(R.id.time_text_view);
        textView2.setText(items.getmDateofPublication());

        TextView textView3 = (TextView)convertView.findViewById(R.id.section_text_view);
        textView3.setText(items.getmSection());

        return convertView;
    }
}
