package com.microservice.trade.services.mapper;

import com.microservice.trade.domain.Trade;
import com.microservice.trade.domain.dto.TradeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TradeMapper extends EntityMapper<TradeDTO, Trade> {
}
