package com.microservico.produtorestoque.controller;

import com.microservico.produtorestoque.service.PrecoService;
import dto.PrecoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("precos")
public class PrecoController {

    private PrecoService precoService;

    @PutMapping
    public ResponseEntity alteraEstoque(@RequestBody PrecoDto request){
        this.precoService.enviarParaFila(request);
        return new ResponseEntity(HttpStatus.OK);
    }

}
