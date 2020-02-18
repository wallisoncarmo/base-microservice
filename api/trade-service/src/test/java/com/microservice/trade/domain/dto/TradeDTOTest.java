package com.microservice.trade.domain.dto;


import com.microservice.trade.domain.enums.PhoneType;
import com.microservice.trade.domain.enums.UF;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class TradeDTOTest {

    @Test
    public void preencheContrutor() {
        TradeDTO objDTO =  new TradeDTO(null, "Sindicato dos Empregados no Comércio do DF", "34705270000110", getEndereco(), getUmTelefones(), getEmails());
        Assertions.assertNotNull(objDTO);
    }

    private AddressDTO getEndereco() {
        return new AddressDTO(null, "72110-035", "Cna 3 - Lt 14 S 103", "Taguatinga", "Brasília", UF.DF, "");
    }

    private List<EmailDTO> getEmails() {
        return Arrays.asList(
                new EmailDTO(null, "sindicadto_comercio@gmail.com"),
                new EmailDTO(null, "sindicadto_comercio_va@gmail.com")
        );
    }

    private List<PhoneDTO> getUmTelefones() {
        return Arrays.asList(new PhoneDTO(null, "(61) 3561-1697", PhoneType.COMERCIAL));
    }

}
