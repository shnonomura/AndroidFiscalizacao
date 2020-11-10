package br.com.fiscalizacao;


public class Fiscal {
    private String nome;
    private String matricula;

    public Fiscal() {
    }

    public Fiscal(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome(int id) {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula(int id) {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


} // fim da classe Fiscal
