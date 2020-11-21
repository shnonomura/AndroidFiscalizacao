package br.com.fiscalizacao.model;

import java.util.ArrayList;
import java.util.List;

public class OsModel {

    private String os;
    private String fiscal;
    private String contrato;
    private Boolean fiscalizada;
    private Boolean analisada;
    private List<ItensModel> itens = new ArrayList<>();


    public OsModel() {
    }

    public OsModel(String os, String fiscal, String contrato, Boolean fiscalizada, Boolean analisada, List<ItensModel> itens) {
        this.os = os;
        this.fiscal = fiscal;
        this.contrato = contrato;
        this.fiscalizada = fiscalizada;
        this.analisada = analisada;
        this.itens = itens;
    }

    public String getOs() {
        return os;
    }

    public String getFiscal() {
        return fiscal;
    }

    public String getContrato() {
        return contrato;
    }

    public Boolean getFiscalizada() {
        return fiscalizada;
    }

    public Boolean getAnalisada() {
        return analisada;
    }

    public List<ItensModel> getItens() {
        return itens;
    }

    // setters

    public void setOs(String os) {
        this.os = os;
    }

    public void setFiscal(String fiscal) {
        this.fiscal = fiscal;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public void setFiscalizada(Boolean fiscalizada) {
        this.fiscalizada = fiscalizada;
    }

    public void setAnalisada(Boolean analisada) {
        this.analisada = analisada;
    }

    public void setItens(List<ItensModel> itens) {
        this.itens = itens;
    }

} // fim da classe OsModel
