package com.jeanlucasbs.analisecredito.service.strategy.impl;

import com.jeanlucasbs.analisecredito.constantes.MensagensConstantes;
import com.jeanlucasbs.analisecredito.exception.StrategyException;
import com.jeanlucasbs.analisecredito.entities.Proposta;
import com.jeanlucasbs.analisecredito.service.strategy.CalcularPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class NomeNegativoImpl implements CalcularPonto {

    @Override
    public int calcular(Proposta proposta) {
        if(nomeNegativado()){
            throw new StrategyException(String.format(MensagensConstantes.CLIENTE_NEGATIVADO, proposta.getUsuario().getNome()));
        }
        return 100;
    }

    private boolean nomeNegativado(){
        return new Random().nextBoolean();
    }
}
