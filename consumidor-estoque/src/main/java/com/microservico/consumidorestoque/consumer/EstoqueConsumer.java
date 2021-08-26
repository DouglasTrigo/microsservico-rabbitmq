package com.microservico.consumidorestoque.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import constantes.RabbitMQConstantes;
import dto.EstoqueDto;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EstoqueConsumer {

    private ObjectMapper objectMapper;

    @RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
    private void consumidor(EstoqueDto estoqueDto){
        System.out.println("Código do produto: " + estoqueDto.codigoProduto);
        System.out.println("Quantidade: " + estoqueDto.quantidade);
    }
}
