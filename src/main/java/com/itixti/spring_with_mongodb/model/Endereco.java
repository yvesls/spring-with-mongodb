package com.itixti.spring_with_mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Endereco {

    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;
}
