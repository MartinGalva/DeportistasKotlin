package com.example.parcialdeportistas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        textView = findViewById(R.id.tvDeportista)
        btn = findViewById(R.id.btnVolver)

        val deportista = intent.getSerializableExtra("deportista", Deportista::class.java) as Deportista
        textView.text = deportista.mostrarDeportista()

        btn.setOnClickListener{
            finish()
        }
    }
}