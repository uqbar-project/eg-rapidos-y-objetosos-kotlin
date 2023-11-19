package ar.com.pdep.rapidosyobjetosos.dominio

import com.fasterxml.jackson.annotation.JsonIgnore

class Piloto(val nombre: String): Entity() {

    @JsonIgnore
    var formaConducir = cabulero

    fun tiempoDeVuelta(pista: Pista): Number {
        return this.formaConducir(pista)
    }
}