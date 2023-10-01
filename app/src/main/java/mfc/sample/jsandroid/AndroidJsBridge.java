package mfc.sample.jsandroid;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class AndroidJsBridge {
    Context context;
    TextView webResponse;

    AndroidJsBridge(Context ctx) {
        context = ctx;
    }

    @JavascriptInterface
    public void getResultFromWebpage(String msg) {
        try {
            JSONObject resultObj = new JSONObject(msg);
            webResponse = ((AppCompatActivity) context).findViewById(R.id.web_response);
            webResponse.setText("LOGIN STATUS: " + resultObj.getString("status")
                    + "\nMESSAGE: " + resultObj.getString("message")
            );
        } catch (JSONException e) {
            Log.e("exception", e.getMessage());
        }
    }
}