package com.example.finalbookacourtt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var signup:Button

    private lateinit var sEmail:String
    private lateinit var sPassword:String

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        signup = findViewById(R.id.signup)

        signup.setOnClickListener {

            sEmail=email.text.toString().trim()
            sPassword=password.text.toString().trim()

            auth.createUserWithEmailAndPassword(sEmail, sPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "createUserWithEmail:success")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }
        }
    }

    private fun updateUI(user: FirebaseUser?) {

        val intent = Intent(this,Dashboard::class.java)
        startActivity(intent)

    }
}