package ar.com.pdep.rapidosyobjetosos.dominio

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe


class PilotoTest: DescribeSpec({
    describe("cuando un piloto es cabulero") {
        val pilotoCabulero: Piloto = Piloto()

        it("su tiempo en una pista par multiplica por 10") {
            val pistaPar = Pista("Monaco", 5)
            pilotoCabulero.tiempoDeVuelta(pistaPar) shouldBe 50
        }

        it("su tiempo en una pista impar multiplica por 9") {
            val pistaImpar =  Pista("Estoril", 5)
            pilotoCabulero.tiempoDeVuelta(pistaImpar) shouldBe 45
        }
    }

    describe("cuando un piloto es audaz") {
        val pilotoAudaz: Piloto = Piloto().apply { formaConducir = audaz(2) }

        it("su tiempo en una pista depende de la cantidad de curvas") {
            val pista = Pista("Jacarepagua", 4)
            pilotoAudaz.tiempoDeVuelta(pista) shouldBe 56
        }
    }

    describe("cuando un piloto es vituoso") {
        val pilotoVirtuoso: Piloto = Piloto().apply { formaConducir = virtuoso(3) }

        it("su tiempo en una pista depende del nivel de virtuosismo") {
            val pista = Pista("Jacarepagua", 4)
            pilotoVirtuoso.tiempoDeVuelta(pista) shouldBe 40
        }
    }
})