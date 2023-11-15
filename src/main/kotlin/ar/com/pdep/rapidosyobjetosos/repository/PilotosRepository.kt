package ar.com.pdep.rapidosyobjetosos.repository

import ar.com.pdep.rapidosyobjetosos.dominio.Piloto
import org.springframework.stereotype.Component

@Component
class PilotosRepository {
    val pilotos = mutableListOf<Piloto>()

    companion object {
        private var ultimoId = 1
    }

    fun allInstances() = pilotos.sortBy { it.nombre }
    fun findByNombre(nombre: String) = pilotos.find { it.nombre.uppercase() == nombre.uppercase() }
    fun findById(id:Int) = pilotos.find {it.id == id}

    fun create(piloto: Piloto): Piloto {
        piloto.id = ultimoId++
        pilotos.add(piloto)
        return piloto
    }

    fun clear() {
        pilotos.clear()
    }
}