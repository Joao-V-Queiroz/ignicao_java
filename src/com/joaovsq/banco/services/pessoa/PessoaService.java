package com.joaovsq.banco.services.pessoa;

import com.joaovsq.banco.models.pessoa.Pessoa;
import com.joaovsq.banco.models.pessoa.PessoaFisica;
import com.joaovsq.banco.models.pessoa.PessoaJuridica;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.util.Scanner;

public class PessoaService {

    public Pessoa criarPessoa(String tipoPessoa) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisica pf = new PessoaFisica();
        PessoaJuridica pj = new PessoaJuridica();

        if(tipoPessoa.equals("F")) {
            System.out.println("Digite o nome da pessoa física: ");
            String nomePessoaFisica = scanner.nextLine();
            pf.setNome(nomePessoaFisica);

            System.out.println("Digite o CPF da pessoa física: ");
            String cpf = scanner.nextLine();
            pf.setCpf(cpf);

            System.out.println("Digite o email da pessoa física: ");
            String email = scanner.nextLine();
            pf.setEmail(email);

            System.out.println("Digite o telefone da pessoa física: ");
            String telefone = scanner.nextLine();
            pf.setTelefone(telefone);

            System.out.println("Digite o salário da pessoa física: ");
            double salario = scanner.nextDouble();
            pf.setSalario(salario);

            return pf;
        } else if(tipoPessoa.equals("J")) {
            System.out.println("Digite o nome da pessoa jurídica: ");
            String nomePessoaJuridica = scanner.nextLine();
            pj.setNome(nomePessoaJuridica);

            System.out.println("Digite o CNPJ da pessoa jurídica: ");
            String cnpj = scanner.nextLine();
            pj.setCnpj(cnpj);

            System.out.println("Digite o email da pessoa jurídica: ");
            String email = scanner.nextLine();
            pj.setEmail(email);

            System.out.println("Digite o telefone da pessoa jurídica: ");
            String telefone = scanner.nextLine();
            pj.setTelefone(telefone);

            System.out.println("Digite a o faturamento: ");
            double faturamento = scanner.nextDouble();
            pj.setFaturamento(faturamento);

            return pj;
        } else {
            System.out.println("Tipo de pessoa inválido.");
            return null;
        }
    }

    //pode ser pessoa física ou jurídica, devo exibir os dados de ambos
    public void exibirDadosTitular(Pessoa pessoa) {
        if (pessoa instanceof PessoaFisica) {
            PessoaFisica pf = (PessoaFisica) pessoa;
            System.out.println("\n----------------------------------");
            System.out.println("\nDados do Titular");
            System.out.println("Nome: " + pf.getNome());
            System.out.println("CPF: " + pf.getCpf());
            System.out.println("Email: " + pf.getEmail());
            System.out.println("Telefone: " + pf.getTelefone());
            System.out.println("----------------------------------\n");
        } else if(pessoa instanceof PessoaJuridica) {
            PessoaJuridica pj = (PessoaJuridica) pessoa;
            System.out.println("\n----------------------------------");
            System.out.println("\nDados do Titular");
            System.out.println("Nome: " + pj.getNome());
            System.out.println("CNPJ: " + pj.getCnpj());
            System.out.println("Email: " + pj.getEmail());
            System.out.println("Telefone: " + pj.getTelefone());
            System.out.println("----------------------------------\n");
        } else {
            System.out.println("\n----------------------------------");
            System.out.println("\nTipo de pessoa desconhecido.");
            System.out.println("----------------------------------\n");
        }
    }
}
