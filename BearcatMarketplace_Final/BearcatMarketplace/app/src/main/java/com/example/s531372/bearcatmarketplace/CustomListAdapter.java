package com.example.s531372.bearcatmarketplace;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        if(position == 0) {


            extratxt.setText("Upto $300" );
            return rowView;
        }
        else if(position == 1)
        {
            extratxt.setText("Upto $100" );
            return rowView;
        }
        else if(position == 2)
        {
            extratxt.setText("Upto $500 ");
            return rowView;
        }
        else if(position == 3)
        {
            extratxt.setText("Upto $100" );
            return rowView;
        }
        else if(position == 4)
        {
            extratxt.setText("Upto $150 ");
            return rowView;
        }
        else if(position == 5)
        {
            extratxt.setText("Upto $200 ");
            return rowView;
        }
        else if(position == 6)
        {
            extratxt.setText("Upto $100 ");
            return rowView;
        }
        else if(position == 7)
        {
            extratxt.setText("Upto $250 ");
            return rowView;
        }
        else if(position == 8)
        {
            extratxt.setText("Upto $150 ");
            return rowView;
        }
        else if(position == 9)
        {
            extratxt.setText("Upto $200 ");
            return rowView;
        }
        else if(position == 10)
        {
            extratxt.setText("Upto $200 ");
            return rowView;
        }

        else if(position == 11)
        {
            extratxt.setText("Upto $120 ");
            return rowView;
        }
        else if(position == 12)
        {
            extratxt.setText("Upto $140 ");
            return rowView;
        }
        return rowView;

    };
}
