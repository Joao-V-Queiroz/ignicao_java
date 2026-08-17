package com.joaovsq.banco.models.conta;

import com.joaovsq.banco.models.pessoa.Pessoa;

import java.util.Objects;

public class Conta {
    private Pessoa titular;
    private int agencia;
    private int numero;
    private double saldo;

    public Conta(){

    }

    public Conta(Pessoa titular, int agencia, int numero) {
        Objects.requireNonNull(titular, "titular não pode ser nula");
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor){
        if(valor <= 0){
            throw new IllegalArgumentException("Valor de depósito deve ser maior que zero.");
        }
        saldo += valor;
    }

    public void sacar(double valor){
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser maior que zero.");
        } else if(getSaldoDisponivel() - valor < 0){
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
        }
        saldo -= valor;
    }

    public void sacar(double valor, double taxaSaque){
        sacar(valor + taxaSaque);
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoDisponivel() {
        return getSaldo();
    }

}
