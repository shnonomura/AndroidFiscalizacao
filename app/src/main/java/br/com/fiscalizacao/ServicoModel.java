package br.com.fiscalizacao;

public class ServicoModel {

    private String itemServico;
    private String descricao;
    private Float preco;
    private Boolean pagar;

    public ServicoModel() {
    }

    public ServicoModel(String itemServico, String descricao, Float preco, Boolean pagar) {
        this.itemServico = itemServico;
        this.descricao = descricao;
        this.preco = preco;
        this.pagar = pagar;
    }

    public String getItemServico() {
        return itemServico;
    }

    public void setItemServico(String itemServico) {
        this.itemServico = itemServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Boolean getPagar() {  return pagar; }

    public void setPagar(Boolean pagar) {
        this.pagar = pagar;
    }
} // fim da classe ServicoModel
