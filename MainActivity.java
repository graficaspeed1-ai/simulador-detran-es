package com.simulado.detranes;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class MainActivity extends Activity {
  WebView w;
  @Override protected void onCreate(Bundle b) {
    super.onCreate(b);
    w = new WebView(this);
    WebSettings s = w.getSettings();
    s.setJavaScriptEnabled(true);
    s.setDomStorageEnabled(true);
    w.setWebViewClient(new WebViewClient());
    w.setWebChromeClient(new WebChromeClient() {
      @Override public boolean onJsAlert(WebView v, String u, String m, JsResult r) {
        new AlertDialog.Builder(MainActivity.this).setMessage(m).setPositiveButton("OK", (d, i) -> r.confirm()).setOnCancelListener(d -> r.confirm()).show();
        return true;
      }
      @Override public boolean onJsConfirm(WebView v, String u, String m, JsResult r) {
        new AlertDialog.Builder(MainActivity.this).setMessage(m).setPositiveButton("OK", (d, i) -> r.confirm()).setNegativeButton("Cancelar", (d, i) -> r.cancel()).setOnCancelListener(d -> r.cancel()).show();
        return true;
      }
    });
    setContentView(w);
    w.loadUrl("file:///android_asset/index.html");
  }
}
