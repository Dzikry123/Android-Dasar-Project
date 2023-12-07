package com.example.bangkit_recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

    class FoodAdapter(private val foodList: ArrayList<FoodDetail> ) : RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {
        private lateinit var onItemClickCallback: OnItemClickCallback

        fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback
        }

        interface OnItemClickCallback {
            fun onItemClicked(position: Int)
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return MyViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return foodList.size // tell adapter how many size the items
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentItem = foodList[position]
            holder.titleArticle.setImageResource(currentItem.titleArticle)
            holder.tvHeading.text = currentItem.heading
            holder.tvDesc.text = currentItem.desc

            holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(position) }

        }

        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val titleArticle : ShapeableImageView = itemView.findViewById(R.id.title_article)
            val tvHeading : TextView = itemView.findViewById(R.id.tvHeading)
            val tvDesc : TextView = itemView.findViewById(R.id.tvDesc)
        }
    }