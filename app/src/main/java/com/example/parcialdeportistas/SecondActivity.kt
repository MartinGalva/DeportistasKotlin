package com.example.parcialdeportistas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var spinnerPais: Spinner
    //private lateinit var listViewDeportistas: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val pais1 = intent.getStringExtra("pais1")
        val pais2 = intent.getStringExtra("pais2")
        val pais3 = intent.getStringExtra("pais3")

        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf(pais1, pais2, pais3))
        spinnerPais.adapter = adapterSpinner
    }
}