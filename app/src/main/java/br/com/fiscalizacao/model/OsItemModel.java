package br.com.fiscalizacao.model;

public class OsItemModel {

    private String itemServ;
    private String descrServ;
    private Float qtdeServ;
    private Float unitServ;

    public OsItemModel() {
    }

    public OsItemModel(String itemServ, String descrServ, Float qtdeServ, Float preUnitServ) {
        this.itemServ = itemServ;
        this.descrServ = descrServ;
        this.qtdeServ = qtdeServ;
        this.unitServ = preUnitServ;
    }

    public String getItemServ() {
        return itemServ;
    }

    public void setItemServ(String itemServ) {
        this.itemServ = itemServ;
    }

    public String getDescrServ() {
        return descrServ;
    }

    public void setDescrServ(String descrServ) {
        this.descrServ = descrServ;
    }

    public Float getQtdeServ() {
        return qtdeServ;
    }

    public void setQtdeServ(Float qtdeServ) {
        this.qtdeServ = qtdeServ;
    }

    public Float getunitServ() {
        return unitServ;
    }

    public void setunitServ(Float preUnitServ) {
        this.unitServ = preUnitServ;
    }

} // fim da class OsItemModel()
