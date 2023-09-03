package com.msgulberk.bootcamp_one.ui_

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.msgulberk.bootcamp_one.util.HangiDil
import com.msgulberk.bootcamp_one.util.LanguageManager
import com.msgulberk.bootcamp_one.R
import com.msgulberk.bootcamp_one.util.extensions.mesajBas
import com.msgulberk.bootcamp_one.util.extensions.mesajOlarakGoster

class DilActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dil)

        initUI()
    }

    fun initUI()
    {
        initButtons()
    }

    fun initButtons()
    {
        val butonTr: Button = findViewById(R.id.btnTr)
        val butonEn: Button = findViewById(R.id.btnEn)

        butonTr.setOnClickListener {

            LanguageManager.dilDegistir(HangiDil.TURKCE, this)
            mesajBas("Türkçe oldu!")

            "Dil türkçe oldu".mesajOlarakGoster(applicationContext)

        }

        butonEn.setOnClickListener {

            LanguageManager.dilDegistir(HangiDil.ENGLISH, this)
            mesajBas("İngilizce oldu!")

            "Dil ingilizce oldu".mesajOlarakGoster(applicationContext)
        }


    }





}