package com.joaovsq.banco.models.pessoa;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String nome, String email, String telefone, String cnpj, String razaoSocial) {
        super(nome, email, telefone);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
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
}
