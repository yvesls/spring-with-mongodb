package com.itixti.spring_with_mongodb.controller;

import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.itixti.spring_with_mongodb.model.Funcionario;
import com.itixti.spring_with_mongodb.model.dto.EmpresaDTO;
import com.itixti.spring_with_mongodb.model.dto.UploadEmpresasDTO;
import com.itixti.spring_with_mongodb.service.EmpresaService;

import java.io.IOException;
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

    @PostMapping("/upload")
    public ResponseEntity<String> uploadEmpresas(@RequestParam("file") MultipartFile file) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            List<EmpresaDTO> empresas = objectMapper.readValue(file.getInputStream(),
                    new TypeReference<List<EmpresaDTO>>() {
                    });
            empresaService.salvarEmpresas(empresas);
            return ResponseEntity.ok("Empresas inseridas com sucesso!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao processar o arquivo: " + e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<EmpresaDTO>> buscarPorNomeECidade(@RequestParam String nome) {
        try {
            List<EmpresaDTO> empresas = empresaService.findByNome(nome);
            return ResponseEntity.ok(empresas);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
