package com.example.s531372.bearcatmarketplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        signup = (TextView) findViewById(R.id.signupTV);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent init = new Intent(FirstActivity.this, SignupActivity.class);
                startActivity(init);
            }
        });
    }




    public void loginFn(View v){

        Intent init = new Intent(this,TopPickUpsActivity.class);
        startActivity(init);
    }

}
