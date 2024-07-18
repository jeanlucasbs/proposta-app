package com.jeanlucasbs.analisecredito.service.strategy.impl;

import com.jeanlucasbs.analisecredito.entities.Proposta;
import com.jeanlucasbs.analisecredito.service.strategy.CalcularPonto;
import org.springframework.stereotype.Component;

@Component
public class RendaMaiorValorSolicitado implements CalcularPonto {
    @Override
    public int calcular(Proposta proposta) {
        return rendaMaiorValorSolicitado(proposta) ? 100 : 0;
    }

    public boolean rendaMaiorValorSolicitado(Proposta proposta){
        return proposta.getUsuario().getRenda() > proposta.getValorSolicitado();
    }
}
