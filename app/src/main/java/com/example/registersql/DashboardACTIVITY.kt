package com.example.registersql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class DashboardACTIVITY : AppCompatActivity() {

    private lateinit var logoubutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

         logoubutton = findViewById(R.id.btnlogout)

        logoubutton.setOnClickListener {

            Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show()

            var gobacktologin = Intent(this, loginActivity::class.java)
            startActivity(gobacktologin)

        }
    }
}