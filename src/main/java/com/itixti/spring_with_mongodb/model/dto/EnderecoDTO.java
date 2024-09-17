package com.itixti.spring_with_mongodb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoDTO {

    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;
}
