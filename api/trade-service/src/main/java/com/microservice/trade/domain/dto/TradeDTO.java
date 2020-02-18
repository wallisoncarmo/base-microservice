package com.microservice.trade.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TradeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull(message = "Campo de nome é obrigatório!")
    @Size(min = 20, max = 100,message = "O nome deve ter de no minimo 20 e no máximo 100 caracter")
    @Pattern(regexp = "^[áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑa-zA-Z0-9_ ]*")
    private String name;

    @CNPJ(message = "CNPJ é inválido")
    @NotNull(message = "Campo de CPF é obrigatório!")
    private String cnpj;

    @NotNull(message = "Campo de CPF é obrigatório!")
    private AddressDTO address;

    @NotEmpty(message = "É necessário informar pelomenos um telefone")
    private List<PhoneDTO> phones;

    @NotEmpty(message = "É necessário informar pelomenos um email")
    private List<EmailDTO> emails;

}
