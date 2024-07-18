package com.jeanlucasbs.proposta_app.listener;

import com.jeanlucasbs.proposta_app.entities.Proposta;
import com.jeanlucasbs.proposta_app.repositories.PropostaRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropostaConcluida {

    @Autowired
    private PropostaRepository propostaRepository;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaConcluida(Proposta proposta){
        propostaRepository.save(proposta);
    }
}
