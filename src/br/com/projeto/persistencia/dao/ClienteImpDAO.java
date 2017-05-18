package br.com.projeto.persistencia.dao;

import br.com.projeto.negocio.entidades.Cliente;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class ClienteImpDAO extends BaseImpDAO implements BaseDAO<Cliente>  {

    private static final String INSERT = "insert into Cliente(nome, cpf, rg, dataNascimento,email) values(?,?,?,?,?)";

    @Override
    public int insert(Cliente cliente) throws PersistenciaException {
        PreparedStatement insert = null;
        try {
            insert = FabricaConexao.obterConexao().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insert.setString(1, cliente.getNome());
            insert.setString(2, cliente.getCpf());
            insert.setString(3, cliente.getRg());
            insert.setDate(4, cliente.getDataNascimento());
            insert.setString(5, cliente.getEmail());
            insert.executeUpdate();
            return obterId(insert);

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
    public void edit(Cliente cliente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> list() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
