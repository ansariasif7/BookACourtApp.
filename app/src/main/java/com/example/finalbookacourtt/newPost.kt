package com.example.finalbookacourtt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class newPost : AppCompatActivity() {

    private lateinit var nameP: TextView
    private lateinit var nameIP: EditText
    private lateinit var addressP: TextView
    private lateinit var addressIP: EditText
    private lateinit var timeP: TextView
    private lateinit var timeIP: EditText
    private lateinit var costPerHourP: TextView
    private lateinit var costPerHourIP: EditText
    private lateinit var postP: Button

    private lateinit var sNameIP: String
    private lateinit var sAddressIP: String
    private lateinit var sCostPerHourIP: String
    private lateinit var sTimeIP: String

    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        database = Firebase.database.reference

        postP = findViewById(R.id.postP)

        nameIP = findViewById(R.id.nameIP)
        addressIP = findViewById(R.id.addressIP)
        timeIP = findViewById(R.id.timeIP)
        costPerHourIP = findViewById(R.id.costPerHourIP)

        postP.setOnClickListener {

            sNameIP = nameIP.text.toString().trim()
            sAddressIP = addressIP.text.toString().trim()
            sCostPerHourIP = costPerHourIP.text.toString().trim()
            sTimeIP = timeIP.text.toString().trim()

            writeNewUser("1",sNameIP,sAddressIP,sTimeIP,sCostPerHourIP)
        }



    }



    fun writeNewUser(userId: String, name: String, address: String, time: String, cost: String,) {
        val user = User(name, address, time, cost)

        database.child("users").child(userId).setValue(user)
    }
}