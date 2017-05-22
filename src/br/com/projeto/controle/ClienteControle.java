package br.com.projeto.controle;

import br.com.projeto.negocio.entidades.Alteracoes;
import br.com.projeto.negocio.entidades.Avaliacao;
import br.com.projeto.negocio.entidades.Biometria;
import br.com.projeto.negocio.entidades.Cliente;
import br.com.projeto.negocio.entidades.Endereco;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.dao.AlteracoesImpDAO;
import br.com.projeto.persistencia.dao.AvaliacaoImpDao;
import br.com.projeto.persistencia.dao.BiometriaImpDAO;
import br.com.projeto.persistencia.dao.ClienteImpDAO;
import br.com.projeto.persistencia.dao.EnderecoImpDAO;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteControle implements BaseControle<Cliente> {

    private List<String> messages = new ArrayList<String>();

    @Override
    public void adicionar(Cliente entidade) {
        Connection con = FabricaConexao.obterConexao();
        try {
            con.setAutoCommit(false);
            ClienteImpDAO clienteDao = new ClienteImpDAO();
            EnderecoImpDAO enderecoDAO = new EnderecoImpDAO();
            int id = clienteDao.insert(entidade); // insere cliente
            entidade.getEndereco().setCliente_id(id); //seta o id do cliente no endereço
            int idEndereco = enderecoDAO.insert(entidade.getEndereco()); //insere endereço

            AvaliacaoImpDao avaliacaoDAO = new AvaliacaoImpDao();
            entidade.getAvaliacao().setCliente_id(id);
            int idAvaliacao = avaliacaoDAO.insert(entidade.getAvaliacao());

            AlteracoesImpDAO alteracoesDAO = new AlteracoesImpDAO();
            entidade.getAlteracoes().setCliente_id(id);
            int idAlteracoes = alteracoesDAO.insert(entidade.getAlteracoes());

            BiometriaImpDAO biometriaDAO = new BiometriaImpDAO();
            entidade.getBiometria().setCliente_id(id);
            int idBiometria = biometriaDAO.insert(entidade.getBiometria());

            con.commit(); // se nenhum dos inserts der errado comita*
        } catch (SQLException ex) {
            entidade.adicionarMensagem(ex.getMessage());
            try {
                con.rollback(); // se algum insert der errado, rollback e não insere nada
            } catch (SQLException ex1) {
                Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex1);
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
                Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void atualizar(Cliente entidade) {
        Connection con = FabricaConexao.obterConexao();
        try {
            con.setAutoCommit(false);
            ClienteImpDAO clienteDao = new ClienteImpDAO();
            EnderecoImpDAO enderecoDAO = new EnderecoImpDAO();
            int id = clienteDao.edit(entidade);
            Endereco enderecoAntigo = enderecoDAO.findByCliente(entidade.getId());
            entidade.getEndereco().setCliente_id(id);
            entidade.getEndereco().setIdEndereco(enderecoAntigo.getIdEndereco());
            int idEndereco = enderecoDAO.edit(entidade.getEndereco());

//            AlteracoesImpDAO alteracoesDAO = new AlteracoesImpDAO();
//            int id = clienteDAO.edit(entidade);
//            Alteracoes alteracoesAntigas = alteracoesDAO.findByCliente(entidade.getId());
//            con.commit();

        } catch (SQLException ex) {
            entidade.adicionarMensagem(ex.getMessage());
            try {
                con.rollback();

            } catch (SQLException ex1) {
                Logger.getLogger(ClienteControle.class
                        .getName()).log(Level.SEVERE, null, ex1);

            }
            Logger.getLogger(ClienteControle.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            entidade.adicionarMensagem(ex.getMessage());
            try {
                con.rollback();

            } catch (SQLException ex1) {
                Logger.getLogger(ClienteControle.class
                        .getName()).log(Level.SEVERE, null, ex1);

            }
            Logger.getLogger(ClienteControle.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.setAutoCommit(true);

            } catch (SQLException ex) {
                Logger.getLogger(ClienteControle.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            ClienteImpDAO clienteDAO = new ClienteImpDAO();
            clientes = clienteDAO.list();
            return clientes;

        } catch (PersistenciaException ex) {
            Logger.getLogger(ClienteControle.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    @Override
    public Cliente visualizar(int id) {
        Cliente cliente = new Cliente();
        try {
            ClienteImpDAO clienteDAO = new ClienteImpDAO();
            cliente = clienteDAO.find(id);
            return cliente;
        } catch (PersistenciaException ex) {
            cliente.adicionarMensagem(ex.getMessage());
            Logger
                    .getLogger(ClienteControle.class
                            .getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

}
