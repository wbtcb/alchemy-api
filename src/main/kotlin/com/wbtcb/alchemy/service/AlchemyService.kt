package eu.einvent.alchemy.api.service

import com.google.gson.JsonArray
import eu.einvent.alchemy.api.dto.AlchemyBlockDetailResultResponse
import eu.einvent.alchemy.api.dto.AlchemyParamRequest
import eu.einvent.alchemy.api.dto.AlchemyRequest
import eu.einvent.alchemy.api.dto.AlchemyResponse
import eu.einvent.alchemy.api.dto.AlchemyResultResponse
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
