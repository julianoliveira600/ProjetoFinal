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

    private static final String INSERT = "insert into Alteracoes(Cardiaca, Vasculares, Reumaticas, Renais, Glandulares, Ginecologicas, Proteses, Bronquite, Alergias, Usadiu, PressaoMembros, Constipacao, TratamentoMedico, UsaMedicamentos, Gestante, Marcapasso, Eplepsia, Ancologia, ProtecaoPele, Diabetes, Observacoes, Cliente_id )"
            + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public int insert(Alteracoes alteracoes) throws PersistenciaException {
        PreparedStatement insert = null;
        try {
            insert = FabricaConexao.obterConexao().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insert.setBoolean(1, false);
            insert.setBoolean(2, false);
            insert.setBoolean(3, false);
            insert.setBoolean(4, false);
            insert.setBoolean(5, false);
            insert.setBoolean(6, false);
            insert.setBoolean(7, false);
            insert.setBoolean(8, false);
            insert.setBoolean(9, false);
            insert.setBoolean(10, false);
            insert.setBoolean(11, false);
            insert.setBoolean(12, false);
            insert.setBoolean(13, false);
            insert.setBoolean(14, false);
            insert.setBoolean(15, false);
            insert.setBoolean(16, false);
            insert.setBoolean(17, false);
            insert.setBoolean(18, false);
            insert.setBoolean(19, false);
            insert.setBoolean(20, false);
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

}
