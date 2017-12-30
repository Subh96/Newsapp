package com.example.abhi.newsapp;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setTitle("Wait a second");
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
        webView= (WebView) findViewById(R.id.webView);
        String url=getIntent().getStringExtra("Url");
        webView.loadUrl(url);
        if(progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {

            boolean loadingFinished = true;
            boolean redirect = false;
            @Override
            public boolean shouldOverrideUrlLoading(
                    WebView view, WebResourceRequest request) {
                if (!loadingFinished) {
                    redirect = true;
                }


                loadingFinished = false;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    webView.loadUrl(request.getUrl().toString());
                }
                return true;
            }

            @Override
            public void onPageStarted(
                    WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                loadingFinished = false;

                //SHOW LOADING IF IT ISNT ALREADY VISIBLE
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if(!redirect){
                    loadingFinished = true;

                }

                if(loadingFinished && !redirect){
                    //HIDE LOADING IT HAS FINISHED
                } else{
                    redirect = false;
                }
            }
        });
    }
}
