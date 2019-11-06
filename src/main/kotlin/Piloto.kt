const val MULTIPLICADOR_PAR = 10
const val MULTIPLICADOR_IMPAR = 9

const val VALOR_BASE = 30

class Piloto(var formaDeConducir: (Pista) -> Int) {
    fun tiempoDeVuelta(pista: Pista): Int = this.formaDeConducir(pista)
}

val audaz =  {tiempoCurva: Int ->{ pista: Pista -> pista.cantidadCurvas * tiempoCurva * pista.largoPorVuelta}}

val virtuoso =  {nivelVirtuosismo: Int -> { pista: Pista ->  pista.largoPorVuelta * (VALOR_BASE / nivelVirtuosismo)}}

val cabulero = {pista: Pista -> pista.largoPorVuelta * efectoMultiplicador(pista)}

fun efectoMultiplicador (pista: Pista): Int = if (pista.nombrePar())  MULTIPLICADOR_PAR else MULTIPLICADOR_IMPAR

class Pista(private val nombre: String, val largoPorVuelta: Int, val cantidadCurvas: Int) {

    fun nombrePar(): Boolean = this.nombre.length % 2 == 0
}