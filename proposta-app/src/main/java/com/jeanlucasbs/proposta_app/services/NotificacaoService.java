package com.jeanlucasbs.proposta_app.services;

import com.jeanlucasbs.proposta_app.dto.PropostaResponseDTO;
import com.jeanlucasbs.proposta_app.entities.Proposta;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    private RabbitTemplate rabbitTemplate;

    public NotificacaoService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void notificar(Proposta proposta, String exchange){
        rabbitTemplate.convertAndSend(exchange, "", proposta);
    }
}
