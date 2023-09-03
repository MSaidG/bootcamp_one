package com.msgulberk.bootcamp_one.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ogrenci")
data class Ogrenci(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ogrenciId")
    var ogrenciId: Int = 0,

    @ColumnInfo(name = "adi")
    var adi: String,

    @ColumnInfo(name = "soyadi")
    var soyadi:String

)

