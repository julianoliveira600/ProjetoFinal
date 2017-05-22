package br.com.projeto.persistencia.dao;

import br.com.projeto.negocio.entidades.Endereco;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnderecoImpDAO extends BaseImpDAO implements BaseDAO<Endereco> {

    private static final String INSERT_CLIENTE = "insert into Endereco(fk_idCidade, Rua, Bairro, CEP, Complemento, Numero, Cliente_id) values(?,?,?,?,?,?,?)";
    private static final String INSERT_FUNCIONARIO = "insert into Endereco(fk_idCidade, Rua, Bairro, CEP, Complemento, Numero, fk_idFuncionario) values(?,?,?,?,?,?,?)";
    private static final String SELECT_ID = "SELECT * FROM ENDERECO WHERE id = ?";
    private static final String SELECT_CLIENTE = "SELECT * FROM ENDERECO WHERE Cliente_id = ?";
    private static final String UPDATE_CLIENTE = "UPDATE ENDERECO SET fk_idCidade= ?,  Rua = ?, Bairro = ?, CEP = ?, Complemento = ? , Numero = ?,  Cliente_id = ? where idEndereco =  ?";
    private static final String SELECT_FUNCIONARIO = "SELECT * FROM ENDERECO WHERE fk_idFuncionario = ?";
    private static final String UPDATE_FUNCIONARIO = "UPDATE ENDERECO SET fk_idCidade= ?,  Rua = ?, Bairro = ?, CEP = ?, Complemento = ? , Numero = ?,  fk_idFuncionario = ? where idEndereco =  ?";

    @Override
    public int insert(Endereco endereco) throws PersistenciaException {
        PreparedStatement insert = null;
        int id = -1;
        try {
            if (endereco.getCliente_id() > 0) {
                insert = FabricaConexao.obterConexao().prepareStatement(INSERT_CLIENTE, Statement.RETURN_GENERATED_KEYS);
                insert.setInt(7, endereco.getCliente_id());
            } else {
                insert = FabricaConexao.obterConexao().prepareStatement(INSERT_FUNCIONARIO, Statement.RETURN_GENERATED_KEYS);
                insert.setInt(7, endereco.getFk_idFuncionario());
            }
            insert.setInt(1, endereco.getFk_idCidade());
            insert.setString(2, endereco.getRua());
            insert.setString(3, endereco.getBairro());
            insert.setString(4, endereco.getCEP());
            insert.setString(5, endereco.getComplemento());
            insert.setInt(6, endereco.getNumero());

            insert.executeUpdate();
            id = obterId(insert);
            endereco.setIdEndereco(id);
            return id;

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao inserir Cliente");
        } finally {
//            try {
//                insert.close();
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
        }
    }

    @Override
    public void remove(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int edit(Endereco endereco) throws PersistenciaException {
        PreparedStatement update = null;
        int id = -1;
        try {
            if (endereco.getCliente_id() > 0) {
                update = FabricaConexao.obterConexao().prepareStatement(UPDATE_CLIENTE, Statement.RETURN_GENERATED_KEYS);
                update.setInt(7, endereco.getCliente_id());
            } else {
                update = FabricaConexao.obterConexao().prepareStatement(UPDATE_FUNCIONARIO, Statement.RETURN_GENERATED_KEYS);
                update.setInt(7, endereco.getFk_idFuncionario());
            }
            update.setInt(1, endereco.getFk_idCidade());
            update.setString(2, endereco.getRua());
            update.setString(3, endereco.getBairro());
            update.setString(4, endereco.getCEP());
            update.setString(5, endereco.getComplemento());
            update.setInt(6, endereco.getNumero());
            update.setInt(8, endereco.getIdEndereco());

            update.executeUpdate();
            endereco.setIdEndereco(id);
            return endereco.getIdEndereco();

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao inserir Cliente");
        } finally {
//            try {
//                insert.close();
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
        }
    }

    @Override
    public List<Endereco> list() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Endereco find(int id) throws PersistenciaException {
        PreparedStatement select = null;
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT_ID);
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();
            Endereco endereco = new Endereco();
            while (rs.next()) {
                endereco.setIdEndereco(rs.getInt(1));
                endereco.setFk_idCidade(rs.getInt(2));
                endereco.setRua(rs.getString(3));
                endereco.setBairro(rs.getString(4));
                endereco.setCEP(rs.getString(5));
                endereco.setComplemento(rs.getString(6));
                endereco.setNumero(rs.getInt(7));
                endereco.setCliente_id(rs.getInt(8));
            }
            return endereco;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar o cliente");
        }
    }

    public Endereco findByCliente(int idCliente) throws PersistenciaException {
        PreparedStatement select = null;
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT_CLIENTE);
            select.setInt(1, idCliente);
            ResultSet rs = select.executeQuery();
            Endereco endereco = new Endereco();
            while (rs.next()) {
                endereco.setIdEndereco(rs.getInt(1));
                endereco.setFk_idCidade(rs.getInt(2));
                endereco.setRua(rs.getString(3));
                endereco.setBairro(rs.getString(4));
                endereco.setCEP(rs.getString(5));
                endereco.setComplemento(rs.getString(6));
                endereco.setNumero(rs.getInt(7));
                endereco.setCliente_id(rs.getInt(8));
            }
            return endereco;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar o cliente");
        }
    }

    public Endereco findByFuncionario(int idFuncionario) throws PersistenciaException {
        PreparedStatement select = null;
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT_FUNCIONARIO);
            select.setInt(1, idFuncionario);
            ResultSet rs = select.executeQuery();
            Endereco endereco = new Endereco();
            while (rs.next()) {
                endereco.setIdEndereco(rs.getInt(1));
                endereco.setFk_idCidade(rs.getInt(2));
                endereco.setRua(rs.getString(3));
                endereco.setBairro(rs.getString(4));
                endereco.setCEP(rs.getString(5));
                endereco.setComplemento(rs.getString(6));
                endereco.setNumero(rs.getInt(7));
                endereco.setFk_idFuncionario(rs.getInt(8));
            }
            return endereco;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar o Funcionario");
        }
    }

}
