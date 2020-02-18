package com.microservice.trade.utils;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StringUtilsTest {

    public static final String CNPJ = "34705270000110";
    public static final String FORMAT = "##.###.###/####-##";
    public static final String CNPJ_FORMATED = "34.705.270/0001-10";

    @Test
    public void removeSpecialCaracterValid(){
        String text = StringUtils.removeSpecialCaracter(CNPJ_FORMATED);
        Assertions.assertEquals(CNPJ,text);
    }

    @Test
    public void removeSpecialCaracterTextNull(){
        String text = StringUtils.removeSpecialCaracter(null);
        Assertions.assertNull(text);
    }

    @Test
    public void addMaskFormatterValid(){
        String text = StringUtils.addMaskFormatter(CNPJ, FORMAT);
        Assertions.assertEquals(CNPJ_FORMATED,text);
    }

    @Test
    public void addMaskFormatterTextNull(){
        String text = StringUtils.addMaskFormatter(null,FORMAT);
        Assertions.assertNull(text);
    }

    @Test
    public void addMaskFormatterFormatNull(){
        String textFormated = StringUtils.addMaskFormatter(CNPJ,null);
        Assertions.assertEquals(CNPJ,textFormated);
    }
}
