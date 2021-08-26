package com.microservico.produtorestoque.service;

import constantes.RabbitMQConstantes;
import dto.EstoqueDto;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstoqueService {

    private RabbitTemplate rabbitTemplate;

    public void enviarParaFila(EstoqueDto estoqueDto){
        this.rabbitTemplate.convertAndSend(RabbitMQConstantes.FILA_ESTOQUE, estoqueDto);
    }

}
