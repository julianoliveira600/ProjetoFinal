package br.com.projeto.controle;

import br.com.projeto.negocio.entidades.Endereco;
import br.com.projeto.negocio.entidades.Funcionario;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.dao.EnderecoImpDAO;
import br.com.projeto.persistencia.dao.FuncionarioImpDAO;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioControle implements BaseControle<Funcionario> {

    private List<String> messages = new ArrayList<String>();

    public void adicionar(Funcionario entidade) {
        Connection con = FabricaConexao.obterConexao();
        try {
            con.setAutoCommit(false);
            FuncionarioImpDAO funcionarioDAO = new FuncionarioImpDAO();
            EnderecoImpDAO enderecoDAO = new EnderecoImpDAO();
            int id = funcionarioDAO.insert(entidade);
            entidade.getEndereco().setFk_idFuncionario(id);
            int idEndereco = enderecoDAO.insert(entidade.getEndereco());
            con.commit();

        } catch (SQLException ex) {
            entidade.adicionarMensagem(ex.getMessage());
            try {
                con.rollback();
            } catch (Exception ex1) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            entidade.adicionarMensagem(ex.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void atualizar(Funcionario entidade) {
        Connection con = FabricaConexao.obterConexao();
        try {
            FuncionarioImpDAO funcionarioDAO = new FuncionarioImpDAO();
            EnderecoImpDAO enderecoDAO = new EnderecoImpDAO();
            int id = funcionarioDAO.edit(entidade);
            Endereco enderecoAntigo = enderecoDAO.findByFuncionario(entidade.getIdFuncionario());
            entidade.getEndereco().setIdEndereco(enderecoAntigo.getIdEndereco());
            int idEndereco = enderecoDAO.edit(entidade.getEndereco());
            con.commit();
        } catch (SQLException ex) {
            entidade.adicionarMensagem(ex.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            entidade.adicionarMensagem(ex.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try {
            FuncionarioImpDAO funcionarioDAO = new FuncionarioImpDAO();
            funcionarios = funcionarioDAO.list();
            return funcionarios;
        } catch (PersistenciaException ex) {
            Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }

    @Override
    public Funcionario visualizar(int id) {
        Funcionario funcionario = new Funcionario();
        try {
            FuncionarioImpDAO funcionarioDAO = new FuncionarioImpDAO();
            funcionario = funcionarioDAO.find(id);
            return funcionario;
        } catch (PersistenciaException ex) {
            funcionario.adicionarMensagem(ex.getMessage());
            Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

}
