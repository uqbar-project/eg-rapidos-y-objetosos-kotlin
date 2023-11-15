package ar.com.pdep.rapidosyobjetosos.service


import ar.com.pdep.rapidosyobjetosos.repository.PilotosRepository
import org.springframework.stereotype.Service

@Service
class ServicePiloto (val pilotosRepository: PilotosRepository){
    fun allInstances() = pilotosRepository.allInstances()

}