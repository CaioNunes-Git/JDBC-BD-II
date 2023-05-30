package model;

public class Veiculo {
    private String placa;
    private Integer anoFabricacao;
    private String dataAquisicao;
    private String kmAtual;
    private Fabricante fabricante;
    private Modelo modelo;

    public Veiculo(String placa, Integer anoFabricacao, String dataAquisicao, String kmAtual, Fabricante fabricante, Modelo modelo) {
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
        this.dataAquisicao = dataAquisicao;
        this.kmAtual = kmAtual;
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(String kmAtual) {
        this.kmAtual = kmAtual;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                ", dataAquisicao='" + dataAquisicao + '\'' +
                ", kmAtual='" + kmAtual + '\'' +
                ", fabricante=" + fabricante.getDescricao() +
                ", modelo=" + modelo.getDescricao() +
                '}';
    }
}
