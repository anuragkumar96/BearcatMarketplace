package com.example.s531372.bearcatmarketplace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ShopByCategory extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_by_category);
    }

    public void submitFn(View v){

        Intent init = new Intent(this,TablesActivty.class);
        startActivity(init);
    }
}
