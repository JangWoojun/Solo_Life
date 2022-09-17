package com.example.mysololife.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.mysololife.R

class BoardListLVAdapter(val boardList : MutableList<BoardModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItem(p0: Int): Any {
        return boardList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {

        var converView = p1
        if (converView == null){
            converView = LayoutInflater.from(p2?.context).inflate(R.layout.board_list_item,p2,false)
        }
        return converView
    }
}