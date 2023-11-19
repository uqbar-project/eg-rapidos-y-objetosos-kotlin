package ar.com.pdep.rapidosyobjetosos.service


import ar.com.pdep.rapidosyobjetosos.dominio.NotFoundException
import ar.com.pdep.rapidosyobjetosos.repository.PilotosRepository
import ar.com.pdep.rapidosyobjetosos.repository.PistasRepository
import org.springframework.stereotype.Service

@Service
class ServicePiloto (val pilotosRepository: PilotosRepository, val pistasRepository: PistasRepository){
    fun allInstances() = pilotosRepository.allInstances()
    fun calcularTiempo(idPiloto: Int, idPista: Int): Number {
        val piloto = pilotosRepository.findById(idPiloto)
        if (piloto === null) {
            throw NotFoundException("No existe el Piloto con el identificador $idPiloto")
        }
        val pista = pistasRepository.findById(idPista)
        if (pista === null) {
            throw NotFoundException("No existe la Pista con el identificador $idPista")
        }
        return piloto.tiempoDeVuelta(pista)
    }


}