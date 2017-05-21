package br.com.projeto.controle;

import br.com.projeto.negocio.entidades.Endereco;
import br.com.projeto.negocio.entidades.Funcionario;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.dao.EnderecoImpDAO;
import br.com.projeto.persistencia.dao.FuncionarioImpDAO;
import java.sql.Connection;
import java.util.List;

public class FuncionarioControle implements BaseControle<Funcionario> {

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
            System.out.println(idEndereco);

        } catch (Exception e) {
        }
    }

    @Override
    public void atualizar(Funcionario entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario visualizar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
