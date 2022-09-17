package com.example.mysololife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mysololife.R
import com.example.mysololife.contentsLIst.BookmarkModel
import com.example.mysololife.databinding.ActivityBoardWriteBinding
import com.example.mysololife.utils.FBAuth
import com.example.mysololife.utils.FBRef

class BoardWriteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBoardWriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_board_write)

        binding.writeBtn.setOnClickListener {
            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()
            val uid = FBAuth.getUid()
            val time = FBAuth.getTime()

            FBRef.boardRef
                .push()
                .setValue(BoardModel(title,content,uid,time))

            Toast.makeText(this,"게시글 생성 완료",Toast.LENGTH_LONG).show()
            finish()
        }

    }
}