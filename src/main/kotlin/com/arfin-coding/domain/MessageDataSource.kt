package com.`arfin-coding`.domain

import com.`arfin-coding`.data.model.Message

interface MessageDataSource  {

    suspend fun getAllMessages(): List<Message>

    suspend fun insertMessage(message: Message)
}