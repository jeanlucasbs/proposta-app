package com.jeanlucasbs.analisecredito.service;

import com.jeanlucasbs.analisecredito.entities.Proposta;
import com.jeanlucasbs.analisecredito.exception.StrategyException;
import com.jeanlucasbs.analisecredito.service.strategy.CalcularPonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {

    private List<CalcularPonto> calcularPontoList;

    public AnaliseCreditoService(List<CalcularPonto> calcularPontoList) {
        this.calcularPontoList = calcularPontoList;
    }

    @Autowired
    NotificacaoRabbitMQService notificacaoRabbitMQService;

    @Value("${rabbitmq.propostaconcluida.exchange}")
    private String exchangePropostaConcluida;

    public void analisar(Proposta proposta){
        try{
            int pontos = calcularPontoList.stream().mapToInt(impl -> impl.calcular(proposta)).sum();
            proposta.setAprovado(pontos > 350);
        } catch (StrategyException ex){
            proposta.setAprovado(false);
            proposta.setObservacao(ex.getMessage());
        }
        notificacaoRabbitMQService.notificar(exchangePropostaConcluida, proposta);
    }
}
