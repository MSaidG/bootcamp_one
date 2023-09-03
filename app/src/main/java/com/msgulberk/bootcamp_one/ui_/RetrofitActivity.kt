package com.msgulberk.bootcamp_one.ui_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.msgulberk.bootcamp_one.R
import com.msgulberk.bootcamp_one.data.PlaceHolderService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RetrofitActivity : AppCompatActivity() {

    val service = PlaceHolderService.build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        getUsers()

    }

    fun getUsers()
    {
        GlobalScope.launch {
            var liste = service.getAllUsers()
        }
    }
}