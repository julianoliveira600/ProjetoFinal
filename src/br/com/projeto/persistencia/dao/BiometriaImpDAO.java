package br.com.projeto.persistencia.dao;

import br.com.projeto.negocio.entidades.Biometria;
import br.com.projeto.negocio.entidades.Cliente;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BiometriaImpDAO extends BaseImpDAO implements BaseDAO<Biometria> {

    private static final String INSERT = "insert into Biometria(Bracodir, Bracoesq, Busto, Quadril, Pernadir, Pernaesq, Cintura, Abdomem, Culote, Coxadir, Coxaesq, Celulite, Graucelulite, Gorduraloc, Localgorduraloc, Ptose, Localptose, Vibices, Localvibices, Cliente_id) "
            + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "update Biometria set Bracodir = ?, Bracoesq =?, Busto = ?, Quadril = ?, pernadir = ?, Pernaesq = ?, Cintura = ?, Abdomem = ?, Culote = ?, Coxadir = ?, coxaesq = ?, Celulite = ?, Graucelulite = ?, Gorduraloc = ?, Localgorduraloc = ?, Ptose = ?, Localptose = ?, Vibices= ?, Localvibices = ?, Cliente_id = ? where idBiometria = ?";
    private static final String SELECT = "select * from Biometria";
    private static final String SELECT_ALL = "";

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
            insert.setBoolean(12, biometria.isCelulite()); // verificar este boolean
            insert.setInt(13, biometria.getGraucelulite());
            insert.setBoolean(14, biometria.isGorduraloc()); // verificar este boolean
            insert.setString(15, biometria.getLocalgorduraloc());
            insert.setBoolean(16, biometria.isPtose()); // verificar
            insert.setString(17, biometria.getLocalptose());
            insert.setBoolean(18, biometria.isVibices());
            insert.setString(19, biometria.getLocalvibices());
            insert.setInt(20, biometria.getCliente_id());
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
        PreparedStatement update = null;
        try {
            update = FabricaConexao.obterConexao().prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            update.setFloat(1, entidade.getBracodir());
            update.setFloat(2, entidade.getBracoesq());
            update.setFloat(3, entidade.getBusto());
            update.setFloat(4, entidade.getQuadril());
            update.setFloat(5, entidade.getPernadir());
            update.setFloat(6, entidade.getPernaesq());
            update.setFloat(7, entidade.getCintura());
            update.setFloat(8, entidade.getAbdomem());
            update.setFloat(9, entidade.getCulote());
            update.setFloat(10, entidade.getCoxaDir());
            update.setFloat(11, entidade.getCoxaesq());
            update.setBoolean(12, entidade.isCelulite());
            update.setInt(13, entidade.getGraucelulite());
            update.setBoolean(14, entidade.isGorduraloc());
            update.setString(15, entidade.getLocalgorduraloc());
            update.setBoolean(16, entidade.isPtose());
            update.setString(17, entidade.getLocalptose());
            update.setBoolean(18, entidade.isVibices());
            update.setString(19, entidade.getLocalvibices());
            update.setInt(20, entidade.getCliente_id());

            update.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro em atualizar Biometria");
        }
        return entidade.getCliente_id();
    }

    @Override
    public List<Biometria> list() throws PersistenciaException {
        PreparedStatement select = null;
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT);
            ResultSet rs = select.executeQuery();
            List<Biometria> biometria = new ArrayList<Biometria>();
            int idBiometria;
            float Bracodir;
            float Bracoesq;
            float Busto;
            float Quadril;
            float Pernadir;
            float Pernaesq;
            float Cintura;
            float Abdomem;
            float Culote;
            float CoxaDir;
            float Coxaesq;
            boolean Celulite;
            int Graucelulite;
            boolean Gorduraloc;
            String Localgorduraloc;
            boolean Ptose;
            String Localptose;
            boolean Vibices;
            String Localvibices;
            int Cliente_id;

            while (rs.next()) {
                idBiometria = rs.getInt(1);
                Bracodir = rs.getFloat(2);
                Bracoesq = rs.getFloat(3);
                Busto = rs.getFloat(4);
                Quadril = rs.getFloat(5);
                Pernadir = rs.getFloat(6);
                Pernaesq = rs.getFloat(7);
                Cintura = rs.getFloat(8);
                Abdomem = rs.getFloat(9);
                Culote = rs.getFloat(10);
                CoxaDir = rs.getFloat(11);
                Coxaesq = rs.getFloat(12);
                Celulite = rs.getBoolean(13);
                Graucelulite = rs.getInt(14);
                Gorduraloc = rs.getBoolean(15);
                Localgorduraloc = rs.getString(16);
                Ptose = rs.getBoolean(17);
                Localptose = rs.getString(18);
                Vibices = rs.getBoolean(19);
                Localvibices = rs.getString(20);
                Cliente_id = rs.getInt(21);

            }
            return biometria;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar biometria");
        }
    }

    @Override
    public Biometria find(int id) throws PersistenciaException {
        PreparedStatement select = null;
        Cliente cliente = new Cliente();
        Biometria biometria = new Biometria();
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT_ALL);
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();
            while (rs.next()) {
                biometria.setIdBiometria(rs.getInt(1));
                biometria.setBracodir(rs.getFloat(2));
                biometria.setBracoesq(rs.getFloat(3));
                biometria.setBusto(rs.getFloat(4));
                biometria.setQuadril(rs.getFloat(5));
                biometria.setPernadir(rs.getFloat(6));
                biometria.setPernaesq(rs.getFloat(7));
                biometria.setCintura(rs.getFloat(8));
                biometria.setAbdomem(rs.getFloat(9));
                biometria.setCulote(rs.getFloat(10));
                biometria.setCoxaDir(rs.getFloat(11));
                biometria.setCoxaesq(rs.getFloat(12));
                biometria.setCelulite(rs.getBoolean(13));
                biometria.setGraucelulite(rs.getInt(14));
                biometria.setGorduraloc(rs.getBoolean(16));
                biometria.setLocalgorduraloc(rs.getString(17));
                biometria.setPtose(rs.getBoolean(18));
                biometria.setLocalptose(rs.getString(19));
                biometria.setVibices(rs.getBoolean(20));
                biometria.setLocalvibices(rs.getString(21));
                biometria.setCliente_id(rs.getInt(id));
            }
            cliente.setBiometria(biometria);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar biometria");
        }
        return biometria;
    }

}
