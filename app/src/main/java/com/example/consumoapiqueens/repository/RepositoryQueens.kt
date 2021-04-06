package com.example.consumoapiqueens.repository

import com.example.consumoapiqueens.model.Queens
import com.example.consumoapiqueens.network.EndPointApi
import com.example.consumoapiqueens.network.RetrofitInit

class RepositoryQueens {

    private var url = "https://www.nokeynoshade.party/api/"
    private var service = EndPointApi::class

    private val serviceQueen = RetrofitInit(url).create(service)

    suspend fun getAllQueensService() : Queens = serviceQueen.getResponseAllQueens()
}