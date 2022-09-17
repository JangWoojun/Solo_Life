package com.example.mysololife.contentsLIst

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mysololife.R

class ContentRVAdapter (val context : Context, val items : ArrayList<ContentModel>) : RecyclerView.Adapter<ContentRVAdapter.Viewholder>(){



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item,parent,false)
            return Viewholder(v) // 아이템들을 가져와서 레이아웃 만들어줌
        }

        override fun onBindViewHolder(holder : ContentRVAdapter.Viewholder, position: Int) {

            holder.bindItems(items[position]) // 아이템에 연결?
        }

        override fun getItemCount(): Int {
            return items.size // 아이템 사이즈
        }

    inner class Viewholder (itemView : View) : RecyclerView.ViewHolder(itemView) { // rv_item에 넣어주는 부분

        fun bindItems (item : ContentModel) {

            itemView.setOnClickListener {
                val intent = Intent(context,ContentShowActivity::class.java)
                intent.putExtra("url",item.webUrl)
                itemView.context.startActivities(arrayOf(intent))
            }

            val contentTitle =itemView.findViewById<TextView>(R.id.textArea)
            val imageView = itemView.findViewById<ImageView>(R.id.imageArea)

            contentTitle.text = item.title

            Glide.with(context)
                .load(item.imageUrl)
                .into(imageView)
        }

    }

}