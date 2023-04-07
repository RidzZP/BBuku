package com.example.bbuku

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var txtUsername: EditText
    lateinit var txtPassword: EditText

    lateinit var btnLogin: Button
    lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()

        btnLogin.setOnClickListener{
            val databaseHelper = DBHelper(this)
            val cursor = databaseHelper.allDataUser()

            val flag = 0
            while (cursor.moveToNext()){
                if (txtUsername.text.toString().equals(cursor.getString(2))&&txtPassword.text.toString().equals(cursor.getString(3))){
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    break
                }
            }

            if (flag == 0){
                Toast.makeText(this, "User Not Found Pastikan Sudah Register", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegister.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun init(){
        txtUsername = findViewById(R.id.txtUsernameLogin)
        txtPassword = findViewById(R.id.txtPasswordLogin)

        btnLogin = findViewById(R.id.btnLogin2)
        btnRegister = findViewById(R.id.btnRegister2)
    }
}