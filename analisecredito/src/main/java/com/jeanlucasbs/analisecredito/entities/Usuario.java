package com.jeanlucasbs.analisecredito.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private Long id;

    private String nome;

    private String sobrenome;

    private String CPF;

    private String telefone;

    private Double renda;
}

