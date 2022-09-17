package com.example.mysololife.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mysololife.R
import com.example.mysololife.board.BoardListLVAdapter
import com.example.mysololife.board.BoardModel
import com.example.mysololife.board.BoardWriteActivity
import com.example.mysololife.contentsLIst.ContentModel
import com.example.mysololife.databinding.FragmentTalkBinding
import com.example.mysololife.utils.FBAuth
import com.example.mysololife.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class TalkFragment : Fragment() {
    private lateinit var binding: FragmentTalkBinding

    private val boardDataList = mutableListOf<BoardModel>()

    private lateinit var boardRVAdapter : BoardListLVAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_talk, container, false)

//        val boardList = mutableListOf<BoardModel>()

        boardRVAdapter = BoardListLVAdapter(boardDataList)

        binding.boardListView.adapter = boardRVAdapter


        binding.writeBtn.setOnClickListener {
            val intent = Intent(context, BoardWriteActivity::class.java)
            startActivity(intent)
        }

        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_tipFragment)
        }
        binding.StoreTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_storeFragment)
        }
        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_bookmarkFragment)
        }
        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_homeFragment)
        }
        getFBBoardData()
        return binding.root
    }

    private fun getFBBoardData() {
            val postListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    boardDataList.clear()

                    for (dataModel in dataSnapshot.children) {
                        val item = dataModel.getValue(BoardModel::class.java)
                        boardDataList.add(item!!)
                    }
                    boardRVAdapter.notifyDataSetChanged()
                    Log.d("TalkFragment",boardDataList.toString())

                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message
                    Log.w("TalkFragment", "loadPost:onCancelled", databaseError.toException())
                }
            }
            FBRef.boardRef.addValueEventListener(postListener)
        }

    }