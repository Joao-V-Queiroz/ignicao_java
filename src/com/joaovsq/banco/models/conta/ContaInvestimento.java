package com.joaovsq.banco.models.conta;

import com.joaovsq.banco.models.pessoa.Pessoa;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(Pessoa titular, int agencia, int numero) {
        super(titular, agencia, numero);
    }

    @Override
    public void debitarTarifaMensal() {
        if (getSaldoDisponivel() < 10_000 && getSaldoDisponivel() > 30) {
            sacar(30);
        }
    }

    public void creditarRendimentos(double percentualJuros) {
        double valorRendimentos = getSaldo() * percentualJuros / 100;
        depositar(valorRendimentos);
    }

}
