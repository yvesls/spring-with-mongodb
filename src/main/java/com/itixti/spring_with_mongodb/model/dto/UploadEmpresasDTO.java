package com.itixti.spring_with_mongodb.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UploadEmpresasDTO {
    private List<EmpresaDTO> empresas;
}