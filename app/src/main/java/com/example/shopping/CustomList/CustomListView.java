package com.example.shopping.CustomList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shopping.R;

public class CustomListView extends AppCompatActivity {

    private CutomAdapterList cutomAdapterList;
    private ListView listView;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        listView = findViewById(R.id.custom_list);
        String[] tittle = {"Tarun", "Amandeep", "Mitanshi", "Tarun", "Amandeep", "Mitanshi", "Tarun", "Amandeep", "Mitanshi", "Tarun", "Amandeep", "Mitanshi", "Tarun", "Amandeep", "Mitanshi"};
        String[] subTittle = {"first", "second", "Third", "first", "second", "Third", "first", "second", "Third", "first", "second", "Third", "first", "second", "Third"};
        Integer[] imgeList = {R.drawable.back, R.drawable.book, R.drawable.fire, R.drawable.back, R.drawable.book, R.drawable.fire, R.drawable.back, R.drawable.book, R.drawable.fire, R.drawable.back
                , R.drawable.book, R.drawable.fire, R.drawable.back, R.drawable.back, R.drawable.book, R.drawable.fire, R.drawable.back};

        cutomAdapterList = new CutomAdapterList(this, 0, tittle, subTittle, imgeList);
        listView.setAdapter(cutomAdapterList);
        cutomAdapterList.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                count++;
                if (count == 5) {
                    Toast.makeText(CustomListView.this, String.valueOf(i) + tittle[i], Toast.LENGTH_SHORT).show();
                    count=0;
                }

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CustomListView.this, String.valueOf(i) + tittle[i], Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}