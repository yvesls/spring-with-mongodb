package com.itixti.spring_with_mongodb.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itixti.spring_with_mongodb.model.Funcionario;
import com.itixti.spring_with_mongodb.model.dto.EmpresaDTO;
import com.itixti.spring_with_mongodb.service.EmpresaService;

import java.util.List;

@RestController
@RequestMapping(value = "empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<EmpresaDTO> salvar(@RequestBody EmpresaDTO dto) {
        try {
            EmpresaDTO empresaSalva = empresaService.salvar(dto);
            return new ResponseEntity<>(empresaSalva, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> buscarPorId(@PathVariable String id) {
        try {
            EmpresaDTO empresa = empresaService.findById(new ObjectId(id));
            return ResponseEntity.ok(empresa);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> listarTodas() {
        List<EmpresaDTO> empresas = empresaService.findAll();
        return ResponseEntity.ok(empresas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> atualizar(@PathVariable String id, @RequestBody EmpresaDTO dto) {
        try {
            EmpresaDTO empresaAtualizada = empresaService.update(new ObjectId(id), dto);
            return ResponseEntity.ok(empresaAtualizada);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/funcionarios")
    public ResponseEntity<List<Funcionario>> buscarFuncionariosPorEmpresa(@PathVariable String id) {
        try {
            List<Funcionario> funcionarios = empresaService.buscarFuncionariosPorEmpresa(new ObjectId(id));
            return ResponseEntity.ok(funcionarios);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
