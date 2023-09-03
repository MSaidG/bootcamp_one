package com.msgulberk.bootcamp_one.ui_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.msgulberk.bootcamp_one.data.PlaceHolderService
import com.msgulberk.bootcamp_one.data.UserModelItem
import com.msgulberk.bootcamp_one.databinding.ActivityRecycleBinding
import com.msgulberk.bootcamp_one.util.extensions.mesajBas
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RecycleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecycleBinding
    var ogrenciler = arrayListOf<String>(
        "Enver Çavuş",
        "Nisa Çağatay",
        "Zekican Yılmaz",
        "Asaf Okutan",
        "Berk Mor",
        "Roberto Carlos"
    )
    private lateinit var ogrenciAdapter: OgrenciAdapter
    private lateinit var userAdapter: UserAdapter


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityRecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        getUsers()

    }

    val service = PlaceHolderService.build()

    fun getUsers() {
        GlobalScope.launch {
            var liste = service.getAllUsers()
            runOnUiThread{
                initRecyclerView2(liste.body() as ArrayList<UserModelItem>)
            }
        }
    }

    fun initUI() {
        binding = ActivityRecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //initRecyclerView()
        binding.apply {
            btnEkle.setOnClickListener {
                ogrenciler.add(edtIsim.text.toString())
                ogrenciAdapter.notifyDataSetChanged()
            }
        }
    }


    fun initRecyclerView() {

        binding.apply {

            ogrenciAdapter = OgrenciAdapter(

                ogrenciler = ogrenciler,
                onClick = { pozisyon ->

                    mesajBas(ogrenciler[pozisyon])

                },

                onDelete = { index ->
                    ogrenciler.removeAt(index)
                    ogrenciAdapter.notifyDataSetChanged()
                }
            )

            rcvOgrenciler.apply {

                adapter = ogrenciAdapter
                layoutManager = LinearLayoutManager(applicationContext)
                //layoutManager = GridLayoutManager(applicationContext, 2)

            }

        }

    }

    fun initRecyclerView2(kullanicilar: ArrayList<UserModelItem>) {

        binding.apply {

            userAdapter = UserAdapter(

                kullanicilar = kullanicilar,
                onClick = { index ->

                    mesajBas(kullanicilar[index].name!!)

                },

                onDelete = { index ->
                    //ogrenciler.removeAt(index)
                    //ogrenciAdapter.notifyDataSetChanged()
                }
            )

            rcvOgrenciler.apply {
                adapter = userAdapter
                layoutManager = LinearLayoutManager(applicationContext)
                //layoutManager = GridLayoutManager(applicationContext, 2)
            }

        }

    }


}
