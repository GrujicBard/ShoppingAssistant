package com.example.tzva_naloga_1.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tzva_naloga_1.R
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.example.tzva_naloga_1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var user: FirebaseAuth
    private lateinit var signInRequest: BeginSignInRequest
    lateinit var signInClient: GoogleSignInClient
    private lateinit var binding: com.example.tzva_naloga_1.databinding.ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = FirebaseAuth.getInstance();

        binding.registerBtn.setOnClickListener{
            registerUser()
        }


    }
    private fun registerUser(){
        val email= binding.email.text.toString().trim()
        val password=binding.pwd.text.toString().trim()

        print(email)

        if(email.isNotEmpty() && password.isNotEmpty()){
            user.createUserWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity()){
                task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "User added to db", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(this, task.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            Toast.makeText(this, "Email or password can not be empty", Toast.LENGTH_SHORT).show()

        }
    }


}