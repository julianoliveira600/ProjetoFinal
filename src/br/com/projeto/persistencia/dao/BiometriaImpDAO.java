package br.com.projeto.persistencia.dao;

import br.com.projeto.negocio.entidades.Biometria;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class BiometriaImpDAO extends BaseImpDAO implements BaseDAO<Biometria> {

    private static final String INSERT = "insert into Biometria(Bracodir, Bracoesq, Busto, Quadril, Pernadir, Pernaesq, Cintura, Abdomem, Culote, Coxadir, Coxaesq, Celulite, Graucelulite, Gorduraloc, Localgorduraloc, Ptose, Localptose, Vibices, Localvibices, Cliente_id) "
            + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public int insert(Biometria biometria) throws PersistenciaException {
        PreparedStatement insert = null;
        try {
            insert = FabricaConexao.obterConexao().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insert.setFloat(1, biometria.getBracodir());
            insert.setFloat(2, biometria.getBracoesq());
            insert.setFloat(3, biometria.getBusto());
            insert.setFloat(4, biometria.getQuadril());
            insert.setFloat(5, biometria.getPernadir());
            insert.setFloat(6, biometria.getPernaesq());
            insert.setFloat(7, biometria.getCintura());
            insert.setFloat(8, biometria.getAbdomem());
            insert.setFloat(9, biometria.getCulote());
            insert.setFloat(10, biometria.getCoxaDir());
            insert.setFloat(11, biometria.getCoxaesq());
            insert.setBoolean(12, false); // verificar este boolean
            insert.setInt(13, biometria.getGraucelulite());
            insert.setBoolean(14, false); // verificar este boolean
            insert.setString(15, biometria.getLocalgorduraloc());
            insert.setBoolean(17, false); // verificar
            insert.setString(18, biometria.getLocalptose());
            insert.setBoolean(19, false);
            insert.setString(20, biometria.getLocalvibices());
            insert.setInt(21, biometria.getCliente_id());
            insert.executeUpdate();
            return obterId(insert);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao inserir Biometria");
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
    public int edit(Biometria entidade) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Biometria> list() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
