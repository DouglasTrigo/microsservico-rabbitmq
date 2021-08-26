package com.microservico.produtorestoque.service;

import constantes.RabbitMQConstantes;
import dto.PrecoDto;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrecoService {

    private RabbitTemplate rabbitTemplate;

    public void enviarParaFila(PrecoDto precoDto){
        this.rabbitTemplate.convertAndSend(RabbitMQConstantes.FILA_PRECO, precoDto);
    }

}
