package br.com.projeto.persistencia.dao;

import br.com.projeto.negocio.entidades.Alteracoes;
import br.com.projeto.negocio.entidades.Cliente;
import br.com.projeto.negocio.entidades.Endereco;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AlteracoesImpDAO extends BaseImpDAO implements BaseDAO<Alteracoes> {

    private static final String INSERT = "insert into ClienteAlteracoes(Cardiaca, Vasculares, Reumaticas, Renais, Glandulares, Ginecologicas, Proteses, Bronquite, Alegias, Usadiu, PressaoMembros, Constipacao, TratamentoMedico, UsaMedicamentos, Gestante, Marcapasso, Eplepsia, Ancologia, ProtecaoPele, Diabetes, Observacoes, Cliente_id )"
            + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_CLIENTE = "select * from ClienteAlteracoes where Cliente_id = ?";
        private static final String UPDATE = "UPDATE CLIENTEALTERACOES SET Cardiaca = ?, Vasculares =?, Reumaticas=?, Renais=?, Glandulares=?, Ginecologicas=?, Proteses=?, Bronquite=?, Alegias=?, Usadiu=?, PressaoMembros=?, Constipacao=?, TratamentoMedico=?, UsaMedicamentos=?, Gestante=?, Marcapasso=?, Eplepsia=?, Ancologia=?, ProtecaoPele=?, Diabetes=? where Cliente_id = ?";
    private static final String SELECT = "SELECT * FROM CLIENTEALTERACOES";
    private static final String SELECT_ALL = "";

    @Override
    public int insert(Alteracoes alteracoes) throws PersistenciaException {
        PreparedStatement insert = null;
        try {
            insert = FabricaConexao.obterConexao().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insert.setBoolean(1, alteracoes.isCardiaca());
            insert.setBoolean(2, alteracoes.isVasculares());
            insert.setBoolean(3, alteracoes.isReumaticas());
            insert.setBoolean(4, alteracoes.isRenais());
            insert.setBoolean(5, alteracoes.isGlandulares());
            insert.setBoolean(6, alteracoes.isGinecologicas());
            insert.setBoolean(7, alteracoes.isProteses());
            insert.setBoolean(8, alteracoes.isBronquite());
            insert.setBoolean(9, alteracoes.isAlergias());
            insert.setBoolean(10, alteracoes.isUsadiu());
            insert.setBoolean(11, alteracoes.isPressaoMembros());
            insert.setBoolean(12, alteracoes.isConstipacao());
            insert.setBoolean(13, alteracoes.isTratamentoMedico());
            insert.setBoolean(14, alteracoes.isUsaMedicamentos());
            insert.setBoolean(15, alteracoes.isGestante());
            insert.setBoolean(16, alteracoes.isMarcapasso());
            insert.setBoolean(17, alteracoes.isEplepsia());
            insert.setBoolean(18, alteracoes.isAncologia());
            insert.setBoolean(19, alteracoes.isProtecaoPele());
            insert.setBoolean(20, alteracoes.isDiabetes());
            insert.setString(21, alteracoes.getObservacoes());
            insert.setInt(22, alteracoes.getCliente_id());
            insert.executeUpdate();
            return obterId(insert);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao inserir Alterações");
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
    public int edit(Alteracoes entidade) throws PersistenciaException {
        PreparedStatement update = null;
        try {
            update = FabricaConexao.obterConexao().prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            update.setBoolean(1, entidade.isCardiaca());
            update.setBoolean(2, entidade.isVasculares());
            update.setBoolean(3, entidade.isReumaticas());
            update.setBoolean(4, entidade.isRenais());
            update.setBoolean(5, entidade.isGlandulares());
            update.setBoolean(6, entidade.isGinecologicas());
            update.setBoolean(7, entidade.isProteses());
            update.setBoolean(8, entidade.isBronquite());
            update.setBoolean(9, entidade.isAlergias());
            update.setBoolean(10, entidade.isUsadiu());
            update.setBoolean(11, entidade.isPressaoMembros());
            update.setBoolean(13, entidade.isConstipacao());
            update.setBoolean(13, entidade.isTratamentoMedico());
            update.setBoolean(15, entidade.isUsaMedicamentos());
            update.setBoolean(15, entidade.isGestante());
            update.setBoolean(17, entidade.isMarcapasso());
            update.setBoolean(17, entidade.isEplepsia());
            update.setBoolean(19, entidade.isAncologia());
            update.setBoolean(19, entidade.isProtecaoPele());
            update.setBoolean(20, entidade.isDiabetes());
            update.setString(21, entidade.getObservacoes());
            update.setInt(23, entidade.getCliente_id());

            update.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao inserir alterações");
        }
        return entidade.getCliente_id();
    }

    @Override
    public List<Alteracoes> list() throws PersistenciaException {
        PreparedStatement select = null;
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT);
            ResultSet rs = select.executeQuery();
            List<Alteracoes> alteracoes = new ArrayList<Alteracoes>();
            int idClienteAlteracoes;
            boolean Cardiaca;
            boolean Vasculares;
            boolean Reumaticas;
            boolean Renais;
            boolean Glandulares;
            boolean Ginecologicas;
            boolean Proteses;
            boolean Bronquite;
            boolean Alergias;
            boolean Usadiu;
            boolean PressaoMembros;
            boolean Constipacao;
            boolean TratamentoMedico;
            boolean UsaMedicamentos;
            boolean Gestante;
            boolean Marcapasso;
            boolean Eplepsia;
            boolean Ancologia;
            boolean ProtecaoPele;
            boolean Diabetes;
            String Observacoes;
            int Cliente_id;
            while (rs.next()) {
                idClienteAlteracoes = rs.getInt(1);
                Cardiaca = rs.getBoolean(2);
                Vasculares = rs.getBoolean(3);
                Reumaticas = rs.getBoolean(4);
                Renais = rs.getBoolean(5);
                Glandulares = rs.getBoolean(6);
                Ginecologicas = rs.getBoolean(7);
                Proteses = rs.getBoolean(8);
                Bronquite = rs.getBoolean(9);
                Alergias = rs.getBoolean(10);
                Usadiu = rs.getBoolean(11);
                PressaoMembros = rs.getBoolean(12);
                Constipacao = rs.getBoolean(13);
                TratamentoMedico = rs.getBoolean(14);
                UsaMedicamentos = rs.getBoolean(15);
                Gestante = rs.getBoolean(16);
                Marcapasso = rs.getBoolean(17);
                Eplepsia = rs.getBoolean(18);
                Ancologia = rs.getBoolean(19);
                ProtecaoPele = rs.getBoolean(20);
                Diabetes = rs.getBoolean(21);
                Observacoes = rs.getString(22);
                Cliente_id = rs.getInt(rs.getInt(23));
            }
            return alteracoes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar alteracoes");
        }
    }

    @Override
    public Alteracoes find(int id) throws PersistenciaException {
        PreparedStatement select = null;
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        Alteracoes alteracoes = new Alteracoes();
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT_ALL);
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();
            while (rs.next()) {
                alteracoes.setIdClienteAlteracoes(rs.getInt(1));
                alteracoes.setCardiaca(rs.getBoolean(2));
                alteracoes.setVasculares(rs.getBoolean(3));
                alteracoes.setReumaticas(rs.getBoolean(4));
                alteracoes.setRenais(rs.getBoolean(5));
                alteracoes.setGlandulares(rs.getBoolean(6));
                alteracoes.setGinecologicas(rs.getBoolean(7));
                alteracoes.setProteses(rs.getBoolean(8));
                alteracoes.setBronquite(rs.getBoolean(9));
                alteracoes.setAlergias(rs.getBoolean(10));
                alteracoes.setUsadiu(rs.getBoolean(11));
                alteracoes.setPressaoMembros(rs.getBoolean(12));
                alteracoes.setConstipacao(rs.getBoolean(13));
                alteracoes.setTratamentoMedico(rs.getBoolean(14));
                alteracoes.setUsaMedicamentos(rs.getBoolean(15));
                alteracoes.setGestante(rs.getBoolean(16));
                alteracoes.setMarcapasso(rs.getBoolean(17));
                alteracoes.setEplepsia(rs.getBoolean(18));
                alteracoes.setAncologia(rs.getBoolean(19));
                alteracoes.setProtecaoPele(rs.getBoolean(20));
                alteracoes.setDiabetes(rs.getBoolean(21));
                alteracoes.setObservacoes(rs.getString(22));
                alteracoes.setCliente_id(rs.getInt(23));
            }
            cliente.setAlteracoes(alteracoes);

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar alteracoes");
        }
        return alteracoes;

    }

    public Alteracoes findByCliente(int idCliente) throws PersistenciaException {

        PreparedStatement select = null;
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT_CLIENTE);
            select.setInt(1, idCliente);
            ResultSet rs = select.executeQuery();
            Alteracoes alteracoes = new Alteracoes();
            while (rs.next()) {
                alteracoes.setCardiaca(rs.getBoolean(1));
                alteracoes.setVasculares(rs.getBoolean(2));
                alteracoes.setReumaticas(rs.getBoolean(3));
                alteracoes.setRenais(rs.getBoolean(4));
                alteracoes.setGlandulares(rs.getBoolean(5));
                alteracoes.setGinecologicas(rs.getBoolean(6));
                alteracoes.setProteses(rs.getBoolean(7));
                alteracoes.setBronquite(rs.getBoolean(8));
                alteracoes.setAlergias(rs.getBoolean(9));
                alteracoes.setUsadiu(rs.getBoolean(10));
                alteracoes.setPressaoMembros(rs.getBoolean(11));
                alteracoes.setConstipacao(rs.getBoolean(12));
                alteracoes.setTratamentoMedico(rs.getBoolean(13));
                alteracoes.setUsaMedicamentos(rs.getBoolean(14));
                alteracoes.setGestante(rs.getBoolean(15));
                alteracoes.setMarcapasso(rs.getBoolean(16));
                alteracoes.setEplepsia(rs.getBoolean(17));
                alteracoes.setAncologia(rs.getBoolean(18));
                alteracoes.setProtecaoPele(rs.getBoolean(19));
                alteracoes.setDiabetes(rs.getBoolean(20));
                alteracoes.setObservacoes(rs.getString(21));
                alteracoes.setCliente_id(rs.getInt(idCliente));
            }
            return alteracoes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar Alterações");
        }

    }

}
