package com.example.mysololife.utils

import android.content.Intent
import android.os.Handler
import com.example.mysololife.MainActivity
import com.example.mysololife.auth.IntroActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class FBAuth {
    companion object {
        private lateinit var auth: FirebaseAuth

        fun getUid(): String {
            auth = Firebase.auth

            return auth.currentUser?.uid.toString()
        }
        fun getTime() : String {
            val currentDateTime = Calendar.getInstance().time
            val dateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss",Locale.KOREA).format(currentDateTime)
            return dateFormat
        }
    }
}