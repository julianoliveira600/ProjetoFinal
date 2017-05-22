package br.com.projeto.persistencia.dao;

import br.com.projeto.negocio.entidades.Alteracoes;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlteracoesImpDAO extends BaseImpDAO implements BaseDAO<Alteracoes> {

    private static final String INSERT = "insert into ClienteAlteracoes(Cardiaca, Vasculares, Reumaticas, Renais, Glandulares, Ginecologicas, Proteses, Bronquite, Alegias, Usadiu, PressaoMembros, Constipacao, TratamentoMedico, UsaMedicamentos, Gestante, Marcapasso, Eplepsia, Ancologia, ProtecaoPele, Diabetes, Observacoes, Cliente_id )"
            + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public int insert(Alteracoes alteracoes) throws PersistenciaException {
        PreparedStatement insert = null;
        try {
            insert = FabricaConexao.obterConexao().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insert.setByte(1, (byte)0);
            insert.setByte(2, (byte)0);
            insert.setByte(3, (byte)0);
            insert.setByte(4, (byte)0);
            insert.setByte(5, (byte)0);
            insert.setByte(6, (byte)0);
            insert.setByte(7, (byte)0);
            insert.setByte(8, (byte)0);
            insert.setByte(9, (byte)0);
            insert.setByte(10, (byte)0);
            insert.setByte(11, (byte)0);
            insert.setByte(12, (byte)0);
            insert.setByte(13, (byte)0);
            insert.setByte(14, (byte)0);
            insert.setByte(15, (byte)0);
            insert.setByte(16, (byte)0);
            insert.setByte(17, (byte)0);
            insert.setByte(18, (byte)0);
            insert.setByte(19, (byte)0);
            insert.setByte(20, (byte)0);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alteracoes> list() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alteracoes find(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
