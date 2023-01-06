package eu.einvent.alchemy.api

import eu.einvent.alchemy.api.service.AlchemyService

class AlchemyClient(
    val apiKey: String,
    private val baseUrl: String? = null,
    private val proxyHost: String? = null,
    private val proxyPort: Int? = null
) : AlchemyService by AlchemyClientFactory.provide(baseUrl ?: BASE_URL, proxyHost, proxyPort) {

    companion object {
        const val BASE_URL = "https://eth-mainnet.alchemyapi.io/"
    }
}