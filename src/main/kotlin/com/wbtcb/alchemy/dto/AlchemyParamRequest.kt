package com.wbtcb.alchemy.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class AlchemyParamRequest (

    @SerializedName("fromBlock")
    val fromBlock: String?,

    @SerializedName("toBlock")
    val toBlock: String?,

    @SerializedName("fromAddress")
    val fromAddress: String?,

    @SerializedName("toAddress")
    val toAddress: String,

    @SerializedName("category")
    val category: List<String>
)
