package com.example.mysololife.contentsLIst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysololife.R

class ContentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_list)

        val rv : RecyclerView = findViewById(R.id.rv)

        val items = ArrayList<ContentModel>()
        items.add(ContentModel("title","img"))
        items.add(ContentModel("title","img"))

        val rvAdapter = ContentRVAdapter(items)
        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(this,2)
    }
}