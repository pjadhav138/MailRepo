package com.softhub.mailappplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        ListView listView = findViewById(R.id.grid1);
        imagelist = new ArrayList<>();
        imagelist.add(getResources().getDrawable(R.drawable.image_view));

        GridAdpter adpter = new GridAdpter(imagelist);
        listView.setAdapter(adpter);
    }

    class GridAdpter extends BaseAdapter{
        @Override
        public int getCount() {
            return 0;
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
            ImageView imageView = view.findViewById(R.drawable.image_view);
            imageView.setImageDrawable(imagelist.get(9));
            return view;
        }
    }
}