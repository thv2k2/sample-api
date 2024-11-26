package org.sample.api.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.sample.api.common.SampleCommon;
import org.sample.api.dto.BinanceDto;
import org.sample.api.mapper.TradeMapper;
import org.sample.api.service.BinanceService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class BinanceServiceImpl implements BinanceService {
    private final OkHttpClient client;
    private final TradeMapper tradeMapper;

    @Override
    public List<BinanceDto.GetTradesResponse> getTrades(BinanceDto.GetTradesRequest tradeRequest) {
        List<BinanceDto.GetTradesResponse> tradesResponses = new ArrayList<>();
        String limit = tradeRequest.getLimit().toString();
        String fetchBinancePath = SampleCommon.BINANCE_HOST_BASE_URL + SampleCommon.BINANCE_API_TRADES;

        tradeRequest
                .getSymbolList()
                .forEach(
                        symbol -> {
                            HttpUrl.Builder urlBuilder =
                                    Objects.requireNonNull(HttpUrl.parse(fetchBinancePath))
                                            .newBuilder()
                                            .addQueryParameter("symbol", symbol)
                                            .addQueryParameter("limit", limit);

                            Request request =
                                    new Request.Builder()
                                            .url(urlBuilder.build())
                                            .addHeader("X-MBX-APIKEY", SampleCommon.BINANCE_API_KEY)
                                            .build();

                            try (Response response = client.newCall(request).execute()) {
                                List<BinanceDto.TradeDto> trades =
                                        (new ObjectMapper())
                                                .readValue(response.body().string(), new TypeReference<>() {
                                                });

                                List<BinanceDto.TradeResponseDto> tradeResponseDtoList =
                                        trades.stream().map(tradeMapper::fromTradeDtoToTradeResponseDto).toList();

                                tradesResponses.add(
                                        BinanceDto.GetTradesResponse.builder()
                                                .coinName(symbol)
                                                .trades(tradeResponseDtoList)
                                                .build());

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });

        return tradesResponses;
    }
}
