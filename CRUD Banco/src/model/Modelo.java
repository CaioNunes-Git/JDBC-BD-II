package model;

public class Modelo {
    private Integer codModelo;
    private String descricao;

    public Modelo(Integer codModelo, String descricao) {
        this.codModelo = codModelo;
        this.descricao = descricao;
    }

    public Integer getCodModelo() {
        return codModelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
