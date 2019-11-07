package org.uqbar.rapidosobjetosos.domain

import Piloto
import Pista
import audaz
import cabulero
import kotlin.test.*
import org.junit.Test as test


class TestPilotos() {
    val pilotoCabulero = Piloto(cabulero)
    val pilotoAudaz = Piloto(audaz(3))

    @test fun `en una pista par multiplica por 10` () {
    val pistaPar =  Pista("Monaco", 5, 5)
    assertEquals(50,pilotoCabulero.tiempoDeVuelta(pistaPar))
    }

    @test fun `en una pista impar multiplica por 9`() {
        val pistaImpar = Pista("Estoril", 5,5)
        assertEquals(45,pilotoCabulero.tiempoDeVuelta(pistaImpar))
    }

    @test fun `en una pista común`() {
        val pista = Pista("Estoril", 5, 5)
        assertEquals(75, pilotoAudaz.tiempoDeVuelta(pista))
    }
}