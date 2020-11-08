package br.com.fiscalizacao.model;

public class FiscalModel {

    private String nome;
    private String matricula;
    private Boolean contrato;

    public FiscalModel() {
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

    public Boolean getContrato() {
        return contrato;
    }

    public void setContrato(Boolean contrato) {
        this.contrato = contrato;
    }

} // fim da classe FiscalModel
