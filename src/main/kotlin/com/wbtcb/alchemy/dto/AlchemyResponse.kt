package com.wbtcb.alchemy.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class AlchemyResponse<T> (

    @SerializedName("jsonrpc")
    val jsonrpc: String = "2.0",

    @SerializedName("id")
    val id: String,

    @SerializedName("result")
    val result: T?
)
