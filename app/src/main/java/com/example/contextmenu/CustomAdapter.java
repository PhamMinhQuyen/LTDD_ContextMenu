package com.example.contextmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter  extends BaseAdapter {

    Context context;
    ArrayList<CountriesModel> countriesData;
    LayoutInflater layoutInflater;
    CountriesModel countriesModel;


    public CustomAdapter(Context context, ArrayList<CountriesModel> countriesData) {
        this.context = context;
        this.countriesData = countriesData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return countriesData.size();
    }

    @Override
    public Object getItem(int position) {
        return countriesData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return countriesData.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView = view;
        if (rowView==null) {
            rowView = layoutInflater.inflate(R.layout.row, null, true);
        }

        //link views
        ImageView image =rowView.findViewById(R.id.image);
        TextView tieude =rowView.findViewById(R.id.textview1);
        TextView tieudephu =rowView.findViewById(R.id.textview2);

        countriesModel = countriesData.get(position);
        image.setImageResource(countriesModel.getImage());
        tieude.setText(countriesModel.getTieuDe());
        tieudephu.setText( countriesModel.getTieuDePhu());




        return rowView;
    }
}
