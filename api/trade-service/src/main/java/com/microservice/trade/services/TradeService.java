package com.microservice.trade.services;

import com.microservice.trade.domain.dto.TradeDTO;

import java.util.List;

public interface TradeService {

    public Long insert(TradeDTO obj);

    public TradeDTO update(TradeDTO obj, Long id);

    public List<TradeDTO> findAll();

    public TradeDTO findById(Long id);

    public void delete(Long id);
}
