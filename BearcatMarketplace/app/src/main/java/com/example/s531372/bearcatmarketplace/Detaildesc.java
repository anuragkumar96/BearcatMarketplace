package com.example.s531372.bearcatmarketplace;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import Model.Order;

public class Detaildesc extends Activity {
    Intent intent;
    TextView productName,Price,decription;
    ImageView imageproduct;
    Order data;
    ImageButton imagecard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaildesc);
        intent=getIntent();
        data= (Order) intent.getSerializableExtra("data");
        productName=(TextView)findViewById(R.id.ProductName);
        Price=(TextView)findViewById(R.id.Price);
        imageproduct=(ImageView)findViewById(R.id.imageproduct);
        imagecard=(ImageButton)findViewById(R.id.imagecard);
        decription=(TextView)findViewById(R.id.decription);
        decription.setText(data.getDescription());
        imagecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent init = new Intent(Detaildesc.this,CartActivity.class);
                startActivity(init);
            }
        });

        productName.setText(data.getProductName());
        Price.setText("Price : $"+data.getPrice());
        imageproduct.setBackgroundResource(data.getImage());
    }



    public void chatFn(View v){

        Intent init = new Intent(this,ChatActivity.class);
        startActivity(init);
    }

    public void cartFn(View v){
        Utils.cartList.add(data);
        Intent init = new Intent(this,CartActivity.class);
        startActivity(init);
    }
}
