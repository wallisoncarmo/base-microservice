package com.microservice.trade.services.impl;

import com.microservice.trade.domain.Trade;
import com.microservice.trade.domain.dto.TradeDTO;
import com.microservice.trade.repositoties.TradeRepository;
import com.microservice.trade.services.TradeService;
import com.microservice.trade.services.exceptions.ObjectNotFoundException;
import com.microservice.trade.services.mapper.TradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeRepository repository;

    @Autowired
    private TradeMapper tradeMapper;

    @Override
    public Long insert(TradeDTO objDTO) {
        objDTO.setId(null);
        Trade obj = save(objDTO);
        return obj.getId();
    }

    @Override
    public TradeDTO update(TradeDTO objDTO, Long id) {
        objDTO.setId(id);
        this.save(objDTO);
        return objDTO;
    }

    private Trade save(TradeDTO objDTO) {
        Trade obj = tradeMapper.toEntity(objDTO);
        repository.save(obj);
        return obj;
    }

    @Override
    public List<TradeDTO> findAll() {
        List<Trade> listObj = this.repository.findAll();
        return tradeMapper.toDto(listObj);
    }

    @Override
    public TradeDTO findById(Long id) {
        Trade obj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Registro não encontrado"));
        return tradeMapper.toDto(obj);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
