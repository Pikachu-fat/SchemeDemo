package com.example.weijianqiang.schemedemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class SchemeActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);

        webView  = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/index.html");
        webView.addJavascriptInterface(new Contact(),"contact");
    }

    class Contact{
        @JavascriptInterface
        public void call(String phone) {
//            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone)));
            Toast.makeText(SchemeActivity.this, phone, Toast.LENGTH_LONG).show();
        }

        //Html调用此方法传递数据
        @JavascriptInterface
        public void showcontacts() {
            String json = "[{\"name\":\"zxx\", \"amount\":\"9999999\", \"phone\":\"18600012345\"}]";
            // 调用JS中的方法
            webView.loadUrl("javascript:show('" + json + "')");
        }

        @JavascriptInterface
        public void toast(String str){
            Toast.makeText(SchemeActivity.this, "aaaaaaaaaaaa  --- " + str, Toast.LENGTH_LONG).show();
        }
    }
}
