package br.com.projeto.persistencia.dao;

import br.com.projeto.negocio.entidades.Alteracoes;
import br.com.projeto.negocio.entidades.Biometria;
import br.com.projeto.negocio.entidades.Cliente;
import br.com.projeto.negocio.entidades.Endereco;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteImpDAO extends BaseImpDAO implements BaseDAO<Cliente> {

    private static final String INSERT = "insert into Cliente(nome, cpf, rg, dataNascimento,email, Telefone, Celular) values(?,?,?,?,?,?,?)";
        private static final String UPDATE = "UPDATE CLIENTE SET nome= ?,  cpf = ?, rg = ?, dataNascimento = ?, email = ? , Telefone = ?,  Celular = ? where id =  ?";
    private static final String SELECT = "SELECT * FROM CLIENTE";
    private static final String SELECT_ALL =  "SELECT CLIENTE.*, ENDERECO.*, BIOMETRIA.*, CLIENTEALTERACOES.* FROM CLIENTE \n" +
"	LEFT JOIN ENDERECO \n" +
"	ON CLIENTE.ID = ENDERECO.Cliente_id \n" +
"	LEFT JOIN BIOMETRIA\n" +
"	ON CLIENTE.ID = BIOMETRIA.Cliente_id \n" +
"	LEFT JOIN AVALIACAO\n" +
"	ON CLIENTE.ID = AVALIACAO.Cliente_id\n" +
"	LEFT JOIN CLIENTEALTERACOES\n" +
"	ON CLIENTE.ID = CLIENTEALTERACOES.Cliente_id WHERE ID = ?";

    @Override
    public int insert(Cliente cliente) throws PersistenciaException {
        PreparedStatement insert = null;
        int id = -1;
        try {
            insert = FabricaConexao.obterConexao().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insert.setString(1, cliente.getNome());
            insert.setString(2, cliente.getCpf());
            insert.setString(3, cliente.getRg());
            insert.setDate(4, cliente.getDataNascimento());
            insert.setString(5, cliente.getEmail());
            insert.setString(6, cliente.getTelefone());
            insert.setString(7, cliente.getCelular());
            insert.executeUpdate();
            id = obterId(insert); // pega o id do cliente inserido
            cliente.setId(id); // O cliente veio sem o ID, agora que ele foi inserido eu já posso setar o id 
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao inserir Cliente");
        }
        return id;
    }

    @Override
    public void remove(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int edit(Cliente cliente) throws PersistenciaException {
        PreparedStatement update = null;
        try {
            update = FabricaConexao.obterConexao().prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            update.setString(1, cliente.getNome());
            update.setString(2, cliente.getCpf());
            update.setString(3, cliente.getRg());
            update.setDate(4, cliente.getDataNascimento());
            update.setString(5, cliente.getEmail());
            update.setString(6, cliente.getTelefone());
            update.setString(7, cliente.getCelular());
            update.setInt(8, cliente.getId());

            update.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao inserir Cliente");
        } 
        return cliente.getId();
    }

    @Override
    public List<Cliente> list() throws PersistenciaException {
        PreparedStatement select = null;
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT);
            ResultSet rs = select.executeQuery();            
            List<Cliente> clientes = new ArrayList<Cliente>();
            int id;
            String nome;
            String CPF;
            String RG;
            Date dataNascimento;
            String email;
            String telefone;
            String celular;
            while (rs.next()) {
                id = rs.getInt(1);
                nome = rs.getString(2);
                CPF = rs.getString(3);
                RG =  rs.getString(4);
                dataNascimento = rs.getDate(5);
                email = rs.getString(6);
                telefone = rs.getString(7);
                celular = rs.getString(8);
                clientes.add(new Cliente(id, nome, CPF, RG, dataNascimento, email, telefone, celular));
            }
            return clientes;
        }catch (Exception e) { 
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar os clientes");
        }
    }

    @Override
    public Cliente find(int id) throws PersistenciaException {
        PreparedStatement select = null;
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        Biometria biometria = new Biometria();
        Alteracoes alteracoes = new Alteracoes();
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT_ALL);
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();            
            while (rs.next()) {
                cliente.setId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setCpf(rs.getString(3));
                cliente.setRg(rs.getString(4));
                cliente.setDataNascimento(rs.getDate(5));
                cliente.setEmail(rs.getString(6));
                cliente.setTelefone(rs.getString(7));
                cliente.setCelular(rs.getString(8));
                endereco.setIdEndereco(rs.getInt(9));
                endereco.setFk_idCidade(rs.getInt(10));	
                endereco.setRua(rs.getString(11));
                endereco.setBairro(rs.getString(12));
                endereco.setCEP(rs.getString(13));
                endereco.setComplemento(rs.getString(14));
                endereco.setNumero(rs.getInt(15));
                endereco.setCliente_id(rs.getInt(16));               
            }
            cliente.setBiometria(biometria);
            cliente.setAlteracoes(alteracoes);
            cliente.setEndereco(endereco);
        }catch (Exception e) { 
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar os clientes");
        }   
        return cliente;
    }
}
