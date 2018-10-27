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

    public void tables(View v){

        Intent init = new Intent(this,detaildesc.class);
        startActivity(init);
    }

    public void chairsfn(View v){

        Intent init = new Intent(this,ChairActivity.class);
        startActivity(init);
    }

    public void booksFn(View v){

        Intent init = new Intent(this,BookActivity.class);
        startActivity(init);
    }

    public void bikesFn(View v){

        Intent init = new Intent(this,BikeActivity.class);
        startActivity(init);
    }
}
