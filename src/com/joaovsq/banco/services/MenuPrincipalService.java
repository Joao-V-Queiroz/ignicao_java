package com.joaovsq.banco.services;

import com.joaovsq.banco.models.conta.Conta;
import com.joaovsq.banco.models.conta.ContaEspecial;
import com.joaovsq.banco.models.conta.ContaInvestimento;
import com.joaovsq.banco.models.pessoa.Pessoa;
import com.joaovsq.banco.services.conta.ContaService;
import com.joaovsq.banco.services.pessoa.PessoaService;
import java.util.Scanner;

public class MenuPrincipalService {

    PessoaService pessoaService = new PessoaService();
    ContaService contaService = new ContaService();

    public void exibirMenuPrincipal() {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nBem Vindo(a) ao Sistema Bancário");
            System.out.println("----------------------------------");
            System.out.println("\nDigite a opção desejada:");
            System.out.println("1 - Cadastrar Pessoa Física");
            System.out.println("2 - Cadastrar Pessoa Jurídica");
            System.out.println("3 - Sair");
            System.out.println("----------------------------------");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if(opcao == 1) {
                int cadastrarConta;
                Pessoa pf = pessoaService.criarPessoa("F");
                pessoaService.exibirDadosTitular(pf);

                System.out.println("Deseja cadastrar uma conta para essa pessoa física? (1 - Sim, 2 - Não)");
                cadastrarConta = scanner.nextInt();
                scanner.nextLine();

                if(cadastrarConta == 1) {
                    exibirMenuConta(pf);
                } else {
                    System.out.println("Voltando ao Menu Principal...");
                }

            } else if(opcao == 2) {
                Pessoa pj = pessoaService.criarPessoa("J");
                pessoaService.exibirDadosTitular(pj);

                int cadastrarConta;
                System.out.println("Deseja cadastrar uma conta para essa pessoa jurídica? (1 - Sim, 2 - Não)");
                cadastrarConta = scanner.nextInt();
                scanner.nextLine();

                if(cadastrarConta == 1) {
                    exibirMenuConta(pj);
                } else {
                    System.out.println("Voltando ao Menu Principal...");
                }

            } else if(opcao == 3) {
                System.out.println("Saindo do sistema...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } while(opcao != 3);
    }

    public void exibirMenuConta(Pessoa pessoa) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Contas");
            System.out.println("----------------------------------");
            System.out.println("\nDigite a opção desejada:");
            System.out.println("1 - Cadastrar Conta");
            System.out.println("2 - Cadastrar Conta Especial");
            System.out.println("3 - Cadastrar Conta Investimento");
            System.out.println("4 - Voltar ao Menu Principal");
            System.out.println("----------------------------------");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    try{
                        Conta conta = contaService.criarConta(pessoa);
                        System.out.println("Conta cadastrada com sucesso!");
                        contaService.exibirDadosConta(conta);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar conta: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        ContaEspecial contaEspecial = contaService.criarContaEspecial(pessoa, 200_000.00);
                        System.out.println("Conta Especial cadastrada com sucesso!");
                        contaService.exibirDadosConta(contaEspecial);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar conta especial: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        ContaInvestimento contaInvestimento = contaService.criarContaInvestimento(pessoa);
                        System.out.println("Conta de Investimento cadastrada com sucesso!");
                        contaService.exibirDadosConta(contaInvestimento);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar conta de investimento: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while(opcao != 4);
    }

}
