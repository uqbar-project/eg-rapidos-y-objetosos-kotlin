package ar.com.pdep.rapidosyobjetosos.dominio

class Piloto(val nombre: String): Entity() {
    var formaConducir = cabulero

    fun tiempoDeVuelta(pista: Pista): Number {
        return this.formaConducir(pista)
    }
}