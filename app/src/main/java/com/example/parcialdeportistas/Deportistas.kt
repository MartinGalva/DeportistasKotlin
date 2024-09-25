package com.example.parcialdeportistas

data class Deportista (
    val nombre: String,
    val deporte: Deporte,
    val activo: Boolean,
    val pais: Pais
)

enum class Pais {
    ARGENTINA,
    BRASIL,
    COLOMBIA,
    CHILE,
    URUGUAY,
    ECUADOR,
    PERU
}

enum class Deporte {
    FUTBOL,
    TENIS,
    NATACION,
    ATLETISMO,
    BALONCESTO
}