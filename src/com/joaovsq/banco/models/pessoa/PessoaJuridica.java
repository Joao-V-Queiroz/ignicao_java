package com.joaovsq.banco.models.pessoa;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String razaoSocial;
    private double faturamento;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String nome, String email, String telefone, String cnpj, String razaoSocial, double faturamento) {
        super(nome, email, telefone);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.faturamento = faturamento;
    }

    @Override
    public void declararImposto() {
        if(this.getFaturamento() <= 81000_00){
            System.out.println("O faturamento da empresa é de até R$ 81.000,00, portanto não é necessário declarar imposto de renda!");
        } else{
            System.out.println("O faturamento da empresa é superior a R$ 81.000,00, portanto é necessário mudar de categoria!");
        }
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public double getFaturamento() {return faturamento;}

    public void setFaturamento(double faturamento) {this.faturamento = faturamento;}
}
