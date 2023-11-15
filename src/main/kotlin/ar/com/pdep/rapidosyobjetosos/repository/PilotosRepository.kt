package ar.com.pdep.rapidosyobjetosos.repository

import ar.com.pdep.rapidosyobjetosos.dominio.Piloto
import org.springframework.stereotype.Component

@Component
class PilotosRepository {
    val pilotos = mutableListOf<Piloto>()

    companion object {
        private var ultimoId = 1
    }

    fun allInstances() = pilotos

    fun create(piloto: Piloto): Piloto {
        piloto.id = ultimoId++
        pilotos.add(piloto)
        return piloto
    }

    fun clear() {
        pilotos.clear()
    }
}