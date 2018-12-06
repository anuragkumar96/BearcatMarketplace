package com.example.s531372.bearcatmarketplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class FirstActivity extends AppCompatActivity {

    TextView signup;
    EditText userNameET,passwordET;
    public static DataBaseUtils m_dataBaseUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        m_dataBaseUtils = new DataBaseUtils(FirstActivity.this);

        signup = (TextView) findViewById(R.id.signupTV);
        userNameET = findViewById(R.id.userNameET);
        passwordET = findViewById(R.id.passwordET);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent init = new Intent(FirstActivity.this, SignupActivity.class);
                startActivity(init);
            }
        });

//        Parse.initialize(new Parse.Configuration.Builder(this)
//                .applicationId(getString(R.string.back4app_app_id))
//                // if defined
//                .clientKey(getString(R.string.back4app_client_key))
//                .server(getString(R.string.back4app_server_url))
//                .build()
//        );
//        ParseInstallation.getCurrentInstallation().saveInBackground();
    }




    public void loginFn(View v){
        String userName=userNameET.getText().toString().trim();
        String passWord=passwordET.getText().toString().trim();

        if(TextUtils.isEmpty(userName)){
            //Toast.makeText(FirstActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
            Utils.setAlert("UserName/Email cannot be empty",FirstActivity.this);
            return;
        }
        if(TextUtils.isEmpty(passWord)){
//                    Toast.makeText(Signup.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
            Utils.setAlert("Password cannot be empty",FirstActivity.this);
            return;
        }
        if (m_dataBaseUtils.getUserPasswordDetails(userName).equalsIgnoreCase(passWord)) {
            FilterActivity.selectedItems= new boolean[]{false, false, false, false, false};
            Intent init = new Intent(this, TopPickUpsActivity.class);
            init.putExtra("from","First");
            startActivity(init);
        }else
        {
            Utils.setAlert("UserName and password are not matched",FirstActivity.this);
        }
    }


}
