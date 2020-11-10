package br.com.fiscalizacao.model;

public class ContratoModel {

    private String contrato;
    private String fornecedor;
    private String uf;
    private String fiscal;
    private Boolean servicos;
    private Boolean os;

    public ContratoModel() {
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getFiscal() {
        return fiscal;
    }

    public void setFiscal(String fiscal) {
        this.fiscal = fiscal;
    }

} // fim da classe ContratoModel
