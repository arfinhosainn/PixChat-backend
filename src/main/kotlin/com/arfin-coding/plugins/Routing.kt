package com.`arfin-coding`.plugins


import com.`arfin-coding`.room.RoomController
import com.`arfin-coding`.routes.chatSocket
import com.`arfin-coding`.routes.getAllMessages
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing) {
        chatSocket(roomController)
        getAllMessages(roomController)
    }
}
