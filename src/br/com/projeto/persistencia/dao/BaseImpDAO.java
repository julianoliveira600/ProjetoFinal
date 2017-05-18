package br.com.projeto.persistencia.dao;


import br.com.projeto.persistencia.exception.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseImpDAO {

    public int obterId(PreparedStatement pstmt) throws SQLException {
        ResultSet rs = pstmt.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        } else {
            new PersistenciaException("Erro ao obter id");
            return -1;
        }
    }
}
