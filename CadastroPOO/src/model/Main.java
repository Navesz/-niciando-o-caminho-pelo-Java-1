package model;

import java.io.*;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoPessoaFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPessoaJuridica = new PessoaJuridicaRepo();
        String prefixoArquivo;

        boolean continuar = true;
        while (continuar) {
            System.out.println("===========================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("===========================");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            try {
                switch (opcao) {
                    case 1:
                        incluirPessoa(scanner, repoPessoaFisica, repoPessoaJuridica);
                        break;
                    case 2:
                        alterarPessoa(scanner, repoPessoaFisica, repoPessoaJuridica);
                        break;
                    case 3:
                        excluirPessoa(scanner, repoPessoaFisica, repoPessoaJuridica);
                        break;
                    case 4:
                        buscarPessoaPorId(scanner, repoPessoaFisica, repoPessoaJuridica);
                        break;
                    case 5:
                        exibirTodos(scanner, repoPessoaFisica, repoPessoaJuridica);
                        break;
                    case 6:
                        System.out.print("Digite o prefixo para o arquivo de dados: ");
                        prefixoArquivo = scanner.nextLine();
                        persistirDados(repoPessoaFisica, repoPessoaJuridica, prefixoArquivo);
                        break;
                    case 7:
                        System.out.print("Digite o prefixo para o arquivo de dados a ser recuperado: ");
                        prefixoArquivo = scanner.nextLine();
                        recuperarDados(repoPessoaFisica, repoPessoaJuridica, prefixoArquivo);
                        break;
                    case 0:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (IOException e) {
                System.err.println("Ocorreu um erro de entrada/saída: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.err.println("Classe não encontrada durante a deserialização: " + e.getMessage());
            }
        }
        scanner.close();
        System.out.println("Programa finalizado.");
    }

    private static void incluirPessoa(Scanner scanner, PessoaFisicaRepo repoPF, PessoaJuridicaRepo repoPJ) throws IOException {
        System.out.println("Escolha o tipo de pessoa para incluir (F - Física, J - Jurídica): ");
        String tipo = scanner.nextLine();
        if (tipo.equalsIgnoreCase("F")) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine()); 
            int id = repoPF.obterTodos().size() + 1; 
            PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
            repoPF.inserir(pf);
        } else if (tipo.equalsIgnoreCase("J")) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            int id = repoPJ.obterTodos().size() + 1;  
            PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
            repoPJ.inserir(pj);
        } else {
            System.out.println("Tipo inválido. Tente novamente.");
        }
    }

    private static void alterarPessoa(Scanner scanner, PessoaFisicaRepo repoPF, PessoaJuridicaRepo repoPJ) throws IOException {
        System.out.println("Escolha o tipo de pessoa para alterar (F - Física, J - Jurídica): ");
        String tipo = scanner.nextLine();
        System.out.print("Digite o id da pessoa: ");
        int id = Integer.parseInt(scanner.nextLine());  

        if (tipo.equalsIgnoreCase("F")) {
            PessoaFisica pf = repoPF.obter(id);
            if (pf != null) {
                System.out.print("Nome (" + pf.getNome() + "): ");
                pf.setNome(scanner.nextLine());
                System.out.print("CPF (" + pf.getCpf() + "): ");
                pf.setCpf(scanner.nextLine());
                System.out.print("Idade (" + pf.getIdade() + "): ");
                pf.setIdade(Integer.parseInt(scanner.nextLine()));  
                repoPF.alterar(pf);
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            PessoaJuridica pj = repoPJ.obter(id);
            if (pj != null) {
                System.out.print("Nome (" + pj.getNome() + "): ");
                pj.setNome(scanner.nextLine());
                System.out.print("CNPJ (" + pj.getCnpj() + "): ");
                pj.setCnpj(scanner.nextLine());
                repoPJ.alterar(pj);
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido. Tente novamente.");
        }
    }

    private static void excluirPessoa(Scanner scanner, PessoaFisicaRepo repoPF, PessoaJuridicaRepo repoPJ) throws IOException {
        System.out.println("Escolha o tipo de pessoa para excluir (F - Física, J - Jurídica): ");
        String tipo = scanner.nextLine();
        System.out.print("Digite o id da pessoa: ");
        int id = Integer.parseInt(scanner.nextLine());  

        if (tipo.equalsIgnoreCase("F")) {
            repoPF.excluir(id);
        } else if (tipo.equalsIgnoreCase("J")) {
            repoPJ.excluir(id);
        } else {
            System.out.println("Tipo inválido. Tente novamente.");
        }
    }

    private static void buscarPessoaPorId(Scanner scanner, PessoaFisicaRepo repoPF, PessoaJuridicaRepo repoPJ) throws IOException {
        System.out.println("Escolha o tipo de pessoa para buscar (F - Física, J - Jurídica): ");
        String tipo = scanner.nextLine();
        System.out.print("Digite o id da pessoa: ");
        int id = Integer.parseInt(scanner.nextLine());  

        if (tipo.equalsIgnoreCase("F")) {
            PessoaFisica pf = repoPF.obter(id);
            if (pf != null) {
                pf.exibir();
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            PessoaJuridica pj = repoPJ.obter(id);
            if (pj != null) {
                pj.exibir();
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido. Tente novamente.");
        }
    }

    private static void exibirTodos(Scanner scanner, PessoaFisicaRepo repoPF, PessoaJuridicaRepo repoPJ) throws IOException {
        System.out.println("Escolha o tipo de pessoa para exibir todos (F - Física, J - Jurídica): ");
        String tipo = scanner.nextLine();

        if (tipo.equalsIgnoreCase("F")) {
            List<PessoaFisica> todasPessoasFisicas = repoPF.obterTodos();
            todasPessoasFisicas.forEach(PessoaFisica::exibir);
        } else if (tipo.equalsIgnoreCase("J")) {
            List<PessoaJuridica> todasPessoasJuridicas = repoPJ.obterTodos();
            todasPessoasJuridicas.forEach(PessoaJuridica::exibir);
        } else {
            System.out.println("Tipo inválido. Tente novamente.");
        }
    }

    private static void persistirDados(PessoaFisicaRepo repoPF, PessoaJuridicaRepo repoPJ, String prefixoArquivo) throws IOException {
        repoPF.persistir(prefixoArquivo + ".fisica.bin");
        repoPJ.persistir(prefixoArquivo + ".juridica.bin");
        System.out.println("Dados persistidos com sucesso.");
    }
    
    private static void recuperarDados(PessoaFisicaRepo repoPF, PessoaJuridicaRepo repoPJ, String prefixoArquivo) throws IOException, ClassNotFoundException {
        repoPF.recuperar(prefixoArquivo + ".fisica.bin");
        repoPJ.recuperar(prefixoArquivo + ".juridica.bin");
        System.out.println("Dados recuperados com sucesso.");
    }

}


