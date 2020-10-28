package br.com.fiscalizacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TesteModel {

    private String os;
    private Boolean fiscalizada;
    private Boolean analisada;
    private String contrato;



    //private HashMap<String, Boolean> pagarHashMap;
    //private HashMap<String, Float> qtdeHashMap;
    //private HashMap<String, Boolean> nrContratoHashMap;
    private List<ServicoModel> servicos = new ArrayList<>();

    public TesteModel() {
    }

    public TesteModel(String contrato, String os, Boolean fiscalizada, Boolean analisada, List<ServicoModel> servicos ) {
        this.os = os;
        this.fiscalizada = fiscalizada;
        this.analisada = analisada;
        this.servicos = servicos;
        this.contrato = contrato;

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

    public List<ServicoModel> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicoModel> servicos) {
        this.servicos = servicos;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
}
