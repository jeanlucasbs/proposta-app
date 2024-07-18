package com.jeanlucasbs.analisecredito.service.strategy;

import com.jeanlucasbs.analisecredito.entities.Proposta;
import org.springframework.stereotype.Component;

public interface CalcularPonto {

    int calcular(Proposta proposta);
}
