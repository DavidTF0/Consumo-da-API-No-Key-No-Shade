package com.example.consumoapiqueens.network

import com.example.consumoapiqueens.model.Queens
import retrofit2.http.GET

interface EndPointApi {

    @GET("queens/all")
    suspend fun getResponseAllQueens() : Queens
}