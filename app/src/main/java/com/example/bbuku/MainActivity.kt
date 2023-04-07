package com.example.bbuku

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

    lateinit var txtNama: EditText
    lateinit var txtUsername: EditText
    lateinit var txtPassword: EditText

    lateinit var btnRegister: Button
    lateinit var btnLogin: Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        btnRegister.setOnClickListener{
            if (txtNama.text.toString().isEmpty()){
                Toast.makeText(this, "Nama Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            } else if (txtUsername.text.toString().isEmpty()){
                Toast.makeText(this, "Username Tdak Boleh Kosong", Toast.LENGTH_SHORT).show()
            } else if (txtPassword.text.toString().isEmpty()){
                Toast.makeText(this, "Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            } else {
                addUserToDatabase()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

        btnLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addUserToDatabase() {
        val databaseHelper = DBHelper(this)
        val db = databaseHelper.writableDatabase

        val values = ContentValues().apply{
            put("nama", txtNama.text.toString())
            put("username", txtUsername.text.toString())
            put("password", txtPassword.text.toString())
        }

        db.insert("user", null, values)
    }

    private fun init(){
        txtNama = findViewById(R.id.txtNama)
        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)

        btnRegister = findViewById(R.id.btnRegister)
        btnLogin = findViewById(R.id.btnLogin)
    }
}