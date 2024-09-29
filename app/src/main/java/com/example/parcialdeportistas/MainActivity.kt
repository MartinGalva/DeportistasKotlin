package com.example.parcialdeportistas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etPrimerPais: EditText
    private lateinit var etSegundoPais: EditText
    private lateinit var etTercerPais: EditText
    private lateinit var btnContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPrimerPais = findViewById(R.id.etFirstNation)
        etSegundoPais = findViewById(R.id.etSecondNation)
        etTercerPais = findViewById(R.id.etThirdNation)
        btnContinuar = findViewById(R.id.btnContinuar)

        btnContinuar.setOnClickListener {
            val pais1 = etPrimerPais.text.toString().uppercase()
            val pais2 = etSegundoPais.text.toString().uppercase()
            val pais3 = etTercerPais.text.toString().uppercase()

            if (paisValido(pais1) && paisValido(pais2) && paisValido(pais3) && paisesDistintos(pais1, pais2, pais3)) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("pais1", pais1)
                intent.putExtra("pais2", pais2)
                intent.putExtra("pais3", pais3)
                startActivity(intent)
            } else{
                Toast.makeText(this, "Debe ingresar 3 paises validos distintos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun paisValido(pais: String) : Boolean {
        return try {
            enumValueOf<Pais>(pais)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    private fun paisesDistintos(p1: String, p2: String, p3: String): Boolean {
        return p1 != p2 && p1 != p3 && p2 != p3
    }
}