package com.microservico.produtorestoque.config;

import constantes.RabbitMQConstantes;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class RabbitMQConfig {

    private AmqpAdmin amqpAdmin;
    private static final String NOME_EXCHANGE = "amq.direct";

    private Queue getQueue(String nomefila){
        boolean durable = true;
        boolean exclusive = false;
        boolean autoDelete = false;
        return new Queue(nomefila, durable, exclusive, autoDelete);
    }

    private DirectExchange getDirectExchange(){
        return new DirectExchange(NOME_EXCHANGE);
    }

    private Binding getBinding(Queue fila, DirectExchange troca){
        return new Binding(fila.getName(), Binding.DestinationType.QUEUE,
                troca.getName(), fila.getName(), null);
    }

    @PostConstruct
    private void adiciona(){
        Queue filaEstoque = this.getQueue(RabbitMQConstantes.FILA_ESTOQUE);
        Queue filaPreco = this.getQueue(RabbitMQConstantes.FILA_PRECO);

        DirectExchange troca = this.getDirectExchange();

        Binding ligacaoEstoque = this.getBinding(filaEstoque, troca);
        Binding ligacaoPreco = this.getBinding(filaPreco, troca);

        //Criando filas no RabbitMQ
        this.amqpAdmin.declareQueue(filaEstoque);
        this.amqpAdmin.declareQueue(filaPreco);

        this.amqpAdmin.declareExchange(troca);

        this.amqpAdmin.declareBinding(ligacaoEstoque);
        this.amqpAdmin.declareBinding(ligacaoPreco);
    }
}
