package com.microservico.produtorestoque.controller;

import com.microservico.produtorestoque.service.EstoqueService;
import dto.EstoqueDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("estoque")
public class EstoqueController {

    private EstoqueService estoqueService;

    @PutMapping
    public ResponseEntity alteraEstoque(@RequestBody EstoqueDto request){
        this.estoqueService.enviarParaFila(request);
        return new ResponseEntity(HttpStatus.OK);
    }

}
