package com.example.mysololife.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mysololife.MainActivity
import com.example.mysololife.R
import com.example.mysololife.databinding.ActivityIntroBinding
import com.example.mysololife.databinding.ActivityJoinBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityJoinBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_join)

        auth = Firebase.auth

        binding.joinBtn.setOnClickListener {

            var check = true

            val email = binding.joinEmailArea.text.toString()
            val password = binding.joinPasswordArea.text.toString()
            val passwordCheck = binding.joinPasswordCheckArea.text.toString()

            // 값이 비어있는 지 확인

            if (email.isEmpty()){
                Toast.makeText(this,"이메일을 입력해 주세요",Toast.LENGTH_LONG).show()
                check = false
            }
            if (password.isEmpty()){
                Toast.makeText(this,"비밀먼호를 입력해 주세요",Toast.LENGTH_LONG).show()
                check = false
            }
            if (passwordCheck.isEmpty()){
                Toast.makeText(this,"비밀번호 확인란을 입력해 주세요",Toast.LENGTH_LONG).show()
                check = false
            }
            if (password!=passwordCheck){
                Toast.makeText(this,"비밀번호 확인란이 다릅니다",Toast.LENGTH_LONG).show()
                check = false
            }
            if (password.length < 6){
                Toast.makeText(this,"비밀번호를 6자리 이상 입력해 주세요",Toast.LENGTH_LONG).show()
                check = false
            }

            if (check){
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this,"회원가입에 성공하셨습니다", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, MainActivity::class.java)
                            // 뒤로 가기 해도 회원가입 창 안 뜨게
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        }
                        else {
                            Toast.makeText(this,"회원가입에 실패하셨습니다", Toast.LENGTH_LONG).show()
                        }
                }
            }



        }


  }
}