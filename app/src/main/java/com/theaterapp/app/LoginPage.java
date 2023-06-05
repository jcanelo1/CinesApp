package com.theaterapp.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginPage extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(com.theaterapp.loginpage.R.layout.activity_login_page);


                TextView username =(TextView) findViewById(com.theaterapp.loginpage.R.id.username);
                TextView password =(TextView) findViewById(com.theaterapp.loginpage.R.id.password);

                MaterialButton loginbtn = (MaterialButton) findViewById(com.theaterapp.loginpage.R.id.loginbtn);

                //Chicago and Illinois

                loginbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                             if (username.getText().toString().equals("Chicago") && password.getText().toString().equals("Illinois")){
                                     //correct
                                     Toast.makeText(LoginPage.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                             }else
                                //incorrect
                                     Toast.makeText(LoginPage.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
                        }
                });

        }
}