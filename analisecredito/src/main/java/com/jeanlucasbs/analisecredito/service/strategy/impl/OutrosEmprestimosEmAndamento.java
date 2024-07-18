package com.jeanlucasbs.analisecredito.service.strategy.impl;

import com.jeanlucasbs.analisecredito.entities.Proposta;
import com.jeanlucasbs.analisecredito.service.strategy.CalcularPonto;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OutrosEmprestimosEmAndamento implements CalcularPonto {
    @Override
    public int calcular(Proposta proposta) {
        return outrosEmprestimentosEmAndamento() ? 0 : 80;
    }

    private boolean outrosEmprestimentosEmAndamento(){
        return new Random().nextBoolean();
    }
}
