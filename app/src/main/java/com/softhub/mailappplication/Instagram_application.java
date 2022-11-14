package com.softhub.mailappplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Instagram_application extends AppCompatActivity {
    List<Drawable>imagelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instagram);
        GridView listView = findViewById(R.id.list2);
        imagelist = new ArrayList<>();
        imagelist.add(getResources().getDrawable(R.drawable.image_view));
        imagelist.add(getResources().getDrawable(R.drawable.image1));
        imagelist.add(getResources().getDrawable(R.drawable.image_view));
        imagelist.add(getResources().getDrawable(R.drawable.image_view));
        imagelist.add(getResources().getDrawable(R.drawable.image_view));
        imagelist.add(getResources().getDrawable(R.drawable.image_view));
        imagelist.add(getResources().getDrawable(R.drawable.image_view));
        imagelist.add(getResources().getDrawable(R.drawable.image_view));
        imagelist.add(getResources().getDrawable(R.drawable.image_view));
        imagelist.add(getResources().getDrawable(R.drawable.image_view));
        imagelist.add(getResources().getDrawable(R.drawable.image_view));

        GridAdpter adpter = new GridAdpter(imagelist);
        listView.setAdapter(adpter);
    }

    class GridAdpter extends BaseAdapter{
        List<Drawable>list1;
        public GridAdpter(List<Drawable> imagelist) {
            list1 = imagelist;

        }

        @Override
        public int getCount() {
            return list1.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(Instagram_application.this).inflate(R.layout.image_grid_view,parent,false);
            ImageView imageView = view.findViewById(R.id.image1);
            imageView.setImageDrawable(list1.get(position));
            return view;
        }
    }
}