package com.example.tzva_naloga_1.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.lang.Exception
@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {
    private lateinit var user: FirebaseAuth
    private lateinit var binding: com.example.tzva_naloga_1.databinding.ActivityLoginBinding
    private lateinit var googleSignInClient: GoogleSignInClient;

    private companion object{
        private const val RC_SIGN_IN=100
        private const val TAG="GOOGLE_SIGN_IN_TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val googleSignInOptions=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient= GoogleSignIn.getClient(this, googleSignInOptions)

        user = FirebaseAuth.getInstance();

        binding.registerBtn.setOnClickListener{
            registerUser()
        }
        binding.signInButton.setOnClickListener{
            val intent=googleSignInClient.signInIntent
            startActivityForResult(intent, RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== RC_SIGN_IN){
            Log.d(TAG, "onActivity result ")
            val accountTask=GoogleSignIn.getSignedInAccountFromIntent(data)
            try{
                val account= accountTask.getResult(ApiException::class.java)
                firebaseAuthWithGoogleAccount(account)
            }catch (e:Exception){
                Log.d(TAG, "Error: " + e.message)
            }
        }
    }

    private fun firebaseAuthWithGoogleAccount(account: GoogleSignInAccount?){
        val credential =  GoogleAuthProvider.getCredential(account!!.idToken, null);
        user.signInWithCredential(credential)
            .addOnSuccessListener { authResult->
                Log.d(TAG, "Logged in ")
                val firebaseUser=user.currentUser
                val email=firebaseUser!!.uid

                if(authResult.additionalUserInfo!!.isNewUser){
                    Log.d(TAG, "User is new account created - email: " +email)
                }else{
                    Log.d(TAG, "Existing user - email: " +email)
                }
                startActivity((Intent(this, MainActivity::class.java)))
            }
            .addOnFailureListener{e->
                Log.d(TAG, "Login failed " +e.message)
            }
    }

    private fun registerUser(){
        val email= binding.editTextTextEmailAddress.text.toString().trim()
        val password=binding.editTextTextPassword.text.toString().trim()

        if(email.isNotEmpty() && password.isNotEmpty()){
            user.createUserWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity()){
                task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "User added to db", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }else{
                    user.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener{mTask->
                            if (mTask.isSuccessful){
                                startActivity(Intent(this, MainActivity::class.java))
                                Toast.makeText(this, "Welcome user " + user.currentUser?.email, Toast.LENGTH_SHORT).show()
                            }else{
                                Toast.makeText(this, mTask.exception!!.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    Toast.makeText(this, task.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            Toast.makeText(this, "Email or password can not be empty", Toast.LENGTH_SHORT).show()
        }
    }
}