package br.com.projeto.persistencia.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

    private static Connection conexao;

    public static Connection obterConexao() {

        if (conexao != null) {
            return conexao;
        } else {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexao = DriverManager.getConnection(Parametros.BASE_SGBD, Parametros.USUARIO,
                        Parametros.SENHA);
                System.out.println("Conexão estabelecida com sucesso");
                return conexao;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Erro na comunicação");
            }
        }

    }

}
