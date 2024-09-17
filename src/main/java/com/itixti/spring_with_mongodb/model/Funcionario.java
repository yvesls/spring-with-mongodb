package com.itixti.spring_with_mongodb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "funcionario")
public class Funcionario {

    @Id
    private ObjectId id;
    private String nome;
    private String cargo;
    private Double salario;
    private LocalDate dataAdmissao;
    private ObjectId empresaId;
}
