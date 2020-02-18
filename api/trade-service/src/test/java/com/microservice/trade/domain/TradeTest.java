package com.microservice.trade.domain;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class TradeTest {

    public static final String CNPJ_SEM_MASCARA = "34705270000110";
    public static final String CNPJ_COM_MASCARA = "34.705.270/0001-10";

    @Test
    public void getCnpjValid() {
        Trade obj = new Trade();
        obj.setCnpj(CNPJ_SEM_MASCARA);
        Assertions.assertEquals(CNPJ_COM_MASCARA,obj.getCnpj());
    }

}
