package br.com.fiscalizacao.model;

import java.util.HashMap;
import java.util.Map;

public class ItensModel {

    private String cod_item;
    private String descr_item;
    private Double qtde_item;
    private String unidade_item;
    private Double punit_item;
    private Double ptotal_item;

    public ItensModel() {
    }

    public ItensModel(String cod_item, String descr_item, Double qtde_item, String unidade_item, Double punit_item, Double ptotal_item) {

        this.cod_item = cod_item;
        this.descr_item = descr_item;
        this.qtde_item = qtde_item;
        this.unidade_item = unidade_item;
        this.punit_item = punit_item;
        this.ptotal_item = qtde_item*punit_item;
    }

    // getters

    public String getCod_item() {
        return cod_item;
    }

    public String getDescr_item() {
        return descr_item;
    }

    public Double getQtde_item() {
        return qtde_item;
    }

    public String getUnidade_item() {
        return unidade_item;
    }

    public Double getPunit_item() {
        return punit_item;
    }

    public Double getPtotal_item() { return ptotal_item; }

    // setters

    public void setCod_item(String cod_item) {
        this.cod_item = cod_item;
    }

    public void setDescr_item(String descr_item) {
        this.descr_item = descr_item;
    }

    public void setQtde_item(Double qtde_item) {
        this.qtde_item = qtde_item;
    }

    public void setUnidade_item(String unidade_item) {
        this.unidade_item = unidade_item;
    }

    public void setPunit_item(Double punit_item) {
        this.punit_item = punit_item;
    }

    public void setPtotal_item(Double ptotal_item) { this.ptotal_item = ptotal_item; }

    // toMap é necessário para o processo de inclusão
    public Map<String, Object> toMap(){
        HashMap<String , Object> result = new HashMap<>();
        result.put("cod_item",cod_item);
        result.put( "descr_item" ,descr_item );
        result.put( "qtde_item" ,qtde_item );
        result.put( "unidade_item" , unidade_item);
        result.put( "punit_item" , punit_item );
        result.put( "ptotal_item" , ptotal_item);
        return result;
    }

} // fim da classe ItensModel
