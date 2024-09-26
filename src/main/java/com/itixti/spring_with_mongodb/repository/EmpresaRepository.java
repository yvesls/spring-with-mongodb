package com.itixti.spring_with_mongodb.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.itixti.spring_with_mongodb.model.Empresa;

@Repository
public interface EmpresaRepository extends MongoRepository<Empresa, ObjectId> {
    @Query("{ 'nome': { $regex: ?0, $options: 'i' } }")
    List<Empresa> findByNome(String nome);
}