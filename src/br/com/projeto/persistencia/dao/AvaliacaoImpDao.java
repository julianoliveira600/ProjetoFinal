package br.com.projeto.persistencia.dao;

import br.com.projeto.negocio.entidades.Avaliacao;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class AvaliacaoImpDao extends BaseImpDAO implements BaseDAO<Avaliacao> {

    private static final String INSERT = "insert into Avaliacao(CorPele, AparenciaPele, SuperficiePele, LesoesPele, BiotipoCultaneo, Acne, Flacidez, Desidratacao, Milium, Copuperose, Telangiectasia, Efelidez, Xantelasma, Rugas,Rosacea, Seborreia, Foliculite,Cicatriz, VerrugasPintas, Acromia, Cloasma, Hipercromia, Hipocromia, Angioma, Eritema, Petequias, Cianose, Hematoma, Ceratose, Papulas, Comedao, Necrose, Nodulos, Bolhas, Pustulas, Vesicula, Crosta, Escara, Fisura, Ulceracao, Descamacao, Escoriacao, Fistula, Atrofia, Hipertricose, Hirsutismo, Eczema, Hiperqueratose, Psoriase, OleosidadePele, Espessura, Observacoes, Cliente_id)"
            + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public int insert(Avaliacao avaliacao) throws PersistenciaException {
        PreparedStatement insert = null;
        try {
            insert = FabricaConexao.obterConexao().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insert.setInt(1, avaliacao.getCorPele());
            insert.setInt(2, avaliacao.getAparenciaPele());
            insert.setInt(3, avaliacao.getSuperficiePele());
            insert.setInt(4, avaliacao.getLesoesPele());
            insert.setInt(5, avaliacao.getBiotipoCultaneo());
            insert.setInt(6, avaliacao.getAcne());
            insert.setInt(7, avaliacao.getFlacidez());
            insert.setInt(8, avaliacao.getDesidratacao());
            insert.setBoolean(9, false);
            insert.setBoolean(10, false);
            insert.setBoolean(11, false);
            insert.setBoolean(12, false);
            insert.setBoolean(13, false);
            insert.setBoolean(14, false);
            insert.setBoolean(14, false);
            insert.setBoolean(15, false);
            insert.setBoolean(16, false);
            insert.setBoolean(17, false);
            insert.setBoolean(18, false);
            insert.setBoolean(19, false);
            insert.setBoolean(20, false);
            insert.setBoolean(21, false);
            insert.setBoolean(22, false);
            insert.setBoolean(23, false);
            insert.setBoolean(24, false);
            insert.setBoolean(25, false);
            insert.setBoolean(26, false);
            insert.setBoolean(27, false);
            insert.setBoolean(28, false);
            insert.setBoolean(29, false);
            insert.setBoolean(30, false);
            insert.setBoolean(31, false);
            insert.setBoolean(32, false);
            insert.setBoolean(33, false);
            insert.setBoolean(34, false);
            insert.setBoolean(35, false);
            insert.setBoolean(36, false);
            insert.setBoolean(37, false);
            insert.setBoolean(38, false);
            insert.setBoolean(39, false);
            insert.setBoolean(40, false);
            insert.setBoolean(41, false);
            insert.setBoolean(42, false);
            insert.setBoolean(43, false);
            insert.setBoolean(44, false);
            insert.setBoolean(45, false);
            insert.setBoolean(46, false);
            insert.setBoolean(47, false);
            insert.setBoolean(48, false);
            insert.setBoolean(49, false);
            insert.setBoolean(50, false);
            insert.setBoolean(51, false);
            insert.setBoolean(52, false);
            insert.setInt(53, avaliacao.getCliente_id());
            insert.executeUpdate();
            return obterId(insert);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao inserir a Avaliacão");
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
    public int edit(Avaliacao entidade) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Avaliacao> list() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Avaliacao find(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
