
package projetofinal;

import br.com.projeto.controle.ClienteControle;
import br.com.projeto.negocio.entidades.Cliente;
import br.com.projeto.negocio.entidades.Endereco;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class ProjetoFinal {

    public static void main(String[] args) throws ParseException {
        TestCliente testCliente = new TestCliente();
        //testCliente.testInsert();
        testCliente.testUpdate();
    }  
}
