package com.joaovsq.banco.services.conta;

import com.joaovsq.banco.models.conta.Conta;
import com.joaovsq.banco.models.conta.ContaEspecial;
import com.joaovsq.banco.models.conta.ContaInvestimento;
import com.joaovsq.banco.models.pessoa.Pessoa;

public class ContaService {

    public ContaEspecial criarContaEspecial(Pessoa titular,int agencia, double valorLimite) {
        int numero = this.gerarNumeroConta();

        return new ContaEspecial(titular, agencia, numero, valorLimite);
    }

    public ContaInvestimento criarContaInvestimento(Pessoa titular, int agencia) {
        int numero = this.gerarNumeroConta();

        return new ContaInvestimento(titular, agencia, numero);
    }

    private int gerarNumeroConta() {
        return (int) (Math.random() * 900000) + 1000;
    }

    public void exibirDadosConta(Conta conta) {
        System.out.println("\n----------------------------------");
        System.out.println("\nDados da Conta");
        System.out.println("Número da Conta Especial: " + conta.getNumero());
        System.out.println("Agência: " + conta.getAgencia());
        System.out.println("Saldo Disponível: " + conta.getSaldoDisponivel());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("----------------------------------\n");
    }

    public void depositar(Conta conta, double valorDeposito) {
       try{
           conta.depositar(valorDeposito);
           System.out.println("Valor de R$" +  valorDeposito + " depositado com sucesso!");

           System.out.println("\nSaldo disponível na conta R$" + conta.getSaldoDisponivel());
       } catch (Exception e) {
           System.out.println("Erro ao depositar: " + e.getMessage());
       }
    }

    public void sacar(Conta conta, double valorSaque) {
        try {
            conta.sacar(valorSaque);
            System.out.println("Saque realizado com sucesso!");

            System.out.println("\nSaldo disponível na conta R$" + conta.getSaldoDisponivel());
        } catch (Exception e) {
            System.out.println("Erro ao sacar: " + e.getMessage());
        }
    }

    public void debitarTarifaMensal(Conta conta) {
        try {
            conta.debitarTarifaMensal();

            System.out.println("Débito da tarifa mensal realizado com sucesso!");
            System.out.println(
                    "Saldo disponível na conta R$" + conta.getSaldoDisponivel());
        } catch (Exception e) {
            System.out.println("Erro ao debitar tarifa mensal: " + e.getMessage());
        }
    }

    public void creditarRendimentos(ContaInvestimento contaInvestimento, double valorInvestimento) {
        try {
            contaInvestimento.creditarRendimentos(valorInvestimento);
            System.out.println("Investimento realizado com sucesso!");

            System.out.println("\nSaldo disponível na conta R$" + contaInvestimento.getSaldoDisponivel());

        } catch (Exception e) {
            System.out.println("Erro ao creditar rendimentos da conta: " + e.getMessage());
        }
    }

}
