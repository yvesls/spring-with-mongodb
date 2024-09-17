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
public class FuncionarioDTO {

    private String id;
    private String nome;
    private String cargo;
    private Double salario;
    private LocalDate dataAdmissao;
    private String empresaId;
}
