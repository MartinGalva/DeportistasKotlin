package com.example.parcialdeportistas

import java.io.Serializable

data class Deportista (
    val nombre: String,
    val deporte: Deporte,
    val activo: Boolean,
    val pais: Pais
) : Serializable {
    override fun toString(): String {
        return nombre
    }

    fun mostrarDeportista(): String {
        val activoSN : String = if (this.activo) {
            "Si"
        } else {
            "No"
        }
        return "Nombre: $nombre\nDeporte: $deporte\nActivo: $activoSN\nPais: $pais"
    }
}

enum class Pais {
    ARGENTINA,
    BRASIL,
    COLOMBIA,
    ECUADOR,
    CHILE
}

enum class Deporte {
    FUTBOL,
    TENIS,
    NATACION,
    ATLETISMO,
    BALONCESTO,
    AUTOMOVILISMO,
    HOCKEY,
    BOXEO,
    VOLEIBOL,
    CICLISMO,
    EQUITACION,
    GOLF,
    LEVANTAMIENTO,
    TIRO,
    ARTES_MARCIALES
}