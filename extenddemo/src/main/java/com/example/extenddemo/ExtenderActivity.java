package com.example.extenddemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExtenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extender);
        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scheme = "scheme://test/schemetest?appid=123456&password=000000";
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(scheme));
                startActivity(intent);
            }
        });
    }
}
