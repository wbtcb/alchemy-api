package com.wbtcb.alchemy.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class AlchemyTransferResponse (

    @SerializedName("blockNum")
    val blockNum: String,

    @SerializedName("hash")
    val hash: String,

    @SerializedName("from")
    val from: String,

    @SerializedName("to")
    val to: String?,

    @SerializedName("value")
    val value: BigDecimal?,

    @SerializedName("asset")
    val asset: String?,

    @SerializedName("category")
    val category: String,

    @SerializedName("tokenId")
    val tokenId: String?,

    @SerializedName("erc721TokenId")
    val erc721TokenId: String?

)
