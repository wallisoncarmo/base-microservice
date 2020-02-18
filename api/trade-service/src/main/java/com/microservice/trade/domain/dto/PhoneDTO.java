package com.microservice.trade.domain.dto;


import com.microservice.trade.domain.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull(message = "Campo de numero é obrigatório!")
    @Length(min = 14, max = 15,message = "Número de telefone inválido")
    private String numberPhone;

    @NotNull(message = "Campo de tipo é obrigatório!")
    private PhoneType type;

}
