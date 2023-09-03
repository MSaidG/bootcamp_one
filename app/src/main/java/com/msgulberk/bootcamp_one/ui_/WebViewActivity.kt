package com.msgulberk.bootcamp_one.ui_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.msgulberk.bootcamp_one.R
import com.msgulberk.bootcamp_one.data.BtkDatabase
import com.msgulberk.bootcamp_one.data.Ogrenci
import com.msgulberk.bootcamp_one.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    var binding : ActivityWebViewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    fun veriGetir()
    {
        val veritabani = BtkDatabase.getBtkDatabase(applicationContext)

        val ekleyecegimOgrenci1 = Ogrenci(adi="Mehmet", soyadi="Öz")
        val ekleyecegimOgrenci2 = Ogrenci(adi="Çiğdem", soyadi="Özoğlu")

        veritabani.ogrenciDAO().insert(ekleyecegimOgrenci1)
        veritabani.ogrenciDAO().insert(ekleyecegimOgrenci2)


        var ogrenciListesi: ArrayList<Ogrenci> = veritabani.ogrenciDAO().tumOgrenciler() as ArrayList<Ogrenci>

        ogrenciListesi.forEach{
            Log.e("OGRENCIM", "öğrenci " + it.toString())
            println("Yeni!")
        }

    }

    fun initUI()
    {

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.webView?.apply {
            settings.javaScriptEnabled = true
            //loadUrl("https://www.btkakademi.gov.tr/")

            val htmlData = "<b>Koyu</b> and <i>İtalik</i> yazı</p>"
            var strResource = resources.getString(R.string.benim_html_metnim)
            loadData(strResource, "text/html; charset=UTF-8", null)
        }
    }

    override fun onBackPressed(){

        binding?.webView?.apply {

            if (canGoBack())
            {
                goBack()
            }
            else
            {
                super.onBackPressed()
            }
        }

    }

}