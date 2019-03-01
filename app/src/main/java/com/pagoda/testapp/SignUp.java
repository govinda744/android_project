//date picker

package com.pagoda.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Spinner spDay = (Spinner)findViewById(R.id.sp_day);

        ArrayList<String> days = new ArrayList<>();

        for(Integer i = 1;i <= 30; i++){
            days.add(i.toString());
        }

        ArrayAdapter<String> dropDay = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, days);

        spDay.setAdapter(dropDay);

        Button btnSignUp = (Button) findViewById(R.id.btn_signup);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etEmail = (EditText) findViewById(R.id.et_email);
                EditText etFirstName = (EditText) findViewById(R.id.et_firstName);
                EditText etLastName = (EditText) findViewById(R.id.et_lastname);
                EditText etPassword = (EditText) findViewById(R.id.et_password);


                String email = etEmail.getText().toString();

                String emailMatchTo = "^[a-zA-Z][a-zA-Z0-9\\.]+\\@[a-z]+\\.[a-z]{2,3}$";

                String passworMatchTo = "[(A-Z)+(a-z0-9)+]+";

                Pattern emailPattern = Pattern.compile(emailMatchTo);

//                Pattern passpattern = Pattern.compile(passworMatchTo);

                Matcher emailMatch = emailPattern.matcher(email);

//                Matcher passMatch = passpattern.matcher(passworMatchTo);

                if(emailMatch.matches()){
                    Toast.makeText(SignUp.this, "Sign Up successfull", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SignUp.this,MainActivity.class);
                    intent.putExtra("signupemail",etEmail.getText().toString());
                    intent.putExtra("signuppassword", etPassword.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
