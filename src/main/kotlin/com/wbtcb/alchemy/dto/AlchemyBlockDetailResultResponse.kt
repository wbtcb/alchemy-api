package com.wbtcb.alchemy.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class AlchemyBlockDetailResultResponse (

    @SerializedName("number")
    val number: String?,

    @SerializedName("hash")
    val hash: String?,

    @SerializedName("parentHash")
    val parentHash: String,

    @SerializedName("nonce")
    val nonce: String?,

    @SerializedName("sha3Uncles")
    val sha3Uncles: String,

    @SerializedName("logsBloom")
    val logsBloom: String?,

    @SerializedName("transactionsRoot")
    val transactionsRoot: String,

    @SerializedName("stateRoot")
    val stateRoot: String,

    @SerializedName("receiptsRoot")
    val receiptsRoot: String,

    @SerializedName("miner")
    val miner: String,

    @SerializedName("difficulty")
    val difficulty: String,

    @SerializedName("totalDifficulty")
    val totalDifficulty: String,

    @SerializedName("extraData")
    val extraData: String,

    @SerializedName("size")
    val size: String,

    @SerializedName("gasLimit")
    val gasLimit: String,

    @SerializedName("gasUsed")
    val gasUsed: String,

    @SerializedName("timestamp")
    val timestamp: String,

    @SerializedName("transactions")
    val transactions: List<AlchemyTransactionDetailResultResponse>,

    @SerializedName("uncles")
    val uncles: List<String>
)
