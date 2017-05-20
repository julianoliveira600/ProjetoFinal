package br.com.projeto.persistencia.dao;

import br.com.projeto.negocio.entidades.Endereco;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class EnderecoImpDAO extends BaseImpDAO implements BaseDAO<Endereco> {

    private static final String INSERT = "insert into Endereco(fk_idCidade, Rua, Bairro, CEP, Complemento, Numero, Cliente_id) values(?,?,?,?,?,?,?)";

    @Override
    public int insert(Endereco endereco) throws PersistenciaException {
        PreparedStatement insert = null;
        try {
            insert = FabricaConexao.obterConexao().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insert.setInt(1, endereco.getFk_idCidade());
            insert.setString(2, endereco.getRua());
            insert.setString(3, endereco.getBairro());
            insert.setString(4, endereco.getCEP());
            insert.setString(5, endereco.getComplemento());
            insert.setInt(6, endereco.getNumero());
            insert.setInt(7,endereco.getCliente_id());
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
    public int edit(Endereco endereco) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Endereco> list() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
