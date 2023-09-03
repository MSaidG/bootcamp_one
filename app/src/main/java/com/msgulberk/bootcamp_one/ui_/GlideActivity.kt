package com.msgulberk.bootcamp_one.ui_

import android.annotation.SuppressLint
import android.content.Context
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.ConnectivityManager
import com.bumptech.glide.Glide
import com.msgulberk.bootcamp_one.R
import com.msgulberk.bootcamp_one.databinding.ActivityGlideBinding
import com.msgulberk.bootcamp_one.util.extensions.mesajBas

class GlideActivity : AppCompatActivity() {

    var binding : ActivityGlideBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGlideBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if (internetVarMi())
        {
            mesajBas("Internet var")
        }
        else
        {
            mesajBas("Internet yok")
        }

        var url="https://assets-btkakademi-gov-tr.akamaized.net/api/gallery/51/3acb65fe-1dc1-4520-bc24-2f2fba6096bc/kotlin_banner_web-banner%281%29.png"

        Glide.with(applicationContext)
            .load(url)
            .error(R.drawable.resim)
            .fitCenter()
            .into(binding?.imageGlide!!)
    }

    @SuppressLint("ServiceCast")
    private fun internetVarMi(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        return activeNetwork.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}