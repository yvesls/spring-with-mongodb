package com.itixti.spring_with_mongodb.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.itixti.spring_with_mongodb.model.Funcionario;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, ObjectId> {
    List<Funcionario> findByEmpresaId(ObjectId empresaId);
}