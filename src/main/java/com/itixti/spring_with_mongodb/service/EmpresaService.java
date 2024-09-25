package com.itixti.spring_with_mongodb.service;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itixti.spring_with_mongodb.repository.EmpresaRepository;
import com.itixti.spring_with_mongodb.repository.FuncionarioRepository;
import com.itixti.spring_with_mongodb.utils.Mapper;
import com.mongodb.DuplicateKeyException;
import com.itixti.spring_with_mongodb.model.Empresa;
import com.itixti.spring_with_mongodb.model.Funcionario;
import com.itixti.spring_with_mongodb.model.dto.EmpresaDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private static Mapper mapper;

    public EmpresaDTO findById(ObjectId id) {
        var optionalEmpresa = empresaRepository.findById(id);

        return mapper.toDTO(optionalEmpresa.get());
    }

    public List<EmpresaDTO> findAll() {
        var empresas = empresaRepository.findAll();
        return empresas.stream()
                .map(empresa -> mapper.toDTO(empresa))
                .collect(Collectors.toList());
    }

    public EmpresaDTO salvar(EmpresaDTO dto) {
        var empresa = empresaRepository.save(mapper.toEntity(dto));
        return mapper.toDTO(empresa);
    }

    public EmpresaDTO update(ObjectId id, EmpresaDTO empresaDTO) {
        var empresaBanco = findById(id);

        if (empresaDTO != null) {
            BeanUtils.copyProperties(empresaDTO, empresaBanco);
            empresaRepository.save(mapper.toEntity(empresaDTO));
        }
        return empresaBanco;
    }

    public List<Funcionario> buscarFuncionariosPorEmpresa(ObjectId empresaId) {
        return funcionarioRepository.findByEmpresaId(empresaId);
    }

}
