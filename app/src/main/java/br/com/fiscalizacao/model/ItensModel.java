package br.com.fiscalizacao.model;

public class ItensModel {

    private String mcod_item;
    private String mdescr_item;
    private Double mqtde_item;
    private String munidade_item;
    private Double mpunit_item;
    private Double mptotal_item;

    public ItensModel() {
    }

    public ItensModel(String cod_item, String descr_item, Double qtde_item, String unidade_item, Double punit_item, Double ptotal_item) {

        mcod_item = cod_item;
        mdescr_item = descr_item;
        mqtde_item = qtde_item;
        munidade_item = unidade_item;
        mpunit_item = punit_item;
        mptotal_item = qtde_item*punit_item;
    }

    // getters

    public String getCod_item() {
        return mcod_item;
    }

    public String getDescr_item() {
        return mdescr_item;
    }

    public Double getQtde_item() {
        return mqtde_item;
    }

    public String getUnidade_item() {
        return munidade_item;
    }

    public Double getPunit_item() {
        return mpunit_item;
    }

    public Double getPtotal_item() { return mptotal_item; }

    // setters

    public void setCod_item(String cod_item) {
        mcod_item = cod_item;
    }

    public void setDescr_item(String descr_item) {
        mdescr_item = descr_item;
    }

    public void setQtde_item(Double qtde_item) {
        mqtde_item = qtde_item;
    }

    public void setUnidade_item(String unidade_item) {
        munidade_item = unidade_item;
    }

    public void setPunit_item(Double punit_item) {
        mpunit_item = punit_item;
    }

    public void setPtotal_item(Double ptotal_item) { mptotal_item = ptotal_item; }


    public Double changeQtde(Double qtde_item){

        mqtde_item = qtde_item;
        mptotal_item = qtde_item*mpunit_item;
        return mqtde_item;

    }

} // fim da classe ItensModel
