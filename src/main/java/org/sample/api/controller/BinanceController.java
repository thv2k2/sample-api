package org.sample.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sample.api.dto.BinanceDto;
import org.sample.api.service.BinanceService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/binance")
@RequiredArgsConstructor
@Validated
public class BinanceController {
    private final BinanceService binanceService;

    @PostMapping("/trades")
    public ResponseEntity<List<BinanceDto.GetTradesResponse>> getTrades(
            @RequestBody BinanceDto.GetTradesRequest request) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(binanceService.getTrades(request));
    }
}
