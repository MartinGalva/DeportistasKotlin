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
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etPrimerPais = findViewById(R.id.etFirstNation)
        etSegundoPais = findViewById(R.id.etSecondNation)
        etTercerPais = findViewById(R.id.etThirdNation)
        btnContinuar = findViewById(R.id.btnContinuar)

        btnContinuar.setOnClickListener {
            val pais1 = etPrimerPais.text.toString().uppercase()
            val pais2 = etSegundoPais.text.toString().uppercase()
            val pais3 = etTercerPais.text.toString().uppercase()

            if (paisValido(pais1) && paisValido(pais2) && paisValido(pais3)) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("pais1", pais1)
                intent.putExtra("pais2", pais2)
                intent.putExtra("pais3", pais3)
                startActivity(intent)
            } else{
                Toast.makeText(this, "Debe ingresar 3 paises validos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun paisValido(pais: String) : Boolean {
        Log.w(this.localClassName, "paisValido: " + pais )
        return try {
            enumValueOf<Pais>(pais)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }
}