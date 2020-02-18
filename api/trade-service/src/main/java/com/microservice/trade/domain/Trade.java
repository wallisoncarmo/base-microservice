package com.microservice.trade.domain;


import com.microservice.trade.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_TRADE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 20, max = 100)
    @Pattern(regexp = "^[áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑa-zA-Z0-9_ ]*")
    private String name;

    @NotNull
    @CNPJ
    private String cnpj;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones;

    @NotEmpty
    @OneToMany( cascade = CascadeType.ALL)
    private List<EMail> emails;

    @PrePersist
    @PreUpdate
    public void removeMask() {
        this.cnpj = StringUtils.removeSpecialCaracter(this.cnpj);
    }

    public String getCnpj() {
        return StringUtils.addMaskFormatter(this.cnpj,"##.###.###/####-##");
    }
}
