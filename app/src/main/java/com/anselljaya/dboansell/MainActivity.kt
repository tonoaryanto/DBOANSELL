package com.anselljaya.dboansell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        WebView1.settings.javaScriptEnabled = true
        WebView1.settings.domStorageEnabled = true
        WebView1.settings.allowFileAccess = true
        WebView1.webViewClient = WebViewClient()
        WebView1.loadUrl("http://bi.anselljaya.com/login")

    }
    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if(WebView1.canGoBack()){
            WebView1.goBack()
        }
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }
}

