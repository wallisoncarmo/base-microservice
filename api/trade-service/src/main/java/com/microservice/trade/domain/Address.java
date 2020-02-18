package com.microservice.trade.domain;


import com.microservice.trade.domain.enums.UF;
import com.microservice.trade.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "TB_ADDRESS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 8)
    @NotNull
    private String cep;

    @NotNull
    @Size(max = 100)
    private String publicPlace;

    @NotNull
    @Size(max = 100)
    private String neighborhood;

    @NotNull
    @Size(max = 100)
    private String city;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UF uf;

    @Size(max = 254)
    private String complement;

    @PrePersist
    @PreUpdate
    public void removeMask() {
        this.cep = StringUtils.removeSpecialCaracter(this.cep);
    }

    public String getCep() {
        return StringUtils.addMaskFormatter(this.cep,"#####-###");
    }

}
