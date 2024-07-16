package com.jeanlucasbs.notificacao.listener;

import com.jeanlucasbs.notificacao.constante.MensagemConstante;
import com.jeanlucasbs.notificacao.domain.Proposta;
import com.jeanlucasbs.notificacao.service.NotificacaoSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropostaPendenteListener {

    @Autowired
    NotificacaoSnsService notificacao;
    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    private void propostaPendente(Proposta proposta){
        String mensagem = String.format(MensagemConstante.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
        notificacao.notificar(proposta.getUsuario().getTelefone(), mensagem);

    }
}
