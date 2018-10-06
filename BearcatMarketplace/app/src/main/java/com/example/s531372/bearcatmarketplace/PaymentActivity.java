package com.example.s531372.bearcatmarketplace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PaymentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }

    public void continueFn(View v) {

        Intent init = new Intent(this, NewTopPickUps.class);
        startActivity(init);
    }
}
