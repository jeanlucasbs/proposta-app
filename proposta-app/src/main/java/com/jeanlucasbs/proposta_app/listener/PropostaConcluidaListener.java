package com.jeanlucasbs.proposta_app.listener;

import com.jeanlucasbs.proposta_app.dto.PropostaResponseDTO;
import com.jeanlucasbs.proposta_app.entities.Proposta;
import com.jeanlucasbs.proposta_app.mapper.PropostaMapper;
import com.jeanlucasbs.proposta_app.repositories.PropostaRepository;
import com.jeanlucasbs.proposta_app.services.WebSocketService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PropostaConcluidaListener {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private WebSocketService webSocketService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaConcluida(Proposta proposta){
        atualizarProposta(proposta);
        webSocketService.notificar(PropostaMapper.INSTANCE.convertEntityToDto(proposta));
    }

    private void atualizarProposta(Proposta proposta) {
        propostaRepository.atualizarProposta(proposta.getId(), proposta.getAprovado(), proposta.getObservacao());
    }
}
