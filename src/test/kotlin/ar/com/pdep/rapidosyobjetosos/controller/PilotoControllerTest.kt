package ar.com.pdep.rapidosyobjetosos.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Dado un controller de pilotos")
class PilotoControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun `Se pueden obtener todos los pilotos`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/pilotos"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].nombre").value("José Froilán Gonzalez"))
    }

    @Test
    fun `Se puede calcular el tiempo para un piloto`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/piloto/1/tiempo/2"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.content().json("45"))
    }

    @Test
    fun `No se puede calcular el tiempo para un piloto si el mismo no exite`() {
        val errorMessage = mockMvc.perform(MockMvcRequestBuilders.get("/piloto/100/tiempo/2"))
            .andExpect(MockMvcResultMatchers.status().isNotFound)
            .andReturn().resolvedException?.message

        assertEquals(errorMessage, "No existe el Piloto con el identificador 100")
    }

    @Test
    fun `No se puede calcular el tiempo para un piloto si la pista no exite`() {
        val errorMessage = mockMvc.perform(MockMvcRequestBuilders.get("/piloto/1/tiempo/200"))
            .andExpect(MockMvcResultMatchers.status().isNotFound)
            .andReturn().resolvedException?.message

        assertEquals(errorMessage, "No existe la Pista con el identificador 200")
    }
}