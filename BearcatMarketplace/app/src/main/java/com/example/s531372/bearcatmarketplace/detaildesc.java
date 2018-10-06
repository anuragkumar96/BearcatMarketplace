package com.example.s531372.bearcatmarketplace;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class detaildesc extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaildesc);
    }

    public void chatFn(View v){

        Intent init = new Intent(this,ChatActivity.class);
        startActivity(init);
    }
}
