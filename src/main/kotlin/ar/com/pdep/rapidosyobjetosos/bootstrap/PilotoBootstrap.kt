package ar.com.pdep.rapidosyobjetosos.bootstrap

import ar.com.pdep.rapidosyobjetosos.dominio.Piloto
import ar.com.pdep.rapidosyobjetosos.dominio.audaz
import ar.com.pdep.rapidosyobjetosos.dominio.virtuoso
import ar.com.pdep.rapidosyobjetosos.repository.PilotosRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service

@Service
class PilotoBootstrap (val repoPilotos: PilotosRepository) : InitializingBean{
    override fun afterPropertiesSet() {
        this.crearPilotos()
    }

    fun crearPilotos(){
        repoPilotos.create(Piloto("Juan María Traverso"))
        repoPilotos.create(Piloto("José Froilán Gonzalez").apply { formaConducir = audaz(2) })
        repoPilotos.create(Piloto("Juan Manuel Fangio").apply { formaConducir = virtuoso(3) })
    }

}