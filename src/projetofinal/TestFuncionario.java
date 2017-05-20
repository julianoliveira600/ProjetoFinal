
package projetofinal;

import br.com.projeto.controle.FuncionarioControle;
import br.com.projeto.negocio.entidades.Endereco;
import br.com.projeto.negocio.entidades.Funcionario;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class TestFuncionario {
    public void testInsert() {
        FuncionarioControle fc = new FuncionarioControle();
        Funcionario funcionario = new Funcionario();
        
        funcionario.setNome("Joao");
        funcionario.setCPF("06118077965");
        funcionario.setEmail("joao@gmail.com");
        funcionario.setFuncao("Carpinteiro");
        String dataNascimento= "09/09/1988";
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        try {
            data = new java.sql.Date(fmt.parse(dataNascimento).getTime());
            funcionario.setDataNascimento(data);
        } catch (ParseException ex) {
            Logger.getLogger(TestFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        funcionario.setRG("92666896");
        funcionario.setStatus(0);
        funcionario.setLogin("joao");
        funcionario.setSenha("123456");
        funcionario.setTelefone("999501735");
        funcionario.setCelular("33052470");
        
        Endereco endereco = new Endereco();
        endereco.setBairro("Vila Bela");
        endereco.setCEP("85040263");
        endereco.setComplemento("Prox. Unicentro");
        endereco.setFk_idCidade(3);
        endereco.setNumero(496);
        endereco.setRua("Rua Das Dálias");
      
        fc.adicionar(funcionario, endereco);
    }
}
