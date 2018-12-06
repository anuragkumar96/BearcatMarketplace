package com.example.s531372.bearcatmarketplace;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import Model.Order;

public class TopPickUpsActivity extends Activity {

    GridView gridView;
    LinearLayout filter_layout;
    Intent intent;
    String from="";
    CustomeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_pick_ups);
        intent=getIntent();
        from=intent.getStringExtra("from");
        filter_layout=(LinearLayout)findViewById(R.id.filter_layout);
        filter_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FilterActivity.selectedItems= new boolean[]{false, false, false, false, false};
                startActivity(new Intent(TopPickUpsActivity.this,FilterActivity.class));
            }
        });


        gridView=(GridView)findViewById(R.id.gridView);
        if (from.equals("First")) {
            adapter = new CustomeAdapter(Utils.getAllData(), TopPickUpsActivity.this);
        }else
        {
            adapter = new CustomeAdapter(Utils.getSelectedItemsData(FilterActivity.selectedItems), TopPickUpsActivity.this);

        }
        gridView.setAdapter(adapter);

//        list.setOnItemClickListener(new OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                // TODO Auto-generated method stub
////                String Slecteditem= itemname[+position];
////                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
//                if(position == 0)
//                {
//                    Intent init = new Intent(TopPickUpsActivity.this,Detaildesc.class);
//                    startActivity(init);
//                }
//                else if(position == 1)
//                {
//                    Intent init = new Intent(TopPickUpsActivity.this,BookActivity.class);
//                    startActivity(init);
//                }
//
//                else if(position == 2)
//                {
//                    Intent init = new Intent(TopPickUpsActivity.this,BikeActivity.class);
//                    startActivity(init);
//                }
//
//                else if(position == 3)
//                {
//
//                    Intent init = new Intent(TopPickUpsActivity.this,ChairActivity.class);
//                    startActivity(init);
//                }
//
//            }
//        });
    }
    class CustomeAdapter extends BaseAdapter
    {
        ArrayList<Order> data;
        Context ctx;
        TextView product_name_with_price;
        ImageView product_image;
        CustomeAdapter(ArrayList<Order> data, Context context)
        {
            this.data=data;
            this.ctx=context;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View v=LayoutInflater.from(ctx).inflate(R.layout.grid_item,null);
            product_name_with_price=v.findViewById(R.id.product_name_with_price);
            product_image=v.findViewById(R.id.product_image);
            product_name_with_price.setText(data.get(position).getProductName()+ " $"+data.get(position).getPrice());
            product_image.setBackgroundResource(data.get(position).getImage());
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(TopPickUpsActivity.this,Detaildesc.class);
                    intent.putExtra("data", data.get(position));
                    startActivity(intent);
                }
            });

            return v;
        }
    }

}
