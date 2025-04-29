package com.uz.volleyandnetworkcheck

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.uz.volleyandnetworkcheck.databinding.ActivityMainBinding
import com.uz.volleyandnetworkcheck.util.NetworkUtils

class ShowActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val htmlUrl = intent.getStringExtra("html")


        binding.recy.visibility = View.GONE




        if (htmlUrl != null && NetworkUtils.isNetworkAvailable(this)) {
            binding.web.settings.javaScriptEnabled = true
            binding.web.webViewClient = WebViewClient()
            binding.web.loadUrl(htmlUrl)
            binding.web.visibility = View.VISIBLE
        } else {
            Toast.makeText(this, "Qandaydir xatolik ro'y berdi!", Toast.LENGTH_SHORT).show()
        }


    }
}