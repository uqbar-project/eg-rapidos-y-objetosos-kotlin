package ar.com.pdep.rapidosyobjetosos.bootstrap

import ar.com.pdep.rapidosyobjetosos.RapidosYObjetososApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(RapidosYObjetososApplication::class.java)
    }
}