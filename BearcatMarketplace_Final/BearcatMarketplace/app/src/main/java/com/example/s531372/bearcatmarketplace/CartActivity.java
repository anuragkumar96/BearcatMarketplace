package com.example.s531372.bearcatmarketplace;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import Model.Order;

public class CartActivity extends Activity {
    private ListView list_view_cart;
    TextView total_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        list_view_cart=(ListView)findViewById(R.id.list_view_cart);
        total_price=(TextView)findViewById(R.id.total_price);
        CartAdapter cartAdapter=new CartAdapter(Utils.cartList,CartActivity.this);
        list_view_cart.setAdapter(cartAdapter);
        total_price.setText(" $"+getTotla(Utils.cartList));
    }
    private long getTotla(ArrayList<Order> data)
    {
        long total =0;
        for (Order order:data) {
            total+=Integer.parseInt(order.getPrice());
        }
        return total;
    }
    class CartAdapter extends BaseAdapter
    {
        ArrayList<Order> data;
        Context context;
        CartAdapter(ArrayList<Order> data, Context context)
        {
            this.data=data;
            this.context=context;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_item_cart,null);
            TextView title=(TextView)view.findViewById(R.id.title);
            TextView price=(TextView)view.findViewById(R.id.price);

            title.setText(data.get(position).getProductName());
            price.setText(" $"+data.get(position).getPrice());

            return view;
        }
    }
    public void checkOutFn(View v){

        Intent init = new Intent(this,PaymentActivity.class);
        startActivity(init);
    }
}
