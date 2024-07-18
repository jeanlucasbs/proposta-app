package com.jeanlucasbs.analisecredito.service;

import com.jeanlucasbs.analisecredito.entities.Proposta;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoRabbitMQService {

    private RabbitTemplate rabbitTemplate;

    public NotificacaoRabbitMQService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void notificar(String exchange, Proposta proposta){
        rabbitTemplate.convertAndSend(exchange, "", proposta);
    }
}
