package com.example.finalbookacourtt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Dashboard : AppCompatActivity() {

    private lateinit var text:TextView
    private lateinit var logout:FloatingActionButton
    private lateinit var forPost:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        text=findViewById(R.id.textView2)
        logout=findViewById(R.id.logout)
        forPost=findViewById(R.id.forPost)

        logout.setOnClickListener {
            Firebase.auth.signOut()

            val intent =Intent(this, login::class.java)
            startActivity(intent)

            Toast.makeText(this,"Logout Successful",Toast.LENGTH_LONG).show()
        }


        forPost.setOnClickListener {

            val intent =Intent(this, newPost::class.java)
            startActivity(intent)
        }




    }
}