package br.com.projeto.persistencia.dao;

import br.com.projeto.negocio.entidades.Funcionario;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FuncionarioImpDAO extends BaseImpDAO implements BaseDAO<Funcionario> {

    private static final String INSERT = "insert into Funcionario(Nome, CPF, Email, Funcao, DataNascimento, RG, Status, Login, Senha, Telefone, Celular)"
            + "values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE FUNCIONARIO SET nome= ?,  cpf = ?, email = ?, funcao = ?, dataNascimento = ? , rg = ?,  status = ?, login = ?, senha = ?, telefone = ?, celular =? where idFuncionario =  ?";
    private static final String SELECT = "SELECT * FROM FUNCIONARIO";

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
        PreparedStatement update = null;
        try {
            update = FabricaConexao.obterConexao().prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            update.setString(1, entidade.getNome());
            update.setString(2, entidade.getCPF());
            update.setString(3, entidade.getEmail());
            update.setString(4, entidade.getFuncao());
            update.setDate(5, entidade.getDataNascimento());
            update.setString(6, entidade.getRG());
            update.setInt(7, entidade.getStatus());
            update.setString(8, entidade.getLogin());
            update.setString(9, entidade.getSenha());
            update.setString(10, entidade.getTelefone());
            update.setString(11, entidade.getCelular());
            update.setInt(12, entidade.getIdFuncionario());

            update.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao inserir Funcionario");
        }
        return entidade.getIdFuncionario();
    }

    @Override
    public List<Funcionario> list() throws PersistenciaException {
        PreparedStatement select = null;
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT);
            ResultSet rs = select.executeQuery();
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            int idFuncionario;
            String Nome;
            String CPF;
            String Email;
            String Funcao;
            Date dataNascimento;
            String RG;
            int Status;
            String Login;
            String Senha;
            String telefone;
            String celular;
            while (rs.next()) {
                idFuncionario = rs.getInt(1);
                Nome = rs.getString(2);
                CPF = rs.getString(3);
                Email = rs.getString(4);
                Funcao = rs.getString(5);
                dataNascimento = rs.getDate(6);
                RG = rs.getString(7);
                Status = rs.getInt(8);
                Login = rs.getString(9);
                Senha = rs.getString(10);
                telefone = rs.getString(11);
                celular = rs.getString(12);
                funcionarios.add(new Funcionario(idFuncionario, Nome, CPF, Email, Funcao, dataNascimento, RG, Status, Login, Senha, telefone, celular));

            }
            return funcionarios;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar Funcionarios");
        }
    }

    @Override
    public Funcionario find(int id) throws PersistenciaException {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
