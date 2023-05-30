package dao;

import model.Fabricante;
import model.Modelo;
import model.Veiculo;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    private Connection connection;


    public VeiculoDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Veiculo> listar() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT v.Placa, v.ano_fabricacao, v.data_aquisicao, v.km_atual, "
                + "m.descricao_modelo, f.descricao_fabricante "
                + "FROM veiculo v "
                + "INNER JOIN modelos m ON v.codigo_modelo = m.codigo_modelo "
                + "INNER JOIN fabricantes f ON v.codigo_fabricante = f.codigo_fabricante ";

        try {
            PreparedStatement smt = ConnectionFactory.recuperarConexao().prepareStatement(sql);
            smt.execute();
            ResultSet rst = smt.getResultSet();
            while (rst.next()) {
                Fabricante fabricante = new Fabricante(rst.getInt("codigo_fabricante"),
                        rst.getString("descricao_fabricante"));


                Modelo modelo = new Modelo(rst.getInt("codigo_modelo"),
                        rst.getString("descricao_modelo"));

                Veiculo veiculo = new Veiculo(rst.getString("Placa"),
                        rst.getInt("ano_fabricacao"),
                        rst.getString("data_aquisicao"),
                        rst.getString("km_atual"), fabricante, modelo);

                veiculos.add(veiculo);
            }
            smt.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return veiculos;
    }

    public void adicionar(Veiculo veiculo) {

        String sql = "Insert into veiculo values(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = ConnectionFactory.recuperarConexao().prepareStatement(sql);
            stm.execute();

            stm.setString(1, veiculo.getPlaca());
            stm.setInt(2, veiculo.getAnoFabricacao());
            stm.setString(3, veiculo.getDataAquisicao());
            stm.setString(4, veiculo.getKmAtual());
            stm.setInt(5, veiculo.getFabricante().getCodFabricante());
            stm.setInt(6, veiculo.getModelo().getCodModelo());

            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void remover(String placa) {
        try {
            verificarPlaca(placa);

            String sql = "Delete from veiculo where placa = ?";
            PreparedStatement stm = ConnectionFactory.recuperarConexao().prepareStatement(sql);
            stm.execute();
            stm.setString(1, placa);

            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(String placa, Veiculo veiculo) {
        verificarPlaca(placa);

        String sql = "UPDATE veiculo SET ano_fabricacao = ?," +
                "data_aquisicao = ?, km_atual = ?, cod_fabricante = ?, cod_modelo = ?" +
                "WHERE placa = ?";

        try {
            PreparedStatement stm = ConnectionFactory.recuperarConexao().prepareStatement(sql);
            stm.execute();


            stm.setInt(1, veiculo.getAnoFabricacao());
            stm.setString(2, veiculo.getDataAquisicao());
            stm.setString(3, veiculo.getKmAtual());
            stm.setInt(4, veiculo.getFabricante().getCodFabricante());
            stm.setInt(5, veiculo.getModelo().getCodModelo());
            stm.setString(6, veiculo.getPlaca());

            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            e.getMessage();
        }


    }

    private void verificarPlaca(String placa) {
        String sql = "Select * from veiculo where placa = ?";
        try {
            PreparedStatement stm = ConnectionFactory.recuperarConexao().prepareStatement(sql);
            stm.setString(1, placa);

            ResultSet rst = stm.executeQuery();
            if (!rst.next()) {
                throw new RuntimeException("Placa não encontrada");
            }
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
