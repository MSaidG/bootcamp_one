package com.msgulberk.bootcamp_one.util.extensions

import android.content.Context
import android.widget.Toast


fun String.mesajOlarakGoster(context: Context)
{
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}
