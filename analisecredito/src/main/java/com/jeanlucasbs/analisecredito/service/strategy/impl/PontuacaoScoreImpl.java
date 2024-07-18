package com.jeanlucasbs.analisecredito.service.strategy.impl;

import com.jeanlucasbs.analisecredito.constantes.MensagensConstantes;
import com.jeanlucasbs.analisecredito.exception.StrategyException;
import com.jeanlucasbs.analisecredito.entities.Proposta;
import com.jeanlucasbs.analisecredito.service.strategy.CalcularPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class PontuacaoScoreImpl implements CalcularPonto {

    @Override
    public int calcular(Proposta proposta) {
        int score = score();

        if(score < 200) {
            throw new StrategyException(String.format(MensagensConstantes.PONTUACAO_SERASA_BAIXA, proposta.getUsuario().getNome()));
        }else if (score <= 400){
            return 150;
        } else if(score <= 600){
            return 180;
        }else {
            return 220;
        }
    }

    private int score(){
        return new Random().nextInt(0,1000);
    }
}
