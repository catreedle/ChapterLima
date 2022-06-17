package com.example.chapterlima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        val namaUser = intent.getStringExtra("DATA_USER_NAME")
        val textTop : TextView = findViewById(R.id.text_name1) as TextView
        val textBottom : TextView = findViewById(R.id.text_name2) as TextView
//        var textName = R.id.text_name
        textTop.text = namaUser + " vs Pemain"
        textBottom.text = namaUser + " vs CPU"
    }
}