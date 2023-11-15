package ar.com.pdep.rapidosyobjetosos.dominio

class Pista(val nombre: String = "", val largoPorVuelta: Int = 0, val cantidadCurvas: Int = 7)  {
    fun nombrePar(): Boolean = this.nombre.length % 2 == 0


}