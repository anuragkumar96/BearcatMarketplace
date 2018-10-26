package com.example.s531372.bearcatmarketplace;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends Activity {

    private EditText emailET;
    private EditText passwordET;

    private TextView continueTV;
    private TextView cancleTV;

    public static Activity signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);

        continueTV = findViewById(R.id.continueTV);
        cancleTV = findViewById(R.id.cancleTV);

        signup = this;



        continueTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = emailET.getText().toString();
                String passWord = passwordET.getText().toString();

                if(TextUtils.isEmpty(userName)){
                    Toast.makeText(SignupActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                    setAlert("Email cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(passWord)){
//                    Toast.makeText(Signup.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                    setAlert("Password cannot be empty");
                    return;
                }
                if(passWord.length()<6){
//                    Toast.makeText(signup, "Password should be at least 6 charactors", Toast.LENGTH_SHORT).show();
                    setAlert("Password should be at least 6 characters");
                    return;
                }
                Intent i = new Intent(SignupActivity.this, FirstActivity.class);
                i.putExtra("email", userName);
                i.putExtra("password", passWord);
                startActivity(i);
            }
        });

        cancleTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void setAlert(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.setTitle("Warning..!");
        alert.show();
    }
}


