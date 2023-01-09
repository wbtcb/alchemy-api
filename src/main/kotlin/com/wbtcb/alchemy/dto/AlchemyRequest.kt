package com.wbtcb.alchemy.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class AlchemyRequest<T> (

    @SerializedName("id")
    val id: String,

    @SerializedName("params")
    val params: T,

    @SerializedName("jsonrpc")
    val jsonrpc: String = "2.0",

    @SerializedName("method")
    val method: String = "alchemy_getAssetTransfers",
)