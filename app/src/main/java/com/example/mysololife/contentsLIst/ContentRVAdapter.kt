package com.example.mysololife.contentsLIst

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.mysololife.R

class ContentRVAdapter (val items : ArrayList<ContentModel>) : RecyclerView.Adapter<ContentRVAdapter.Viewholder>(){

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

        }

    }

}