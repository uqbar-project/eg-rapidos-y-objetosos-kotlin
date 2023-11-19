package ar.com.pdep.rapidosyobjetosos.dominio

typealias FormaDeConducir = (Pista) -> Int

val MULTIPLICADOR_PAR = 10
val MULTIPLICADOR_IMPAR = 9

val audaz: (Int) -> FormaDeConducir = { tiempoCurva ->
    { pista ->
        pista.cantidadCurvas * tiempoCurva * pista.largoPorVuelta
    }
}

const val VALOR_BASE = 30
val virtuoso: (Int) -> FormaDeConducir =
    { nivelVirtuosismo -> { pista -> pista.largoPorVuelta * (VALOR_BASE / nivelVirtuosismo) } }

val cabulero: FormaDeConducir = { pista -> pista.largoPorVuelta * efectoMultiplicador(pista) }

val efectoMultiplicador = { pista: Pista -> if (pista.nombrePar()) MULTIPLICADOR_PAR else MULTIPLICADOR_IMPAR }