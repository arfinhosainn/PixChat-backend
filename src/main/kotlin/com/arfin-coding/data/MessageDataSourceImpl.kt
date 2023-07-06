package com.`arfin-coding`.data

import com.`arfin-coding`.data.model.Message
import com.`arfin-coding`.domain.MessageDataSource
import org.litote.kmongo.coroutine.CoroutineDatabase

class MessageDataSourceImpl(
        val db: CoroutineDatabase
) : MessageDataSource {

    private val messages = db.getCollection<Message>()
    override suspend fun getAllMessages(): List<Message> {
        return messages.find()
                .descendingSort(Message::timeStamp)
                .toList()
    }

    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message)
    }
}