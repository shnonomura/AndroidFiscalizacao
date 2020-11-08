package br.com.fiscalizacao.model;

import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;

public class OsModel {

    private String os;
    private Boolean fiscalizada;
    private Boolean analisada;
    private HashMap<String, Boolean> pagarHashMap;
    private HashMap<String, Float> qtdeHashMap;
    private HashMap<String, Boolean> nrContratoHashMap;


    public OsModel() {
    }

    public OsModel( String newOs) {

        os = newOs;
        fiscalizada = false;
        analisada = false;
        pagarHashMap = null;
        qtdeHashMap = null;
        nrContratoHashMap = null;

    }


    public HashMap<String, Boolean> toPagarMap(){

        // criar o HashMap Object chamado pagarItensMap
        HashMap<String, Boolean> pagarItensHashMap = new HashMap<>();
        pagarItensHashMap.put("item01",false);
        pagarItensHashMap.put("item02",false);
        pagarItensHashMap.put("item03",false);
        System.out.println("HashMap pagarItens = " + pagarItensHashMap);

        return pagarItensHashMap;
    }

    public HashMap<String, Float> toQuantidadeMap() {

        // criar o HashMap Object chamado qtdeItensMap
        HashMap<String, Float> qtdeItensHashMap = new HashMap<>();
        qtdeItensHashMap.put("item01", (float) 1);
        qtdeItensHashMap.put("item02", (float) 1);
        qtdeItensHashMap.put("item03", (float) 1);
        System.out.println("HashMap qtdeItens = " + qtdeItensHashMap);

        return qtdeItensHashMap;
    }


    public HashMap<String, Boolean> toNrContratoMao() {

        // criar o HashMap Object chamado nrContratoMap
        HashMap<String, Boolean> nrContratoHashMap = new HashMap<>();
        nrContratoHashMap.put("20207421001", false);
        nrContratoHashMap.put("20207421002", false);
        nrContratoHashMap.put("20207421003", false);
        System.out.println("HashMap nrContratoMap = " + nrContratoHashMap);

        return nrContratoHashMap;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
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

    public HashMap<String, Boolean> getPagarHashMap() {
        return pagarHashMap;
    }

    public void setPagarHashMap(HashMap<String, Boolean> pagarHashMap) {
        this.pagarHashMap = pagarHashMap;
    }

    public HashMap<String, Float> getQtdeHashMap() {
        return qtdeHashMap;
    }

    public void setQtdeHashMap(HashMap<String, Float> qtdeHashMap) {
        this.qtdeHashMap = qtdeHashMap;
    }

    public HashMap<String, Boolean> getNrContratoHashMap() {
        return nrContratoHashMap;
    }

    public void setNrContratoHashMap(HashMap<String, Boolean> nrContratoHashMap) {
        this.nrContratoHashMap = nrContratoHashMap;
    }


} // fim da classe OsModel
