package com.drunkpiano.thesecondside;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class RealLetterActivity extends AppCompatActivity {
    WebView mLetterWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_letter);
        mLetterWebView = (WebView)findViewById(R.id.letter_webView);
        mLetterWebView.getSettings().setJavaScriptEnabled(true);
        mLetterWebView.loadUrl("http://viewer.maka.im/k/Y6O0303J");
//        mLetterWebView.loadUrl("http://www.baidu.com");
        mLetterWebView.setWebViewClient(new LetterClient());
    }
    class LetterClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

}
