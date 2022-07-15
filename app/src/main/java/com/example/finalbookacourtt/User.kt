package com.example.finalbookacourtt

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(val name: String? = null, val address: String? = null, val time: String? = null, val cost: String? = null) {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}
