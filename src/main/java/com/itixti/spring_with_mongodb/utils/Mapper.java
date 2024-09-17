package com.itixti.spring_with_mongodb.utils;

import org.bson.types.ObjectId;

import com.itixti.spring_with_mongodb.model.Empresa;
import com.itixti.spring_with_mongodb.model.Endereco;
import com.itixti.spring_with_mongodb.model.Funcionario;
import com.itixti.spring_with_mongodb.model.dto.EmpresaDTO;
import com.itixti.spring_with_mongodb.model.dto.EnderecoDTO;
import com.itixti.spring_with_mongodb.model.dto.FuncionarioDTO;

public class Mapper {

    public final FuncionarioDTO toDTO(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(funcionario.getId().toString());
        dto.setNome(funcionario.getNome());
        dto.setCargo(funcionario.getCargo());
        dto.setSalario(funcionario.getSalario());
        dto.setDataAdmissao(funcionario.getDataAdmissao());
        dto.setEmpresaId(funcionario.getEmpresaId().toString());
        return dto;
    }

    public final Funcionario toEntity(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(new ObjectId(dto.getId()));
        funcionario.setNome(dto.getNome());
        funcionario.setCargo(dto.getCargo());
        funcionario.setSalario(dto.getSalario());
        funcionario.setDataAdmissao(dto.getDataAdmissao());
        funcionario.setEmpresaId(new ObjectId(dto.getEmpresaId()));
        return funcionario;
    }

    public final EmpresaDTO toDTO(Empresa empresa) {
        EmpresaDTO dto = new EmpresaDTO();
        dto.setId(empresa.getId().toString());
        dto.setNome(empresa.getNome());
        dto.setEndereco(toDTO(empresa.getEndereco()));
        dto.setCnpj(empresa.getCnpj());
        dto.setDataFundacao(empresa.getDataFundacao());
        return dto;
    }

    public final Empresa toEntity(EmpresaDTO dto) {
        Empresa empresa = new Empresa();
        empresa.setId(new ObjectId(dto.getId()));
        empresa.setNome(dto.getNome());
        empresa.setEndereco(toEntity(dto.getEndereco()));
        empresa.setCnpj(dto.getCnpj());
        empresa.setDataFundacao(dto.getDataFundacao());
        return empresa;
    }

    public final EnderecoDTO toDTO(Endereco endereco) {
        if (endereco == null) {
            return null;
        }
        EnderecoDTO dto = new EnderecoDTO();
        dto.setRua(endereco.getRua());
        dto.setNumero(endereco.getNumero());
        dto.setCidade(endereco.getCidade());
        dto.setEstado(endereco.getEstado());
        return dto;
    }

    public final Endereco toEntity(EnderecoDTO dto) {
        if (dto == null) {
            return null;
        }
        Endereco endereco = new Endereco();
        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero());
        endereco.setCidade(dto.getCidade());
        endereco.setEstado(dto.getEstado());
        return endereco;
    }
}
