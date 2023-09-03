package com.msgulberk.bootcamp_one.util

import android.app.Activity
import java.util.Locale


enum class HangiDil(val deger: String)
{
    TURKCE("tr"),
    ENGLISH("en")
}

object LanguageManager {


    fun dilDegistir(dil: HangiDil, activity: Activity)
    {
        val config_ = activity.resources.configuration
        val dil_ = Locale(dil.deger)

        config_.setLocale(dil_)
        activity.resources.updateConfiguration(config_, activity.resources.displayMetrics)
        activity.recreate()

    }
}