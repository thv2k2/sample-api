package org.sample.api.service;

import org.sample.api.dto.BinanceDto;

import java.util.List;

public interface BinanceService {
    List<BinanceDto.GetTradesResponse> getTrades(BinanceDto.GetTradesRequest request);
}
