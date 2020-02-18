package com.microservice.trade.builder;

import com.microservice.trade.domain.Trade;
import com.microservice.trade.domain.EMail;
import com.microservice.trade.domain.Address;
import com.microservice.trade.domain.Phone;
import com.microservice.trade.domain.dto.TradeDTO;
import com.microservice.trade.domain.enums.PhoneType;
import com.microservice.trade.domain.enums.UF;
import com.microservice.trade.services.mapper.TradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TradeBuilder {

    @Autowired
    private TradeMapper tradeMapper;

    public TradeDTO getTradeDTO(){
        return tradeMapper.toDto(getTradeEntity());
    }

    public Trade getTradeEntity() {
        return new Trade(null, "Sindicato dos Empregados no Comércio do DF", "34705270000110", getAddress(), getPhones(), getEmails());
    }

    private Address getAddress() {
        return new Address(null, "72110-035", "Cna 3 - Lt 14 S 103", "Taguatinga", "Brasília", UF.DF, "");
    }

    private List<EMail> getEmails() {
        return Arrays.asList(
                new EMail(null, "sindicadto_comercio@gmail.com"),
                new EMail(null, "sindicadto_comercio_va@gmail.com")
        );
    }

    private List<Phone> getPhones() {
        return Arrays.asList(new Phone(null, "(61) 3561-1697", PhoneType.COMERCIAL));
    }

}
