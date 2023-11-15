package ar.com.pdep.rapidosyobjetosos.dominio

class Piloto {
    var formaConducir = cabulero

    fun tiempoDeVuelta(pista: Pista): Number {
        return this.formaConducir(pista)
    }
}