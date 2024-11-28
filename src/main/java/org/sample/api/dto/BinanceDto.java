package org.sample.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class BinanceDto {

  @Builder
  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class TradeDto {
    private Long id;
    private String price;
    private String qty;
    private String quoteQty;
    private Long time;
    private Boolean isBuyerMaker;
    private Boolean isBestMatch;
  }

  @Builder
  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class TradeResponseDto {
    private Long id;
    private String price;
    private LocalDateTime time;
  }

  @Builder
  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class GetTradesResponse {
    private String coinName;
    private List<TradeResponseDto> trades;
    private String trend;
  }

  @Getter
  @Setter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class GetTradesRequest {
    private List<String> symbolList;
    private String symbol;
    private Integer limit;
    private TradeDataStatus status;
  }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public enum TradeDataStatus {
        INTERVAL_1MINUTE("INTERVAL_1MINUTE", 1),
        INTERVAL_1HOUR("INTERVAL_1HOUR", 60),
        INTERVAL_2HOUR("INTERVAL_2HOUR", 120),
        INTERVAL_4HOUR("INTERVAL_4HOUR", 240),
        INTERVAL_6HOUR("INTERVAL_6HOUR", 360),
        INTERVAL_8HOUR("INTERVAL_8HOUR", 480),
        INTERVAL_12HOUR("INTERVAL_12HOUR", 720);

    private String key;
    private Integer value;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  public enum TrendType {
    UP("UP"),
    DOWN("DOWN");

    private String value;

    public static TrendType getTrendByCoinPrice(Double previousPrice, Double currentPrice) {
      return previousPrice < currentPrice ? TrendType.UP : TrendType.DOWN;
    }
  }
}
