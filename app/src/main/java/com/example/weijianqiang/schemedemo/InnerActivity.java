package com.example.weijianqiang.schemedemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class InnerActivity extends AppCompatActivity {

    private static final String TAG = "InnerActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner);
        TextView textView = findViewById(R.id.text_1);
        Intent intent = getIntent();
        if (intent != null && intent.getData() != null){
            Uri uri = intent.getData();
            if (uri != null){
                StringBuilder sb = new StringBuilder();
                sb.append("获取到的scheme是:"+uri.getScheme()+"\n");
                sb.append("获取到的host是:"+uri.getHost()+"\n");
                sb.append("获取到的path是:"+uri.getPath()+"\n");
                sb.append("第一个参数appid:"+uri.getQueryParameter("appid")+"\n");
                sb.append("第二个参数password:"+uri.getQueryParameter("password"));
                textView.setText(sb.toString());
            } else {
                textView.setText("uri is null");
            }
        }else {
            textView.setText("intent or data is null");
        }
    }
}
