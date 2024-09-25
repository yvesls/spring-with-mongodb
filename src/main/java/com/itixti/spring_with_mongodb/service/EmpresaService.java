package com.itixti.spring_with_mongodb.service;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.itixti.spring_with_mongodb.repository.EmpresaRepository;
import com.itixti.spring_with_mongodb.repository.FuncionarioRepository;
import com.itixti.spring_with_mongodb.utils.Mapper;
import com.itixti.spring_with_mongodb.model.Funcionario;
import com.itixti.spring_with_mongodb.model.dto.EmpresaDTO;

import java.util.List;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    private FuncionarioRepository funcionarioRepository;

    private static Mapper mapper;

    public EmpresaDTO salvar(EmpresaDTO dto) {
        var empresa = empresaRepository.save(mapper.toEntity(dto));
        return mapper.toDTO(empresa);
    }

    public List<Funcionario> buscarFuncionariosPorEmpresa(ObjectId empresaId) {
        return funcionarioRepository.findByEmpresaId(empresaId);
    }

}
