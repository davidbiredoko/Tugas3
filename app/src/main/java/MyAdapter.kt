package com.example.tugas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val nameList: ArrayList<ItemData>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var onItemClick: ((ItemData) -> Unit)? = null
    class MyViewHolder (itemData: View) : RecyclerView.ViewHolder (itemData) {
        val img :ImageView = itemData.findViewById(R.id.imageView5)
        val name : TextView = itemData.findViewById(R.id.textView6)
        val color : TextView = itemData.findViewById(R.id.textView7)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = nameList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = nameList[position]
        holder.name.text = item.name
        holder.color.text = item.color
        holder.img.setImageResource(item.img)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(item)
        }
    }
}