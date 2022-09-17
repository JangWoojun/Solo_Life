package com.example.mysololife.utils

import android.content.Intent
import android.os.Handler
import com.example.mysololife.MainActivity
import com.example.mysololife.auth.IntroActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FBAuth {
    companion object {
        private lateinit var auth: FirebaseAuth

        fun getUid(): String {
            auth = Firebase.auth

            return auth.currentUser?.uid.toString()
        }
    }
}