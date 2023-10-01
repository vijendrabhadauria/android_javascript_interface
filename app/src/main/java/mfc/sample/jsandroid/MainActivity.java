package mfc.sample.jsandroid;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;
    String urlToOpen = "http://madeforcoding.com/android/android_javascript_interface/demo/signin.jsp?title=Sign-in";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);

        AndroidJsBridge androidJsBridgeObj = new AndroidJsBridge(this);
        myWebView.addJavascriptInterface(androidJsBridgeObj, "Android");
        myWebView.loadUrl(urlToOpen);
    }
}