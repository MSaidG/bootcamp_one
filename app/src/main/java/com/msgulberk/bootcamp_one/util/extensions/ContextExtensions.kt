package com.msgulberk.bootcamp_one.util.extensions

import android.content.Context
import android.widget.Toast

fun Context.mesajBas(mesaj: String)
{
    Toast.makeText(this, mesaj, Toast.LENGTH_LONG).show()
}
