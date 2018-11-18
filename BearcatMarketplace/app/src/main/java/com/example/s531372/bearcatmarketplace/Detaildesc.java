package com.example.s531372.bearcatmarketplace;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import Model.Order;

public class Detaildesc extends Activity {
    ImageButton btn=findViewById(R.id.imageButton5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaildesc);



        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order());

            }
        });





    }



    public void chatFn(View v){

        Intent init = new Intent(this,ChatActivity.class);
        startActivity(init);
    }

    public void cartFn(View v){

        Intent init = new Intent(this,CartActivity.class);
        startActivity(init);
    }
}
