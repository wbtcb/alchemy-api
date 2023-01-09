package eu.einvent.alchemy.api

import com.google.gson.GsonBuilder
import com.wbtcb.alchemy.service.AlchemyService
import okhttp3.OkHttpClient
import org.slf4j.LoggerFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object AlchemyClientFactory {

    private val logger = LoggerFactory.getLogger(AlchemyClientFactory::class.java)

    fun provide(baseUrl: String, proxyHost: String?, proxyPort: Int?): AlchemyService {

        var proxy: Proxy? = null

        if (!proxyHost.isNullOrEmpty() && proxyPort != null) {
            logger.info("GoogleRecaptcha is using proxy for connection")
            proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress(proxyHost, proxyPort))
        }

        /* Disable recaptcha log
        val log = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        */

        val client = OkHttpClient().newBuilder()
                .proxy(proxy)
                .addNetworkInterceptor { chain ->
                    chain
                            .request()
                            .newBuilder()
                            .build()
                            .let(chain::proceed)
                }
                // .addInterceptor(log)
                .build()

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create(AlchemyService::class.java)
    }
}
