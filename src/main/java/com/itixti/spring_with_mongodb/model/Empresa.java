package com.itixti.spring_with_mongodb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
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

@Document(collection = "empresa")
@CompoundIndex(def = "{'nome': 1}")
public class Empresa {

    @Id
    private ObjectId id;

    @Indexed
    private String nome;

    private Endereco endereco;
    private String cnpj;
    private LocalDate dataFundacao;
}
