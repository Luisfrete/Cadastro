package dao;

import model.Pessoa;

import javax.swing.*;
import java.sql.*;

public class PessoaDAO {
    public static void inserir() throws SQLException {
        //RECEBENDO DADOS
        String adicionar = "insert into Pessoa (id, nome, cpf, sexo, email, nascimento) values (?, ?, ?, ?, ?, ?)";

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb", "root", "coxaeuteamo123");
        PreparedStatement insere = connect.prepareStatement(adicionar);

        //ENTRADA DE DADOS
        String nome = JOptionPane.showInputDialog("Digite o Nome: ");
        String cpf = JOptionPane.showInputDialog("Digite o CPF: ");
        String sexo = JOptionPane.showInputDialog("Digite o Sexo: ");
        String email = JOptionPane.showInputDialog("Digite o Email: ");
        String nascimento = JOptionPane.showInputDialog("Digite o Nascimento: ");

        //INSERIR DADOS
        insere.setString(1, Pessoa.getNome());
        insere.setString(2, Pessoa.getCpf());
        insere.setString(3, Pessoa.getSexo());
        insere.setString(4, Pessoa.getEmail());
        insere.setString(5, Pessoa.getNascimento());

        insere.execute();

        String inserire = "insert into Pessoa (id, nome, cpf, sexo, email, nascimento) values (?, ?, ?, ?, ?, ?)";
    }

    public static void visualizar() throws SQLException {
        //RECEBENDO DADOS
        String pesquisa = "select * from Pessoa";
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb", "root", "coxaeuteamo123");
        PreparedStatement stmt = connect.prepareStatement(pesquisa);
        ResultSet pessoa = stmt.executeQuery();
        while (pessoa.next()) {
            System.out.println(pessoa.getString("nome") + " - " + pessoa.getString("id"));
            System.out.println(pessoa.getString("cpf") + " - " + pessoa.getString("id"));
            System.out.println(pessoa.getString("sexo") + " - " + pessoa.getString("id"));
            System.out.println(pessoa.getString("email") + " - " + pessoa.getString("id"));
            System.out.println(pessoa.getString("nascimento") + " - " + pessoa.getString("id"));
        }
    }

    public static void atualizar() throws SQLException {
        String updatepessoa = "update Pessoa set nome=?, cpf=?, sexo=?, email=?, nascimento=? where id=?";
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb", "root", "coxaeuteamo123");
        PreparedStatement prepareUpdate = connect.prepareStatement(updatepessoa);
        prepareUpdate.setString(1, Pessoa.getNome());
        prepareUpdate.setString(2, Pessoa.getCpf());
        prepareUpdate.setString(3, Pessoa.getSexo());
        prepareUpdate.setString(4, Pessoa.getEmail());
        prepareUpdate.setString(5, Pessoa.getNascimento());
        prepareUpdate.execute();
    }

    public static void remover() throws SQLException {
        String removerautores = "delete from Pessoa where id=?";
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb", "root", "coxaeuteamo123");
        PreparedStatement removecategorias = connect.prepareStatement(removerautores);
        removecategorias.setInt(1, Pessoa.getId());
        removecategorias.execute();
    }
}



