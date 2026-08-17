package com.joaovsq.banco.services.conta;

import com.joaovsq.banco.models.conta.Conta;
import com.joaovsq.banco.models.conta.ContaEspecial;
import com.joaovsq.banco.models.conta.ContaInvestimento;
import com.joaovsq.banco.models.pessoa.Pessoa;

public class ContaService {

    public Conta criarConta(Pessoa titular) {
        try{
            int agencia = 1239;
            int numero = (int) (Math.random() * 900000) + 1000; // Gera um número aleatório entre 1000 e 999999
            Conta conta = new Conta(titular, agencia, numero);

            return conta;
        } catch (Exception e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());

            return null;
        }
    }

    public ContaEspecial criarContaEspecial(Pessoa titular, double valorLimite) {
        try{
            int agencia = 1239;
            int numero = (int) (Math.random() * 900000) + 1000; // Gera um número aleatório entre 1000 e 999999
            ContaEspecial contaEspecial = new ContaEspecial(titular, agencia, numero, valorLimite);

            return contaEspecial;
        } catch (Exception e) {
            System.out.println("Erro ao criar conta especial: " + e.getMessage());

            return null;
        }
    }

    public ContaInvestimento criarContaInvestimento(Pessoa titular) {
        try{
            int agencia = 1239;
            int numero = (int) (Math.random() * 900000) + 1000; // Gera um número aleatório entre 1000 e 999999
            ContaInvestimento contaInvestimento = new ContaInvestimento(titular, agencia, numero);

            return contaInvestimento;
        } catch (Exception e) {
            System.out.println("Erro ao criar conta investimento: " + e.getMessage());

            return null;
        }
    }

    public void exibirDadosConta(Conta conta) {
        System.out.println("\n----------------------------------");
        System.out.println("\nDados da Conta");
        System.out.println("Número da Conta Especial: " + conta.getNumero());
        System.out.println("Agência: " + conta.getAgencia());
        System.out.println("Saldo: " + conta.getSaldo());
        if(conta.getSaldoDisponivel() != 0.0) {
            System.out.println("Saldo Disponível conta especial: " + conta.getSaldoDisponivel());
        }
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("----------------------------------\n");
    }

}
