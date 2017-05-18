package br.com.projeto.controle;

import br.com.projeto.negocio.entidades.Cliente;
import br.com.projeto.negocio.entidades.Endereco;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.dao.ClienteImpDAO;
import br.com.projeto.persistencia.dao.EnderecoImpDAO;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteControle {

    public void adicionar(Cliente cliente, Endereco endereco) {
        Connection con = FabricaConexao.obterConexao();
        try {
            con.setAutoCommit(false);
            ClienteImpDAO clienteDao = new ClienteImpDAO();
            EnderecoImpDAO enderecoDAO = new EnderecoImpDAO();
            int id = clienteDao.insert(cliente);
            System.out.println(id);
            endereco.setCliente_id(id);
            int idEndereco = enderecoDAO.insert(endereco);
            con.commit();
            System.out.println(idEndereco);

        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
