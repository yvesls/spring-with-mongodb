package com.itixti.spring_with_mongodb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmpresaDTO {

    private String id;
    private String nome;
    private EnderecoDTO endereco;
    private String cnpj;
    private LocalDate dataFundacao;
}
