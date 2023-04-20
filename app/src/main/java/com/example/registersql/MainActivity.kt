package com.example.registersql

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var txtname:EditText
    private lateinit var txtidentity:EditText
    private lateinit var txtemail:EditText
    private lateinit var passwordtext:EditText
    private lateinit var buttonc:Button
    private lateinit var db:SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtname = findViewById(R.id.edtname)
        txtidentity = findViewById(R.id.txtname)
        txtemail = findViewById(R.id.Emailtxt)
        passwordtext = findViewById(R.id.txtpass)
        buttonc = findViewById(R.id.btncreate)


        db = openOrCreateDatabase("SeansDB", Context.MODE_PRIVATE, null)

        db.execSQL("CREATE TABLE IF NOT EXISTS clients(Jina VACHAR, Jina2 VACHAR, Arafa VACHAR, Usalama VACHAR)")

        buttonc.setOnClickListener {

            var name = txtname.text.toString().trim()
            var identity = txtidentity.text.toString().trim()
            var mail = txtemail.text.toString().trim()
            var pass = passwordtext.text.toString().trim()


            if(name.isEmpty() || identity.isEmpty() || mail.isEmpty() || pass.isEmpty()){

                Toast.makeText( this,"Cannot submit empty field,input required", Toast.LENGTH_SHORT).show()
            }else{
                db.execSQL("INSERT INTO clients VALUES ('"+name+"','"+identity+"','"+mail+"','"+pass+"')")

                Toast.makeText(this,"DATA SAVED SUCCESSFULLY", Toast.LENGTH_SHORT).show()

                var gotologin = Intent(this, loginActivity::class.java)
                startActivity(gotologin)
            }

        }
    }
}

