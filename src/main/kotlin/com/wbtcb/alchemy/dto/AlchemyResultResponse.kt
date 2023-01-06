package eu.einvent.alchemy.api.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class AlchemyResultResponse (

    @SerializedName("transfers")
    val transfers: List<AlchemyTransferResponse?>?

)
