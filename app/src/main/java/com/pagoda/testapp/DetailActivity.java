package com.pagoda.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    Button btnGetData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        toolbar.setTitle(getResources().getString(R.string.app_name));

        toolbar.setTitleTextColor(getResources().getColor(R.color.colorText));

//        toolbar.setOnHoverListener(new View.OnHoverListener() {
//            @Override
//            public boolean onHover(View v, MotionEvent event) {
//                toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));
//                return false;
//            }
//        });

        Intent intent = getIntent();
        final String username = intent.getStringExtra("mainmessage");

        btnGetData = (Button) findViewById(R.id.btn_getdata);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, username, Toast.LENGTH_LONG ).show();
            }
        });
    }
}
