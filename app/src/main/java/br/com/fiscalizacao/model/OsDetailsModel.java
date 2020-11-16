package br.com.fiscalizacao.model;

public class OsDetailsModel {

    private String cod_item;
    private String descr_item;
    private double qtde_item;
    private String unidade_item;
    private double punit_item;
    private double ptotal_item;

    public OsDetailsModel() {
    }

    public OsDetailsModel(String cod_item, String descr_item, double qtde_item, String unidade_item, double punit_item) {
        this.cod_item = cod_item;
        this.descr_item = descr_item;
        this.qtde_item = qtde_item;
        this.unidade_item = unidade_item;
        this.punit_item = punit_item;
    }

    // getters
    public String getCod_item() {
        return cod_item;
    }

    public String getDescr_item() {
        return descr_item;
    }

    public double getQtde_item() {
        return qtde_item;
    }

    public String getUnidade_item() {
        return unidade_item;
    }

    public double getPunit_item() {
        return punit_item;
    }

    // setters
    public void setCod_item(String cod_item) {
        this.cod_item = cod_item;
    }

    public void setDescr_item(String descr_item) {
        this.descr_item = descr_item;
    }

    public void setQtde_item(double qtde_item) {
        this.qtde_item = qtde_item;
    }

    public void setUnidade_item(String unidade_item) {
        this.unidade_item = unidade_item;
    }

    public void setPunit_item(double punit_item) {
        this.punit_item = punit_item;
    }

    public void setPtotal_item(double ptotal_item) {
        this.ptotal_item = ptotal_item;
    }


} // fim da classe OsDetailsModel
