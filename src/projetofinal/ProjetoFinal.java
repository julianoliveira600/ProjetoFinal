
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
        
        ClienteControle cc = new ClienteControle();
        Cliente cliente = new Cliente();
        cliente.setNome(JOptionPane.showInputDialog("Digite o nome: "));
        cliente.setCpf(JOptionPane.showInputDialog("Digite o CPF:"));
        cliente.setEmail(JOptionPane.showInputDialog("Digite o email:"));
        cliente.setRg("Digite o RG:");
        String dataNascimento= JOptionPane.showInputDialog("Digite a data de nascimento");
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new java.sql.Date(fmt.parse(dataNascimento).getTime());
        cliente.setDataNascimento(data);
        
        
        Endereco endereco = new Endereco();
        endereco.setBairro(JOptionPane.showInputDialog("Digite o Bairro"));
        endereco.setCEP(JOptionPane.showInputDialog("Digite o CEP:"));
        endereco.setComplemento(JOptionPane.showInputDialog("Digite o complemento"));
        endereco.setFk_idCidade(3);
        endereco.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da residência")));
        endereco.setRua(JOptionPane.showInputDialog("Digite a rua:"));
      
        cc.adicionar(cliente, endereco);
        
        
        
               
    }
    
}
