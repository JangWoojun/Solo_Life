package com.example.mysololife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.mysololife.auth.IntroActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        // 로그인 되어있는 사용자면 바로 main으로 안되어 있으면 intro로

        if(auth.currentUser?.uid == null){
            Handler().postDelayed({
                startActivity(Intent(this,IntroActivity::class.java))
                finish()
            },3000)
        }
        else {
            Handler().postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            },3000)
        }



    }
}