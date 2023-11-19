package ar.com.pdep.rapidosyobjetosos.repository

import ar.com.pdep.rapidosyobjetosos.dominio.Entity
import ar.com.pdep.rapidosyobjetosos.dominio.Piloto
import ar.com.pdep.rapidosyobjetosos.dominio.Pista
import org.springframework.stereotype.Component

abstract class Repository<T: Entity>{
    val elementos = mutableListOf<T>()
    private var ultimoId = 1

    fun findById(id:Int) = elementos.find{it.id == id}
    open fun allInstances() = elementos.toList()
    fun create(elemento: T): T {
        elemento.id = ultimoId++
        elementos.add(elemento)
        return elemento
    }
    fun clear() {
        elementos.clear()
    }
}
@Component
class PilotosRepository: Repository<Piloto>() {

    override fun allInstances() = elementos.sortedBy { it.nombre }
    fun findByNombre(nombre: String) = elementos.find { it.nombre.uppercase() == nombre.uppercase() }

}

@Component
class PistasRepository: Repository<Pista>(){

}