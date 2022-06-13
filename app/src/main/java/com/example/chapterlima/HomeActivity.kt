package com.example.chapterlima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val layoutRoot = findViewById<ConstraintLayout>(R.id.layout_root)

        val namaUser = intent.getStringExtra("DATA_USER_NAME")

        Snackbar.make(layoutRoot, "Selamat Datang $namaUser", Snackbar.LENGTH_LONG).show()

    }
}