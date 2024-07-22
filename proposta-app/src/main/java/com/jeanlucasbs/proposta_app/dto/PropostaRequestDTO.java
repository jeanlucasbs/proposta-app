package com.jeanlucasbs.proposta_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropostaRequestDTO {
    private String nome;
    private String sobrenome;
    private String telefone;
    private String CPF;
    private Double renda;
    private Double valorSolicitado;
    private int prazoPagamento;
}
