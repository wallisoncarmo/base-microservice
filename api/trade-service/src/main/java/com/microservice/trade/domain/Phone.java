package com.microservice.trade.domain;


import com.microservice.trade.domain.enums.PhoneType;
import com.microservice.trade.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "TB_PHONE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String numberPhone;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PhoneType type;


    @PrePersist
    @PreUpdate
    public void removeMask() {
        this.numberPhone = StringUtils.removeSpecialCaracter(this.numberPhone);
    }

    public String getNumberPhone() {
        return StringUtils.addMaskFormatter(this.numberPhone,"(##) #####-####");
    }

}
