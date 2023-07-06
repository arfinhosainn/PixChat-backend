package com.`arfin-coding`

import com.`arfin-coding`.di.mainModule
import com.`arfin-coding`.plugins.configureMonitoring
import com.`arfin-coding`.plugins.configureRouting
import com.`arfin-coding`.plugins.configureSecurity
import com.`arfin-coding`.plugins.configureSerialization
import com.`arfin-coding`.plugins.configureSockets
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ktor.plugin.Koin

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
            .start(wait = true)
}

fun Application.module() {
    install(Koin) {
        modules(mainModule)
    }
    configureSockets()
    configureRouting()
    configureSerialization()
    configureMonitoring()
    configureSecurity()

}
