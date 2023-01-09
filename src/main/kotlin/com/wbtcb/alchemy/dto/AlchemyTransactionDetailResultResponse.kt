package com.wbtcb.alchemy.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class AlchemyTransactionDetailResultResponse (

    @SerializedName("hash")
    val hash: String?,

    @SerializedName("blockHash")
    val blockHash: String?,

    @SerializedName("blockNumber")
    val blockNumber: String?,

    @SerializedName("from")
    val from: String?,

    @SerializedName("gas")
    val gas: String?,

    @SerializedName("gasPrice")
    val gasPrice: String?,

    @SerializedName("input")
    val input: String?,

    @SerializedName("nonce")
    val nonce: String?,

    @SerializedName("r")
    val r: String?,

    @SerializedName("s")
    val s: String?,

    @SerializedName("to")
    val to: String?,

    @SerializedName("transactionIndex")
    val transactionIndex: String?,

    @SerializedName("v")
    val v: String?,

    @SerializedName("value")
    val value: String?
)
