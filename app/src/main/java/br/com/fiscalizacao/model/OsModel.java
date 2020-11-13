package br.com.fiscalizacao.model;

import java.util.HashMap;

public class OsModel {

    private String os;
    private String fiscal;
    private String contrato;
    private Boolean fiscalizada;
    private Boolean analisada;
    private HashMap<String, Boolean> pagarHashMap;
    private HashMap<String, Float> qtdeHashMap;


    public OsModel() {
    }

    public OsModel(String os, String contrato, Boolean fiscalizada, Boolean analisada) {
        this.os = os;
        this.contrato = contrato;
        this.fiscalizada = fiscalizada;
        this.analisada = analisada;
    }

    public OsModel(String os, String fiscal, String contrato, Boolean fiscalizada, Boolean analisada, HashMap<String, Boolean> pagarHashMap, HashMap<String, Float> qtdeHashMap) {
        this.os = os;
        this.fiscal = fiscal;
        this.contrato = contrato;
        this.fiscalizada = fiscalizada;
        this.analisada = analisada;
        this.pagarHashMap = pagarHashMap;
        this.qtdeHashMap = qtdeHashMap;
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

    public HashMap<String, Boolean> getPagarHashMap() {
        return pagarHashMap;
    }

    public HashMap<String, Float> getQtdeHashMap() {
        return qtdeHashMap;
    }

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

    public void setPagarHashMap(HashMap<String, Boolean> pagarHashMap) {
        this.pagarHashMap = pagarHashMap;
    }

    public void setQtdeHashMap(HashMap<String, Float> qtdeHashMap) {
        this.qtdeHashMap = qtdeHashMap;
    }
} // fim da classe OsModel
