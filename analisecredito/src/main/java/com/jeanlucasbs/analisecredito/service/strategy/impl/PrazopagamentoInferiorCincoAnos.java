package com.jeanlucasbs.analisecredito.service.strategy.impl;

import com.jeanlucasbs.analisecredito.entities.Proposta;
import com.jeanlucasbs.analisecredito.service.strategy.CalcularPonto;
import org.springframework.stereotype.Component;

@Component
public class PrazopagamentoInferiorCincoAnos implements CalcularPonto {
    @Override
    public int calcular(Proposta proposta) {
        return proposta.getPrazoPagamento() < 60 ? 80 : 0;
    }
}
