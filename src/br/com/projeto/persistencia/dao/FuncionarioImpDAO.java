package br.com.projeto.persistencia.dao;

import br.com.projeto.negocio.entidades.Funcionario;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

public class FuncionarioImpDAO extends BaseImpDAO implements BaseDAO<Funcionario> {

    private static final String INSERT = "insert into Funcionario(Nome, CPF, Email, Funcao, DataNascimento, RG, Status, Login, Senha, Telefone, Celular)"
            + "values(?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public int insert(Funcionario funcionario) throws PersistenciaException {
        PreparedStatement insert = null;
        try {
            insert = FabricaConexao.obterConexao().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insert.setString(1, funcionario.getNome());
            insert.setString(2, funcionario.getCPF());
            insert.setString(3, funcionario.getEmail());
            insert.setString(4, funcionario.getFuncao());
            insert.setDate(5, funcionario.getDataNascimento());
            insert.setString(6, funcionario.getRG());
            insert.setInt(7, funcionario.getStatus());
            insert.setString(8, funcionario.getLogin());
            insert.setString(9, funcionario.getSenha());
            insert.setString(10, funcionario.getTelefone());
            insert.setString(11, funcionario.getCelular());
            insert.executeUpdate();
            return obterId(insert);

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao inserir Funcionario");
        } finally {
            try {
                insert.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remove(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int edit(Funcionario entidade) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> list() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario find(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
