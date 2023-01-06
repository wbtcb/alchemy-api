package eu.einvent.alchemy.api;

import com.google.gson.JsonArray;
import eu.einvent.alchemy.api.dto.AlchemyBlockDetailResultResponse;
import eu.einvent.alchemy.api.dto.AlchemyParamRequest;
import eu.einvent.alchemy.api.dto.AlchemyRequest;
import eu.einvent.alchemy.api.dto.AlchemyResponse;
import eu.einvent.alchemy.api.dto.AlchemyResultResponse;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlchemyClientTest {

    private static final String BASE_URL = "https://eth-mainnet.alchemyapi.io/";
    private static final String KEY = "hKGMydtxeEfD1PMI8M-yMhDxZJnFIpj1";

    AlchemyClient client = new AlchemyClient(KEY, BASE_URL,null, null);

    @Test
    void shouldDoSomethingWith() throws IOException {

        AlchemyRequest<List<AlchemyParamRequest>> request = new AlchemyRequest<>(
                "01",
                Arrays.asList(new AlchemyParamRequest(
                        "0xd88d2f",
                        "0xd88d2f",
                        "0x3950932828b0d9106f6664a754cae9d2c7b2e20c",
                        "0x5b1ce83170f340e75bcebf26be909f2d3ae87ff3",
                                Collections.singletonList("internal")
                    )),
                "2.0",
                "alchemy_getAssetTransfers"
                );

        final Response<AlchemyResponse<AlchemyResultResponse>> response = client.transfers(KEY, request).execute();

        assertTrue(response.isSuccessful());
        assertNotNull(response.body());
        assertNotNull(response.body().getResult());
        assertNotNull(response.body().getResult().getTransfers());
        assertTrue(response.body().getResult().getTransfers().size() > 0);
    }

    @Test
    void testGettingCurrentBlockchain() throws IOException {

        AlchemyRequest<List<String>> request = new AlchemyRequest<>(
                "0",
                 Collections.emptyList(),
                "2.0",
                "eth_blockNumber"
        );

        final Response<AlchemyResponse<String>> response = client.getCurrentBlockNumber(KEY, request).execute();

        assertTrue(response.isSuccessful());
        assertNotNull(response.body());
        assertNotNull(response.body().getResult());
        assertTrue(response.body().getResult().length() > 0);

        final String hexadecimalNumber = response.body().getResult();
        final Integer currentBlockchainNumber = Integer.parseInt(hexadecimalNumber.substring(2), 16);
    }

    @Test
    void testGettingBlockDetailByNumber() throws IOException {

        JsonArray params = new JsonArray();
        params.add("0xe2eebe");
        params.add(true);

        AlchemyRequest<JsonArray> request = new AlchemyRequest<>(
                "0",
                params,
                "2.0",
                "eth_getBlockByNumber"
        );

        final Response<AlchemyResponse<AlchemyBlockDetailResultResponse>> response = client.getBlockDetailByNumber(KEY, request).execute();

        assertTrue(response.isSuccessful());
        assertNotNull(response.body());
        assertNotNull(response.body().getResult());
    }
}