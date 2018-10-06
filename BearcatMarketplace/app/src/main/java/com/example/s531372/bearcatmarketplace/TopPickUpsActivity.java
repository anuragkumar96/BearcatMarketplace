package com.example.s531372.bearcatmarketplace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TopPickUpsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_pick_ups);
    }

    public void filterFn(View v){

        Intent init = new Intent(this,ShopByCategory.class);
        startActivity(init);
    }

    public void filterFtn(View v){

        Intent init = new Intent(this,detaildesc.class);
        startActivity(init);
    }
}
