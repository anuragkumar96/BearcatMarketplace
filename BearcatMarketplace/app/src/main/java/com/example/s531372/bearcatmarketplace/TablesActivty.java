package com.example.s531372.bearcatmarketplace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TablesActivty extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_activty);


    }

    public void tablesFn(View v){

        Intent init = new Intent(this,detaildesc.class);
        startActivity(init);
    }
}
