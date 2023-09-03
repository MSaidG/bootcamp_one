package com.msgulberk.bootcamp_one

import android.app.Application

class BtkApplication : Application() {

    var instance: BtkApplication? = null

    fun getApp(): BtkApplication { // fun getApp() : Aplication

        if (instance == null) {
            instance = this // BtkApplication
        }

        return instance!! // return app as BtkApllication
    }

}