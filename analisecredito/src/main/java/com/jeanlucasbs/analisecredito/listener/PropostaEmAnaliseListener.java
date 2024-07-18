package com.jeanlucasbs.analisecredito.listener;

import com.jeanlucasbs.analisecredito.entities.Proposta;
import com.jeanlucasbs.analisecredito.service.AnaliseCreditoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaEmAnaliseListener {

    private final AnaliseCreditoService analiseCreditoService;

    public PropostaEmAnaliseListener(AnaliseCreditoService analiseCreditoService) {
        this.analiseCreditoService = analiseCreditoService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    private void propostaEmAnalise(Proposta proposta){
        analiseCreditoService.analisar(proposta);

    }
}
