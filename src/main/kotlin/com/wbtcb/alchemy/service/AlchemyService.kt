package com.wbtcb.alchemy.service

import com.google.gson.JsonArray
import com.wbtcb.alchemy.dto.AlchemyBlockDetailResultResponse
import com.wbtcb.alchemy.dto.AlchemyParamRequest
import com.wbtcb.alchemy.dto.AlchemyRequest
import com.wbtcb.alchemy.dto.AlchemyResponse
import com.wbtcb.alchemy.dto.AlchemyResultResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AlchemyService {

    @POST("/v2/{secret}")
    fun transfers(@Path("secret") secret: String, @Body request: AlchemyRequest<List<AlchemyParamRequest>>): Call<AlchemyResponse<AlchemyResultResponse>>

    @POST("/v2/{secret}")
    fun getCurrentBlockNumber(@Path("secret") secret: String, @Body request: AlchemyRequest<List<String>>): Call<AlchemyResponse<String>>

    @POST("/v2/{secret}")
    fun getBlockDetailByNumber(@Path("secret") secret: String, @Body request: AlchemyRequest<JsonArray>): Call<AlchemyResponse<AlchemyBlockDetailResultResponse>>

}
