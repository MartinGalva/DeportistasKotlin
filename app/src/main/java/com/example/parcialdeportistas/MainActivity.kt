package com.example.parcialdeportistas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
            val pais1 = etPrimerPais.text.toString().trim().uppercase()
            val pais2 = etSegundoPais.text.toString().trim().uppercase()
            val pais3 = etTercerPais.text.toString().trim().uppercase()

            val paises = listOf(pais1, pais2, pais3)

            if (paisesValidos(paises) && paisesDistintos(paises)) {
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

    private fun paisesValidos(paises : List<String>): Boolean {
        try {
            for (pais in paises) {
                enumValueOf<Pais>(pais)
            }
            return true
        } catch (e: IllegalArgumentException) {
            return false
            }
    }

    private fun paisesDistintos(paises : List<String>): Boolean {
        return paises.distinct().size == paises.size
    }
}