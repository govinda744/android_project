//Shared Prefrence

package com.pagoda.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText editTextPassword;
    EditText editTextUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btn_login);
        editTextUsername = (EditText) findViewById(R.id.et_username);
        editTextPassword = (EditText) findViewById(R.id.et_password);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (username.equals("govinda") && password.equals("32145")) {
                    Intent intent1 = new Intent(MainActivity.this, DetailActivity.class);
                    intent1.putExtra("mainmessage", username);
                    startActivity(intent1);
                    finish();
                } else
                    Toast.makeText(MainActivity.this, "Not Eligible", Toast.LENGTH_LONG).show();
            }
        });

        TextView tvSignUp = (TextView) findViewById(R.id.tv_signup);

        tvSignUp.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
                return true;
            }
        });
    }
}
