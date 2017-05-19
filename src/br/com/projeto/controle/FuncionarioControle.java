package br.com.projeto.controle;

import br.com.projeto.negocio.entidades.Endereco;
import br.com.projeto.negocio.entidades.Funcionario;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.dao.EnderecoImpDAO;
import br.com.projeto.persistencia.dao.FuncionarioImpDAO;
import java.sql.Connection;

public class FuncionarioControle {

    public void adicionar(Funcionario funcionario, Endereco endereco) {
        Connection con = FabricaConexao.obterConexao();
        try {
            con.setAutoCommit(false);
            FuncionarioImpDAO funcionarioDAO = new FuncionarioImpDAO();
            EnderecoImpDAO enderecoDAO = new EnderecoImpDAO();
            int id = funcionarioDAO.insert(funcionario);
            System.out.println(id);
            endereco.setFk_idFuncionario(id);
            int idEndereco = enderecoDAO.insert(endereco);
            con.commit();
            System.out.println(idEndereco);
            
            
        } catch (Exception e) {
        }
    }
}
