package br.com.fiscalizacao.model;

public class FiscalModel {

    private String nome;
    private String matricula;
    private String contrato;


    // construtores
    public FiscalModel() {
    }

    public FiscalModel( String nome, String matricula, String contrato){
        this.nome = nome;
        this.matricula = matricula;
        this.contrato = contrato;
    }

    // getters
    public String getNome(){
        return this.nome;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public String getContrato(){
        return this.contrato;
    }

    // setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public void setContrato(String contrato){
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return "FiscalModel{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", contrato='" + contrato + '\'' +
                '}';
    }
} // fim da classe FiscalModel
