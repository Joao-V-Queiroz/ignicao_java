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

    public void exibirMenuConta(Pessoa titular) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Contas");
            System.out.println("----------------------------------");
            System.out.println("\nDigite a opção desejada:");
            System.out.println("1 - Cadastrar Conta Especial");
            System.out.println("2 - Cadastrar Conta Investimento");
            System.out.println("3 - Voltar ao Menu Principal");
            System.out.println("----------------------------------");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    try{
                        double valorLimite;
                        System.out.println("Digite o valor limite da sua conta especial: ");
                        valorLimite = scanner.nextDouble();

                        ContaEspecial contaEspecial = contaService.criarContaEspecial(titular, 1239, valorLimite);
                        System.out.println("Conta especial cadastrada com sucesso!");
                        this.exibirMenuOperacoesContaEspecial(contaEspecial);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar conta especial: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        ContaInvestimento contaInvestimento = contaService.criarContaInvestimento(titular, 1239);
                        System.out.println("Conta investimento cadastrada com sucesso!");
                        this.exibirMenuOperacoesContaInvestimento(contaInvestimento);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar conta investimento: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while(opcao != 3);
    }

    public void exibirMenuOperacoesContaEspecial(ContaEspecial contaEspecial) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\nOperações conta especial");
            System.out.println("----------------------------------");
            System.out.println("1 - Dados da conta especial");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Debitar tarifa mensal");
            System.out.println("5 - Voltar ao Menu Principal");
            System.out.println("---------------------------------");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    contaService.exibirDadosConta(contaEspecial);
                    break;
                case 2:
                    double valorDeposito;

                    System.out.println("Digite o valor deposito:");
                    valorDeposito = scanner.nextDouble();

                    contaService.depositar(contaEspecial, valorDeposito);
                    break;
                case 3:
                    double valorSaque;

                    System.out.println("Digite o valor saque:");
                    valorSaque = scanner.nextDouble();

                    contaService.sacar(contaEspecial, valorSaque);
                    break;

                case 4:
                    contaService.debitarTarifaMensal(contaEspecial);
                    break;

                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }while (opcao != 5);
    }

    public void exibirMenuOperacoesContaInvestimento(ContaInvestimento contaInvestimento) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\nOperações conta investimento");
            System.out.println("-------------------------------");
            System.out.println("1 - Dados da conta especial");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Debitar tarifa mensal");
            System.out.println("5 - Creditar rendimentos");
            System.out.println("6 - Voltar ao Menu Principal");
            System.out.println("-------------------------------");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    contaService.exibirDadosConta(contaInvestimento);
                    break;

                case 2:
                    double valorDeposito;

                    System.out.println("Digite o valor deposito:");
                    valorDeposito = scanner.nextDouble();

                    contaService.depositar(contaInvestimento, valorDeposito);
                    break;

                case 3:
                    double valorSaque;

                    System.out.println("Digite o valor saque:");
                    valorSaque = scanner.nextDouble();

                    contaService.sacar(contaInvestimento, valorSaque);
                    break;

                case 4:
                    contaService.debitarTarifaMensal(contaInvestimento);
                    break;

                case 5:
                    double valorInvestimento;

                    System.out.println("Digite o valor investimento:");
                    valorInvestimento =  scanner.nextDouble();

                    contaService.creditarRendimentos(contaInvestimento, valorInvestimento);
                    break;

                case 6:
                    System.out.println("Voltando ao Menu Principal...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 6);
    }

}
