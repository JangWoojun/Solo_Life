package com.example.mysololife.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mysololife.MainActivity
import com.example.mysololife.R
import com.example.mysololife.databinding.ActivityJoinBinding
import com.example.mysololife.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        binding.loginBtn.setOnClickListener {

            val email = binding.loginEmailArea.text.toString()
            val password = binding.loginPasswordArea.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        Toast.makeText(this,"로그인에 성공하셨습니다",Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        // 뒤로 가기 해도 회원가입 창 안 뜨게
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this,"로그인에 실패하셨습니다",Toast.LENGTH_LONG).show()
                    }
                }

        }






    }
}