package model;

public class Pessoa {
    private static int id;
    private static String nome;
    private static String cpf;
    private static String sexo;
    private static String email;
    private static String nascimento;

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        Pessoa.id = id;
    }

    public static String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Pessoa.nome = nome;
    }

    public static String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        Pessoa.cpf = cpf;
    }

    public static String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        Pessoa.sexo = sexo;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Pessoa.email = email;
    }

    public static String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        Pessoa.nascimento = nascimento;
    }
}
