package br.com.fiscalizacao.model;

public class FiscalModel {

    private String nome;
    private String matricula;
    private String fiscal;

    public FiscalModel() {

    }

    public FiscalModel(String nome, String matricula, String fiscal) {
        this.nome = nome;
        this.matricula = matricula;
        this.fiscal = fiscal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFiscal() {
        return fiscal;
    }

    public void setFiscal(String fiscal) {
        this.fiscal = fiscal;
    }
} // fim da classe FiscalModel
