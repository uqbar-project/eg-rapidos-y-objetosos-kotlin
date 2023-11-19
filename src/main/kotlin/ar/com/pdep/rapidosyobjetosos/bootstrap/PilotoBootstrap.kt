package ar.com.pdep.rapidosyobjetosos.bootstrap

import ar.com.pdep.rapidosyobjetosos.dominio.Piloto
import ar.com.pdep.rapidosyobjetosos.dominio.Pista
import ar.com.pdep.rapidosyobjetosos.dominio.audaz
import ar.com.pdep.rapidosyobjetosos.dominio.virtuoso
import ar.com.pdep.rapidosyobjetosos.repository.PilotosRepository
import ar.com.pdep.rapidosyobjetosos.repository.PistasRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service

@Service
class PilotoBootstrap (val repoPilotos: PilotosRepository, val repoPista: PistasRepository) : InitializingBean{
    override fun afterPropertiesSet() {
        this.crearPilotos()
        this.crearPistas()
    }

    fun crearPilotos(){
        repoPilotos.create(Piloto("Juan María Traverso"))
        repoPilotos.create(Piloto("José Froilán Gonzalez").apply { formaConducir = audaz(2) })
        repoPilotos.create(Piloto("Juan Manuel Fangio").apply { formaConducir = virtuoso(3) })
    }

    fun crearPistas(){
        repoPista.create(Pista("Monaco", 5))
        repoPista.create(Pista("Estoril", 5))
    }

}