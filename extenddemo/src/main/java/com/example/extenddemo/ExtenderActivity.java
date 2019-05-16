package com.example.extenddemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class ExtenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extender);
        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            private List<ResolveInfo> activityList;

            @Override
            public void onClick(View v) {
                String scheme = "scheme://test/schemetest?appid=123456&password=000000";
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(scheme));
                PackageManager pm = getPackageManager();
                activityList = pm.queryIntentActivities(intent,0);
                if ( !activityList.isEmpty()){
                    startActivity(intent);
                } else {
                    Toast.makeText(ExtenderActivity.this,"没有符合条件的activity",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
