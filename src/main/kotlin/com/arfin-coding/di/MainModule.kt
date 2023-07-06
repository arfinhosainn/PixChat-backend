package com.`arfin-coding`.di

import com.`arfin-coding`.data.MessageDataSourceImpl
import com.`arfin-coding`.domain.MessageDataSource
import com.`arfin-coding`.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient().coroutine.getDatabase("message_db")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}