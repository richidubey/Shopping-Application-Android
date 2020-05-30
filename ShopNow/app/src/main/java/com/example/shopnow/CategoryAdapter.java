package com.example.shopnow;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11-07-2017.
 */

public class CategoryAdapter extends ArrayAdapter<Categories>{

    CategoryAdapter(Activity context, List<Categories> arraylist){
        super(context,0,arraylist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Categories items = getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.activity_category_layout,parent,false);
        }

        final List<String> addToCartList = new ArrayList<>();

        ImageView imageView = (ImageView)convertView.findViewById(R.id.image_view);
        imageView.setImageBitmap(items.getmImageBitmap());

        final TextView textView1 = (TextView)convertView.findViewById(R.id.head_text_view);
        textView1.setText(items.getmNewsHead());

        TextView textView2 = (TextView)convertView.findViewById(R.id.time_text_view);
        textView2.setText(items.getmDateofPublication());

        TextView textView3 = (TextView)convertView.findViewById(R.id.section_text_view);
        textView3.setText(items.getmSection());

        RatingBar ratingBar = (RatingBar)convertView.findViewById(R.id.rating);
        ratingBar.setRating(5);

        final TextView countItems = (TextView)convertView.findViewById(R.id.countTextView);


        Button decrement = (Button)convertView.findViewById(R.id.decrementButton);
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemSelected = Integer.parseInt(countItems.getText().toString());
                if(itemSelected<=0){
                    Toast.makeText(getContext(),"Cannot decrement further", Toast.LENGTH_SHORT).show();
                }else{
                    itemSelected--;
                    StringBuilder allitems = new StringBuilder();
                    for(int i=0;i<addToCartList.size();i++){
                        allitems.append(addToCartList.get(i)+"; ");
                    }
                    if(addToCartList.size()>0) {
                        Toast.makeText(getContext(), allitems, Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), addToCartList.get(addToCartList.size() - 1) + " removed from cart", Toast.LENGTH_LONG).show();
                    }
                    String itemname = textView1.getText().toString();
                    addToCartList.remove(itemname);
//                    Toast.makeText(getContext(),itemname+" removed from cart", Toast.LENGTH_SHORT).show();
                    countItems.setText(Integer.toString(itemSelected));

                }
            }
        });

        Button increment = (Button)convertView.findViewById(R.id.incrementButton);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemSelected = Integer.parseInt(countItems.getText().toString());
                if(itemSelected>=10){
                    Toast.makeText(getContext(),"Cannot increment further", Toast.LENGTH_SHORT).show();
                }else{
                    itemSelected++;
                    String itemname = textView1.getText().toString();
                    addToCartList.add(itemname);
                    //Toast.makeText(getContext(),itemname+" added from cart", Toast.LENGTH_SHORT).show();
                    countItems.setText(Integer.toString(itemSelected));
                    //Toast.makeText(getContext(), addToCartList.get(addToCartList.size()-1), Toast.LENGTH_LONG).show();
                    StringBuilder allitems = new StringBuilder();
                    for(int i=0;i<addToCartList.size();i++){
                        allitems.append(addToCartList.get(i)+"; ");
                    }
                    Toast.makeText(getContext(), allitems, Toast.LENGTH_LONG).show();
                }
            }
        });

//        Intent intent = new Intent("custom-message");
//        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
//        intent.putExtra("quantity",125);
//        intent.putExtra("item","Apple");

        return convertView;
    }
}
