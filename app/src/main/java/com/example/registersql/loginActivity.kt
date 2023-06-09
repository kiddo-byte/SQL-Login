package com.example.registersql

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class loginActivity : AppCompatActivity() {

    private lateinit var emailtext: EditText
    private lateinit var passwordtext: EditText
    private lateinit var loginbutton: Button
    private lateinit var registerbutton: Button
    lateinit var db:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailtext = findViewById(R.id.txtemail)
        passwordtext = findViewById(R.id.txtp)
        loginbutton = findViewById(R.id.btnlogin)
        registerbutton = findViewById(R.id.btnregister)

        db = openOrCreateDatabase("SeansDB", Context.MODE_PRIVATE, null)

        loginbutton.setOnClickListener {

            var email = emailtext.text.toString().trim()
            var password = passwordtext.text.toString().trim()

           if(email.isEmpty() || password.isEmpty()){

               Toast.makeText(this,"Cannot supply an empty field,input required", Toast.LENGTH_SHORT).show()

           }else{

               val cursor = db.rawQuery("SELECT * FROM clients WHERE Arafa=? AND Usalama=?", arrayOf(email, password))

               if (cursor != null && cursor.moveToFirst()) {

                   val intent = Intent(this, DashboardACTIVITY::class.java)
                   startActivity(intent)
                   finish()

                   Toast.makeText( this,"Login Successful", Toast.LENGTH_SHORT).show()

               } else {
                   Toast.makeText(this, "Invalid email or password, please try again", Toast.LENGTH_SHORT).show()
               }

           }
        }

        registerbutton.setOnClickListener {

            var gotoregister = Intent(this, MainActivity::class.java)
            startActivity(gotoregister)

        }
    }

}
