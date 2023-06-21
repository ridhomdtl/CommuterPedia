package com.example.commuterpedia

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TrainAdapter(private val trainList:ArrayList<Train>): RecyclerView.Adapter<TrainAdapter.TrainViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    class TrainViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val ivImage: ImageView = itemView.findViewById(R.id.iv_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDesc: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_train, parent, false)
        return TrainViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainViewHolder, position: Int) {
        val (image, name, desc) = trainList[position]
        holder.ivImage.setImageResource(image)
        holder.tvName.text = name
        holder.tvDesc.text = desc
        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailIntent::class.java)
            @Suppress("DEPRECATION")
            intentDetail.putExtra("train", trainList[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int {
        return trainList.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Train)
}}
