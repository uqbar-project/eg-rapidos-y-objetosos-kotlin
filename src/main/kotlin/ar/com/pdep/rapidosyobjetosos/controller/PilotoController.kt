package ar.com.pdep.rapidosyobjetosos.controller

import ar.com.pdep.rapidosyobjetosos.dominio.Piloto
import ar.com.pdep.rapidosyobjetosos.service.ServicePiloto
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class PilotoController(val servicePiloto: ServicePiloto) {

    @GetMapping("/pilotos")
    @Operation(summary = "Devuelve todos los pilotos")
    fun getPilotos(): List<Piloto> = servicePiloto.allInstances()

    @GetMapping("/piloto/{idPiloto}/tiempo/{idPista}")
    fun getTiempo(@PathVariable idPiloto: Int, @PathVariable idPista: Int):Number =
        servicePiloto.calcularTiempo(idPiloto,idPista)

}