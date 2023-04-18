package com.example.practica10_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private val database = Firebase.firestore
    private val userRef = database.collection("usuarios")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSave: Button = findViewById(R.id.save_button) as Button
        btnSave.setOnClickListener { saveMarkFromForms() }

    }
    private fun saveMarkFromForms(){
        var name: EditText =findViewById(R.id.et_name) as EditText
        var lastName: EditText = findViewById(R.id.et_lastName) as EditText
        var age: EditText =findViewById(R.id.et_age) as EditText

        val usuario = User(
            name.text.toString(),
            lastName.text.toString(),
            age.text.toString()
        )
        userRef.add(usuario)
        writeMark(usuario)
    }

    private fun writeMark(mark:User) {
        var listV: TextView = findViewById(R.id.list_textView) as TextView
        val text = listV.text.toString() + mark.toString() + "\n"
        listV.text = text
    }
}