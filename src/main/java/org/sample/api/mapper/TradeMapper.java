package org.sample.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.sample.api.dto.BinanceDto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Mapper(componentModel = "spring")
public interface TradeMapper {

  @Mapping(target = "time", source = "time", qualifiedByName = "mapTime")
  BinanceDto.TradeResponseDto fromTradeDtoToTradeResponseDto(BinanceDto.TradeDto trade);

  @Named("mapTime")
  default LocalDateTime mapTime(long time) {
    return Instant.ofEpochMilli(time).atZone(ZoneId.systemDefault()).toLocalDateTime();
  }
}
