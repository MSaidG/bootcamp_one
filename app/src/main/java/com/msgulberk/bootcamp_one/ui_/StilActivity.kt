package com.msgulberk.bootcamp_one.ui_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.msgulberk.bootcamp_one.R
import com.msgulberk.bootcamp_one.databinding.ActivityStilBinding
import com.msgulberk.bootcamp_one.util.extensions.mesajBas

class StilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adi : String? = null
        adi?.let{

        }

        binding.apply {

            button2.setOnClickListener{
                mesajBas("Merhaba!")
            }
        }
    }
}