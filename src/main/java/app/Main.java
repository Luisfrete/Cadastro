package app;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.*;
import java.sql.*;

import static dao.UsuariosDAO.*;
import static dao.PessoaDAO.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1. Login");
            System.out.println("2. Cadastro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int escolhaPrincipal = scanner.nextInt();

            switch (escolhaPrincipal) {
                case 0:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                case 1:
                    menuLogin(scanner);
                    break;
                case 2:
                    menuAutor(scanner);
                    break;
                case 3:
                    menuCategoria(scanner);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void menuCategoria(Scanner scanner) {
    }

    private static void menuAutor(Scanner scanner) {
    }

    private static void menuLogin(Scanner scanner) throws SQLException {
        while (true) {
            System.out.println("\nMenu Livro:");
            System.out.println("1. Adicionar Login");
            System.out.println("2. Atualizar Login");
            System.out.println("3. Listar Login");
            System.out.println("4. Excluir Login");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int escolhaLivro = scanner.nextInt();

            switch (escolhaLivro) {
                case 0:
                    return;
                case 1:
                    inserir();
                    break;
                case 2:
                    atualizar();
                    break;
                case 3:
                    System.out.println("Aqui estão todos os livros.");
                    visualizar();
                    break;
                case 4:
                    remover();
                    System.out.println("Livro excluido com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    
}