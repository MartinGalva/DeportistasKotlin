package com.example.parcialdeportistas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var spinnerPais: Spinner
    private lateinit var listViewDeportistas: ListView
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        spinnerPais = findViewById(R.id.spinnerPais)
        listViewDeportistas = findViewById(R.id.lvDeportistas)
        btnVolver = findViewById(R.id.btnVolver1)

        val pais1 = intent.getStringExtra("pais1")
        val pais2 = intent.getStringExtra("pais2")
        val pais3 = intent.getStringExtra("pais3")

        val deporArg = listOf(Deportista("Lionel Messi", Deporte.FUTBOL, true, Pais.ARGENTINA),
            Deportista("Gabriela Sabatini", Deporte.TENIS, false, Pais.ARGENTINA),
            Deportista("Diego Maradona", Deporte.FUTBOL, false, Pais.ARGENTINA),
            Deportista("Manu Ginóbili", Deporte.BALONCESTO, false, Pais.ARGENTINA),
            Deportista("Ringo Bonavena", Deporte.BOXEO, false, Pais.ARGENTINA),
            Deportista("Juan Martín del Potro", Deporte.TENIS, false, Pais.ARGENTINA),
            Deportista("Luciana Aymar", Deporte.HOCKEY, true, Pais.ARGENTINA),
            Deportista("Carlos Reutemann", Deporte.AUTOMOVILISMO, false, Pais.ARGENTINA),
            Deportista("Nicolás Massú", Deporte.TENIS, false, Pais.ARGENTINA),
            Deportista("Emanuel Ginóbili", Deporte.BALONCESTO, false, Pais.ARGENTINA)
        )
        val deporBra = listOf(Deportista("Pelé", Deporte.FUTBOL, false, Pais.BRASIL),
            Deportista("Gustavo Kuerten", Deporte.TENIS, false, Pais.BRASIL),
            Deportista("Ayrton Senna", Deporte.AUTOMOVILISMO, false, Pais.BRASIL),
            Deportista("Marta Vieira da Silva", Deporte.FUTBOL, true, Pais.BRASIL),
            Deportista("Adhemar Ferreira da Silva", Deporte.ATLETISMO, false, Pais.BRASIL),
            Deportista("Rodrigo Pessoa", Deporte.EQUITACION, false, Pais.BRASIL),
            Deportista("Ademir da Guia", Deporte.FUTBOL, false, Pais.BRASIL),
            Deportista("Giba", Deporte.VOLEIBOL, false, Pais.BRASIL),
            Deportista("Gisele Bündchen", Deporte.ATLETISMO, false, Pais.BRASIL),
            Deportista("Vanderlei Cordeiro de Lima", Deporte.ATLETISMO, false, Pais.BRASIL)
        )
        val deporCol = listOf(Deportista("Mariana Pajón", Deporte.CICLISMO, true, Pais.COLOMBIA),
            Deportista("Caterine Ibargüen", Deporte.ATLETISMO, true, Pais.COLOMBIA),
            Deportista("Rigoberto Urán", Deporte.CICLISMO, true, Pais.COLOMBIA),
            Deportista("Nairo Quintana", Deporte.CICLISMO, true, Pais.COLOMBIA),
            Deportista("María Isabel Urrutia", Deporte.LEVANTAMIENTO, true, Pais.COLOMBIA),
            Deportista("Anthony Zambrano", Deporte.ATLETISMO, true, Pais.COLOMBIA),
            Deportista("Óscar Figueroa", Deporte.LEVANTAMIENTO, true, Pais.COLOMBIA),
            Deportista("Ingrid Valencia", Deporte.BOXEO, true, Pais.COLOMBIA),
            Deportista("Faustino Asprilla", Deporte.FUTBOL, false, Pais.COLOMBIA),
            Deportista("Camilo Villegas", Deporte.GOLF, true, Pais.COLOMBIA))
        val deporEcu = listOf(Deportista("Jefferson Pérez", Deporte.ATLETISMO, false, Pais.ECUADOR),
            Deportista("Milena Ayón", Deporte.NATACION, true, Pais.ECUADOR),
            Deportista("Byron Piedra", Deporte.ATLETISMO, true, Pais.ECUADOR),
            Deportista("Glenda Morejón", Deporte.ATLETISMO, true, Pais.ECUADOR),
            Deportista("Segundo Linares", Deporte.BOXEO, false, Pais.ECUADOR),
            Deportista("Maritza Chila", Deporte.ATLETISMO, true, Pais.ECUADOR),
            Deportista("Alfredo Bone", Deporte.BOXEO, false, Pais.ECUADOR),
            Deportista("Polo Montaño", Deporte.ATLETISMO, true, Pais.ECUADOR),
            Deportista("Andrea Pérez", Deporte.NATACION, true, Pais.ECUADOR),
            Deportista("Jonathan Caicedo", Deporte.CICLISMO, true, Pais.ECUADOR)
        )
        val deporChi = listOf(
            Deportista("Nicolás Massú", Deporte.TENIS, false, Pais.CHILE),
            Deportista("Fernando González", Deporte.TENIS, false, Pais.CHILE),
            Deportista("Kristel Köbrich", Deporte.NATACION, true, Pais.CHILE),
            Deportista("Francisca Crovetto", Deporte.TIRO, true, Pais.CHILE),
            Deportista("Yasmani Acosta", Deporte.ARTES_MARCIALES, true, Pais.CHILE),
            Deportista("Joaquín Niemann", Deporte.GOLF, true, Pais.CHILE),
            Deportista("Marcelo Ríos", Deporte.TENIS, false, Pais.CHILE),
            Deportista("Iván Zamorano", Deporte.FUTBOL, false, Pais.CHILE),
            Deportista("María José Moya", Deporte.TENIS, false, Pais.CHILE),
            Deportista("Claudio Bravo", Deporte.FUTBOL, true, Pais.CHILE)
        )

        val deportistas1 = when (pais1) {
            "ARGENTINA" -> deporArg
            "BRASIL" -> deporBra
            "COLOMBIA" -> deporCol
            "ECUADOR" -> deporEcu
            "CHILE" -> deporChi
            else -> emptyList()
        }
        val deportistas2 = when (pais2) {
            "ARGENTINA" -> deporArg
            "BRASIL" -> deporBra
            "COLOMBIA" -> deporCol
            "ECUADOR" -> deporEcu
            "CHILE" -> deporChi
            else -> emptyList()
        }
        val deportistas3 = when (pais3) {
            "ARGENTINA" -> deporArg
            "BRASIL" -> deporBra
            "COLOMBIA" -> deporCol
            "ECUADOR" -> deporEcu
            "CHILE" -> deporChi
            else -> emptyList()
        }

        val deportistas = listOf(deportistas1, deportistas2, deportistas3)
        val deportistasElegidos = mutableListOf<Deportista>()

        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf(pais1, pais2, pais3))
        spinnerPais.adapter = adapterSpinner
        val adapterListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, deportistasElegidos)
        listViewDeportistas.adapter = adapterListView

        spinnerPais.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                deportistasElegidos.clear()
                deportistasElegidos.addAll(deportistas[p2])
                adapterListView.notifyDataSetChanged()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        listViewDeportistas.setOnItemClickListener { _, _, position, _ ->
            run {
                val deportista = deportistasElegidos[position]
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("deportista", deportista)
                startActivity(intent)
            }
        }

        btnVolver.setOnClickListener{
            finish()
        }
    }
}