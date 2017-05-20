package br.com.projeto.controle;

import br.com.projeto.negocio.entidades.Cliente;
import br.com.projeto.negocio.entidades.Endereco;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.dao.ClienteImpDAO;
import br.com.projeto.persistencia.dao.EnderecoImpDAO;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteControle {
    
    
    private List<String> messages = new ArrayList<String>();

    public void adicionar(Cliente cliente, Endereco endereco) {
        Connection con = FabricaConexao.obterConexao();
        try {
            con.setAutoCommit(false);
            ClienteImpDAO clienteDao = new ClienteImpDAO();
            EnderecoImpDAO enderecoDAO = new EnderecoImpDAO();
            int id = clienteDao.insert(cliente); // insere cliente
            endereco.setCliente_id(id); //seta o id do cliente no endereço
            int idEndereco = enderecoDAO.insert(endereco); //insere endereço
            con.commit(); // se nenhum dos inserts der errado comita*
        } catch (SQLException ex) {
            messages.add("Não foi possível inserir cliente.");
            try {
                con.rollback(); // se algum insert der errado, rollback e não insere nada
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

    public void atualizar(Cliente cliente, Endereco endereco) {
        Connection con = FabricaConexao.obterConexao();
        try {
            con.setAutoCommit(false);
            ClienteImpDAO clienteDao = new ClienteImpDAO();
            EnderecoImpDAO enderecoDAO = new EnderecoImpDAO();
            int id = clienteDao.edit(cliente);
            Endereco enderecoAntigo = enderecoDAO.findByCliente(cliente.getId());
            endereco.setCliente_id(id);
            endereco.setIdEndereco(enderecoAntigo.getIdEndereco());
            int idEndereco = enderecoDAO.edit(endereco);
            con.commit();

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
    
    public List<Cliente> listar(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        try{
            ClienteImpDAO clienteDAO= new ClienteImpDAO();
            clientes = clienteDAO.list();
            return clientes;
        } catch (PersistenciaException ex) {
            Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    
    public Cliente visualizar(int id){
        Cliente cliente = new Cliente();
        try{
            ClienteImpDAO clienteDAO= new ClienteImpDAO();
            cliente = clienteDAO.find(id);
            return cliente;
        } catch (PersistenciaException ex) {
            Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
   
}
