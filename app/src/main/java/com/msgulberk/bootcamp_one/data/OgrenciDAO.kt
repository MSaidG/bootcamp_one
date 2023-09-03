package com.msgulberk.bootcamp_one.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface OgrenciDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(ogrenci: Ogrenci)

    @Delete
    fun delete(ogrenci: Ogrenci)

    @Query("SELECT*FROM ogrenci")
    fun tumOgrenciler(): List<Ogrenci>

    @Query("SELECT*FROM ogrenci where adi like '%' || :adi || '%'")
    fun ogrenciBul(adi: String): List<Ogrenci>

    @Query("SELECT*FROM ogrenci where ogrenciId=:ogrenciID")
    fun ogrenciGetir(ogrenciID: Int): Ogrenci
}