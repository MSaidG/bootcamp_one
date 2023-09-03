package com.msgulberk.bootcamp_one.ui_

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.msgulberk.bootcamp_one.databinding.ItemOgrenciBinding


class OgrenciAdapter(var ogrenciler: ArrayList<String>, var onClick: (Int) -> Unit, var onDelete : (Int) -> Unit) :
    RecyclerView.Adapter<OgrenciAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemOgrenciBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOgrenciBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {
            binding.apply {
                textName.text = ogrenciler[position]
                cardViewOgrenci.setOnClickListener {
                    onClick(position)
                }

                imageButton.setOnClickListener {
                    onDelete(position)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return ogrenciler.size
    }
}