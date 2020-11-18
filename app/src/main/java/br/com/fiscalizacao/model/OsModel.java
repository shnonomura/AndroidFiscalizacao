package br.com.fiscalizacao.model;

import java.util.ArrayList;
import java.util.List;

public class OsModel {

    private String os;
    private String fiscal;
    private String contrato;
    private Boolean fiscalizada;
    private Boolean analisada;
    private List<ItemOsModel> ItensOsLista = new ArrayList<>();

    public List<ItemOsModel> getItensList() {
        return ItensOsLista;
    }
    public void setItensList(List<ItemOsModel> itens) { ItensOsLista = itens;}

    public OsModel() {
    }

    public OsModel(String os, String contrato, Boolean fiscalizada, Boolean analisada) {
        this.os = os;
        this.contrato = contrato;
        this.fiscalizada = fiscalizada;
        this.analisada = analisada;
    }

    public OsModel(String os, String fiscal, String contrato, Boolean fiscalizada, Boolean analisada) {
        this.os = os;
        this.fiscal = fiscal;
        this.contrato = contrato;
        this.fiscalizada = fiscalizada;
        this.analisada = analisada;
        //this.pagarHashMap = pagarHashMap;
        //this.qtdeHashMap = qtdeHashMap;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getFiscal() {
        return fiscal;
    }

    public void setFiscal(String fiscal) {
        this.fiscal = fiscal;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public Boolean getFiscalizada() {
        return fiscalizada;
    }

    public void setFiscalizada(Boolean fiscalizada) {
        this.fiscalizada = fiscalizada;
    }

    public Boolean getAnalisada() {
        return analisada;
    }

    public void setAnalisada(Boolean analisada) {
        this.analisada = analisada;
    }

} // fim da classe OsModel
