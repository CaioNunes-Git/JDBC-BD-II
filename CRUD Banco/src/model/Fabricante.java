package model;

public class Fabricante {
    private Integer codFabricante;
    private String descricao;

    public Fabricante(Integer codFabricante, String descricao) {
        this.codFabricante = codFabricante;
        this.descricao = descricao;
    }

    public Integer getCodFabricante() {
        return codFabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
