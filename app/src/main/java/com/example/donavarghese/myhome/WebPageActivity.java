package com.example.donavarghese.myhome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);
        WebView myWebView = (WebView) findViewById(R.id.webView);

        myWebView.getSettings().setJavaScriptEnabled(true);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        final Activity activity = this;
        myWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        myWebView.loadUrl("http://www.google.com");

    }

   public void logout(View view){
       Intent intent = new Intent(this, LoginActivity.class);

       startActivity(intent);
   }

}
