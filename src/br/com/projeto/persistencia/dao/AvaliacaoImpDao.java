package br.com.projeto.persistencia.dao;

import br.com.projeto.negocio.entidades.Avaliacao;
import br.com.projeto.negocio.entidades.Cliente;
import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoImpDao extends BaseImpDAO implements BaseDAO<Avaliacao> {

    private static final String INSERT = "insert into Avaliacao(CorPele, AparenciaPele, SuperficiePele, LesoePele, BiotipoCultaneo, Acne, Flacidez, Desidratacao, Milium, Copuperose, Telangiectasia, Efelidez, Xantelasma, Rugas,Rosacea, Seborreia, Foliculite,Cicatriz, VerrugasPintas, Acromia, Cloasma, Hipercromia, Hipocromia, Angioma, Eritema, Petequias, Cianose, Hematoma, Ceratose, Papulas, Comedao, Necrose, Nodulos, Bolhas, Pustulas, Vesicula, Crosta, Escara, Fisura, Ulceracao, Descamacao, Escoriacao, Fistula, Atrofia, Hipertricose, Hirsutismo, Eczema, Hiperqueratose, Psoriase, OleosidadePele, Espessura, Observacoes, Cliente_id)"
            + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "update Avaliacao set CorPele =?, AparenciaPele=?, SuperficiePele=?, LesoePele=?, BiotipoCultaneo=?, Acne=?, Flacidez=?, Desidratacao=?, Milium=?, Copuperose=?, Telangiectasia=?, Efelidez=?, Xantelasma=?, Rugas=?,Rosacea=?, Seborreia=?, Foliculite=?,Cicatriz=?, VerrugasPintas=?, Acromia=?, Cloasma=?, Hipercromia=?, Hipocromia=?, Angioma=?, Eritema=?, Petequias=?, Cianose=?, Hematoma=?, Ceratose=?, Papulas=?, Comedao=?, Necrose=?, Nodulos=?, Bolhas=?, Pustulas=?, Vesicula=?, Crosta=?, Escara=?, Fisura=?, Ulceracao=?, Descamacao=?, Escoriacao=?, Fistula=?, Atrofia=?, Hipertricose=?, Hirsutismo=?, Eczema=?, Hiperqueratose=?, Psoriase=?, OleosidadePele=?, Espessura=?, Observacoes=?, Cliente_id =?";
    private static final String SELECT = "SELECT * FROM Avaliacao";
    private static final String SELECT_ALL = "";

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
            insert.setBoolean(9, avaliacao.isMiliun());
            insert.setBoolean(10, avaliacao.isCopuperose());
            insert.setBoolean(11, avaliacao.isTelangiectasia());
            insert.setBoolean(12, avaliacao.isEfelidez());
            insert.setBoolean(13, avaliacao.isXantelasma());
            insert.setBoolean(14, avaliacao.isRugas());
            insert.setBoolean(15, avaliacao.isRosacea());
            insert.setBoolean(16, avaliacao.isSeborreia());
            insert.setBoolean(17, avaliacao.isFoliculite());
            insert.setBoolean(18, avaliacao.isCicatriz());
            insert.setBoolean(19, avaliacao.isVerrugasPintas());
            insert.setBoolean(20, avaliacao.isAcromia());
            insert.setBoolean(21, avaliacao.isCloasma());
            insert.setBoolean(22, avaliacao.isHipercromia());
            insert.setBoolean(23, avaliacao.isHipocromia());
            insert.setBoolean(24, avaliacao.isAngioma());
            insert.setBoolean(25, avaliacao.isEritema());
            insert.setBoolean(26, avaliacao.isPetequias());
            insert.setBoolean(27, avaliacao.isCianose());
            insert.setBoolean(28, avaliacao.isHematoma());
            insert.setBoolean(29, avaliacao.isCeratose());
            insert.setBoolean(30, avaliacao.isPapulas());
            insert.setBoolean(31, avaliacao.isComedao());
            insert.setBoolean(32, avaliacao.isNecrose());
            insert.setBoolean(33, avaliacao.isNodulos());
            insert.setBoolean(34, avaliacao.isBolhas());
            insert.setBoolean(35, avaliacao.isPustulas());
            insert.setBoolean(36, avaliacao.isVesicula());
            insert.setBoolean(37, avaliacao.isCrosta());
            insert.setBoolean(38, avaliacao.isEscara());
            insert.setBoolean(39, avaliacao.isFisura());
            insert.setBoolean(40, avaliacao.isUlceracao());
            insert.setBoolean(41, avaliacao.isDescamacao());
            insert.setBoolean(42, avaliacao.isEscoriacao());
            insert.setBoolean(43, avaliacao.isFistula());
            insert.setBoolean(44, avaliacao.isAtrofia());
            insert.setBoolean(45, avaliacao.isHipertricose());
            insert.setBoolean(46, avaliacao.isHirsutismo());
            insert.setBoolean(47, avaliacao.isEczema());
            insert.setBoolean(48, avaliacao.isHiperqueratose());
            insert.setBoolean(49, avaliacao.isPsoariase());
            insert.setInt(50, avaliacao.getOleosidadePele());
            insert.setInt(51, avaliacao.getEspessura());
            insert.setString(52, avaliacao.getObservacoes());
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
        PreparedStatement update = null;
        try {
            update = FabricaConexao.obterConexao().prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            update.setInt(1, entidade.getCorPele());
            update.setInt(2, entidade.getAparenciaPele());
            update.setInt(3, entidade.getSuperficiePele());
            update.setInt(4, entidade.getLesoesPele());
            update.setInt(5, entidade.getBiotipoCultaneo());
            update.setInt(6, entidade.getAcne());
            update.setInt(7, entidade.getFlacidez());
            update.setInt(8, entidade.getDesidratacao());
            update.setBoolean(9, entidade.isMiliun());
            update.setBoolean(10, entidade.isCopuperose());
            update.setBoolean(11, entidade.isTelangiectasia());
            update.setBoolean(12, entidade.isEfelidez());
            update.setBoolean(13, entidade.isXantelasma());
            update.setBoolean(14, entidade.isRugas());
            update.setBoolean(15, entidade.isRosacea());
            update.setBoolean(16, entidade.isSeborreia());
            update.setBoolean(17, entidade.isFoliculite());
            update.setBoolean(18, entidade.isCicatriz());
            update.setBoolean(19, entidade.isVerrugasPintas());
            update.setBoolean(20, entidade.isAcromia());
            update.setBoolean(21, entidade.isCloasma());
            update.setBoolean(22, entidade.isHipercromia());
            update.setBoolean(23, entidade.isHipocromia());
            update.setBoolean(24, entidade.isAngioma());
            update.setBoolean(25, entidade.isEritema());
            update.setBoolean(26, entidade.isPetequias());
            update.setBoolean(27, entidade.isCianose());
            update.setBoolean(28, entidade.isHematoma());
            update.setBoolean(29, entidade.isCeratose());
            update.setBoolean(30, entidade.isPapulas());
            update.setBoolean(31, entidade.isComedao());
            update.setBoolean(32, entidade.isNecrose());
            update.setBoolean(33, entidade.isNodulos());
            update.setBoolean(34, entidade.isBolhas());
            update.setBoolean(35, entidade.isPustulas());
            update.setBoolean(36, entidade.isVesicula());
            update.setBoolean(37, entidade.isCrosta());
            update.setBoolean(38, entidade.isEscara());
            update.setBoolean(39, entidade.isFisura());
            update.setBoolean(40, entidade.isUlceracao());
            update.setBoolean(41, entidade.isDescamacao());
            update.setBoolean(42, entidade.isEscoriacao());
            update.setBoolean(43, entidade.isFistula());
            update.setBoolean(44, entidade.isAtrofia());
            update.setBoolean(45, entidade.isHipertricose());
            update.setBoolean(46, entidade.isHirsutismo());
            update.setBoolean(47, entidade.isEczema());
            update.setBoolean(48, entidade.isHiperqueratose());
            update.setBoolean(49, entidade.isPsoariase());
            update.setInt(50, entidade.getOleosidadePele());
            update.setInt(51, entidade.getEspessura());
            update.setString(52, entidade.getObservacoes());
            update.setInt(53, entidade.getCliente_id());

            update.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao atualizar avaliação");
        }
        return entidade.getCliente_id();
    }

    @Override
    public List<Avaliacao> list() throws PersistenciaException {
        PreparedStatement select = null;
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT);
            ResultSet rs = select.executeQuery();
            List<Avaliacao> avaliacao = new ArrayList<Avaliacao>();
            int idAvaliacao;
            int CorPele;
            int AparenciaPele;
            int SuperficiePele;
            int LesoesPele;
            int BiotipoCultaneo;
            int Acne;
            int Flacidez;
            int Desidratacao;
            boolean Miliun;
            boolean Copuperose;
            boolean Telangiectasia;
            boolean Efelidez;
            boolean Xantelasma;
            boolean Rugas;
            boolean Rosacea;
            boolean Seborreia;
            boolean Foliculite;
            boolean Cicatriz;
            boolean VerrugasPintas;
            boolean Acromia;
            boolean Cloasma;
            boolean Hipercromia;
            boolean Hipocromia;
            boolean Angioma;
            boolean Eritema;
            boolean Petequias;
            boolean Cianose;
            boolean Hematoma;
            boolean Ceratose;
            boolean Papulas;
            boolean Comedao;
            boolean Necrose;
            boolean Nodulos;
            boolean Bolhas;
            boolean Pustulas;
            boolean Vesicula;
            boolean Crosta;
            boolean Escara;
            boolean Fisura;
            boolean Ulceracao;
            boolean Descamacao;
            boolean Escoriacao;
            boolean Fistula;
            boolean Atrofia;
            boolean hipertricose;
            boolean Hirsutismo;
            boolean Eczema;
            boolean hiperqueratose;
            boolean Psoariase;
            int OleosidadePele;
            int Espessura;
            String Observacoes;
            int Cliente_id;
            while (rs.next()) {
                idAvaliacao = rs.getInt(1);
                CorPele = rs.getInt(2);
                AparenciaPele = rs.getInt(3);
                SuperficiePele = rs.getInt(4);
                LesoesPele = rs.getInt(5);
                BiotipoCultaneo = rs.getInt(6);
                Acne = rs.getInt(7);
                Flacidez = rs.getInt(8);
                Desidratacao = rs.getInt(9);
                Miliun = rs.getBoolean(10);
                Copuperose = rs.getBoolean(11);
                Telangiectasia = rs.getBoolean(12);
                Efelidez = rs.getBoolean(13);
                Xantelasma = rs.getBoolean(14);
                Rugas = rs.getBoolean(15);
                Rosacea = rs.getBoolean(16);
                Seborreia = rs.getBoolean(17);
                Foliculite = rs.getBoolean(18);
                Cicatriz = rs.getBoolean(19);
                VerrugasPintas = rs.getBoolean(20);
                Acromia = rs.getBoolean(21);
                Cloasma = rs.getBoolean(22);
                Hipercromia = rs.getBoolean(23);
                Hipocromia = rs.getBoolean(24);
                Angioma = rs.getBoolean(25);
                Eritema = rs.getBoolean(26);
                Petequias = rs.getBoolean(27);
                Cianose = rs.getBoolean(28);
                Hematoma = rs.getBoolean(29);
                Ceratose = rs.getBoolean(30);
                Papulas = rs.getBoolean(31);
                Comedao = rs.getBoolean(32);
                Necrose = rs.getBoolean(33);
                Nodulos = rs.getBoolean(34);
                Bolhas = rs.getBoolean(35);
                Pustulas = rs.getBoolean(36);
                Vesicula = rs.getBoolean(37);
                Crosta = rs.getBoolean(38);
                Escara = rs.getBoolean(39);
                Fisura = rs.getBoolean(40);
                Ulceracao = rs.getBoolean(41);
                Descamacao = rs.getBoolean(42);
                Escoriacao = rs.getBoolean(43);
                Fistula = rs.getBoolean(44);
                Atrofia = rs.getBoolean(45);
                hipertricose = rs.getBoolean(46);
                Hirsutismo = rs.getBoolean(47);
                Eczema = rs.getBoolean(48);
                hiperqueratose = rs.getBoolean(49);
                Psoariase = rs.getBoolean(50);
                OleosidadePele = rs.getInt(51);
                Espessura = rs.getInt(52);
                Observacoes = rs.getString(53);
                Cliente_id = rs.getInt(54);
            }
            return avaliacao;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar Avaliacão");
        }

    }

    @Override
    public Avaliacao find(int id) throws PersistenciaException {
        PreparedStatement select = null;
        Cliente cliente = new Cliente();
        Avaliacao avaliacao = new Avaliacao();
        try {
            select = FabricaConexao.obterConexao().prepareStatement(SELECT_ALL, Statement.RETURN_GENERATED_KEYS);
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();
            while (rs.next()) {
                avaliacao.setIdAvaliacao(rs.getInt(1));
                avaliacao.setCorPele(rs.getInt(2));
                avaliacao.setAparenciaPele(rs.getInt(3));
                avaliacao.setSuperficiePele(rs.getInt(4));
                avaliacao.setLesoesPele(rs.getInt(5));
                avaliacao.setBiotipoCultaneo(rs.getInt(6));
                avaliacao.setAcne(rs.getInt(rs.getInt(7)));
                avaliacao.setFlacidez(rs.getInt(rs.getInt(8)));
                avaliacao.setDesidratacao(rs.getInt(9));
                avaliacao.setMiliun(rs.getBoolean(10));
                avaliacao.setCopuperose(rs.getBoolean(11));
                avaliacao.setTelangiectasia(rs.getBoolean(12));
                avaliacao.setEfelidez(rs.getBoolean(13));
                avaliacao.setXantelasma(rs.getBoolean(14));
                avaliacao.setRugas(rs.getBoolean(15));
                avaliacao.setRosacea(rs.getBoolean(16));
                avaliacao.setSeborreia(rs.getBoolean(17));
                avaliacao.setFoliculite(rs.getBoolean(18));
                avaliacao.setCicatriz(rs.getBoolean(19));
                avaliacao.setVerrugasPintas(rs.getBoolean(20));
                avaliacao.setAcromia(rs.getBoolean(21));
                avaliacao.setCloasma(rs.getBoolean(22));
                avaliacao.setHipercromia(rs.getBoolean(23));
                avaliacao.setHipocromia(rs.getBoolean(24));
                avaliacao.setAngioma(rs.getBoolean(25));
                avaliacao.setEritema(rs.getBoolean(26));
                avaliacao.setPetequias(rs.getBoolean(27));
                avaliacao.setCianose(rs.getBoolean(28));
                avaliacao.setHematoma(rs.getBoolean(29));
                avaliacao.setCeratose(rs.getBoolean(30));
                avaliacao.setPapulas(rs.getBoolean(31));
                avaliacao.setComedao(rs.getBoolean(32));
                avaliacao.setNecrose(rs.getBoolean(33));
                avaliacao.setNodulos(rs.getBoolean(34));
                avaliacao.setBolhas(rs.getBoolean(35));
                avaliacao.setPustulas(rs.getBoolean(36));
                avaliacao.setVesicula(rs.getBoolean(37));
                avaliacao.setCrosta(rs.getBoolean(38));
                avaliacao.setEscara(rs.getBoolean(39));
                avaliacao.setFisura(rs.getBoolean(40));
                avaliacao.setUlceracao(rs.getBoolean(41));
                avaliacao.setDescamacao(rs.getBoolean(42));
                avaliacao.setEscoriacao(rs.getBoolean(43));
                avaliacao.setFistula(rs.getBoolean(44));
                avaliacao.setAtrofia(rs.getBoolean(45));
                avaliacao.setHipertricose(rs.getBoolean(46));
                avaliacao.setHirsutismo(rs.getBoolean(47));
                avaliacao.setEczema(rs.getBoolean(48));
                avaliacao.setHiperqueratose(rs.getBoolean(49));
                avaliacao.setPsoariase(rs.getBoolean(50));
                avaliacao.setOleosidadePele(rs.getInt(52));
                avaliacao.setEspessura(rs.getInt(53));
                avaliacao.setObservacoes(rs.getString(54));
                avaliacao.setCliente_id(rs.getInt(55));

            }
            cliente.setAvaliacao(avaliacao);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Erro ao carregar avaliação");
        }
        return avaliacao;
    }

}
