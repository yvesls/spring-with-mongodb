package com.itixti.spring_with_mongodb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itixti.spring_with_mongodb.model.dto.EmpresaDTO;
import com.itixti.spring_with_mongodb.service.EmpresaService;

@RestController
@RequestMapping(value = "empresa")
public class EmpresaController {

    private EmpresaService empresaService;

    @PostMapping
    ResponseEntity<EmpresaDTO> salvar(@RequestBody EmpresaDTO dto) throws Exception {
        try {
            this.empresaService.salvar(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception("Erro ao salvar empresa");
        }
    }
}