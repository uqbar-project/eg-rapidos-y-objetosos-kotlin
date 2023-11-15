package ar.com.pdep.rapidosyobjetosos.controller

import ar.com.pdep.rapidosyobjetosos.dominio.Piloto
import ar.com.pdep.rapidosyobjetosos.service.ServicePiloto
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class PilotoController(val servicePiloto: ServicePiloto) {

    @GetMapping("/pilotos")
    fun getPilotos(): MutableList<Piloto> = servicePiloto.allInstances()
}