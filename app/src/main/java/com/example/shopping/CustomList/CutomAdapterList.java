package com.example.shopping.CustomList;

import static com.example.shopping.R.id.tittle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shopping.R;

public class CutomAdapterList extends ArrayAdapter<String> {

    private String[] tittl;
    private Context context;
    private String[] subTittle;
    private Integer[] imageList;

    //Constructor
    public CutomAdapterList(@NonNull Context context, int res, String[] tittle, String[] subTittle,Integer[]imageList) {
        super(context, res, tittle);
        this.tittl = tittle;
        this.context = context;
        this.subTittle = subTittle;
        this.imageList=imageList;
        Log.d("TAG", "CutomAdapterList: " + tittle);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_layout_screen, parent, false);

        TextView tittle = view.findViewById(R.id.tittle);
        TextView second_tittle = view.findViewById(R.id.subTittle);
        ImageView image = view.findViewById(R.id.profile_image);

        String nameTittle = tittl[position];
        String secondName = subTittle[position];

        Integer images=imageList[position];

        tittle.setText(nameTittle);
        second_tittle.setText(secondName);
        image.setImageResource(images);


        return view;
    }
}
