package com.joaovsq.banco.models.pessoa;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private double salario;

    public PessoaFisica() {
        super();
    }

    @Override
    public void declararImposto() {
        if(this.getSalario() <= 5000){
            System.out.println("Não é necessário a declaração de imposto de renda!");
        } else{
            System.out.println("É necessário fazer a declaração de imposto de renda!");
        }
    }

    public PessoaFisica(String nome, String email, String telefone, String cpf) {
        super(nome, email, telefone);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {return salario;}

    public void setSalario(double salario) {this.salario = salario;}

}
