package com.joaovsq.banco.models.conta;

import com.joaovsq.banco.models.pessoa.Pessoa;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(Pessoa titular, int agencia, int numero) {
        super(titular, agencia, numero); // Chama o construtor da classe pai (Conta) para inicializar os atributos herdados
    }

    public void creditarRendimentos(double percentualJuros) {
        double valorRendimentos = getSaldo() * percentualJuros / 100;
        depositar(valorRendimentos);
    }

}
