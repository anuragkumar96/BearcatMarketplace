package com.example.s531372.bearcatmarketplace;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends Activity implements View.OnClickListener {

    private Button btn;
    private EditText emailET;
    private EditText passwordET;
    private TextView cancleTV;
    private TextView continueTV;
    private FirebaseAuth firebaseAuth;



    public static Activity signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn=findViewById(R.id.registerbtn);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        cancleTV = findViewById(R.id.cancleTV);

        continueTV = findViewById(R.id.continueTV);

    btn.setOnClickListener(this);
    cancleTV.setOnClickListener(this);
    firebaseAuth=FirebaseAuth.getInstance();




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

    /**
     * Called when a view has been clicked.
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {

        if(view==btn){

            registerUser();
        }


    }

    private void registerUser() {

        String userName = emailET.getText().toString().trim();
        String passWord = passwordET.getText().toString().trim();

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



      firebaseAuth.createUserWithEmailAndPassword(userName,passWord).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
         @Override
         public void onComplete(@NonNull Task<AuthResult> task) {

             if(task.isSuccessful()){

                 Toast.makeText(SignupActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
             }

             else{

                 Toast.makeText(SignupActivity.this, "Registion unsuccessfully", Toast.LENGTH_SHORT).show();
             }

         }


     });


    }
}


