//
//package projetofinal;
//
//import br.com.projeto.controle.FuncionarioControle;
//import br.com.projeto.negocio.entidades.Endereco;
//import br.com.projeto.negocio.entidades.Funcionario;
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import javax.swing.JOptionPane;
//
//
//public class TestaFuncionario {
//    public static void main(String[] args) throws ParseException {
//        
//        FuncionarioControle fc = new FuncionarioControle();
//        Funcionario funcionario = new Funcionario();
//        
//        funcionario.setNome(JOptionPane.showInputDialog("Digite o nome Funcionario"));
//        funcionario.setCPF(JOptionPane.showInputDialog("Digite o CPF:"));
//        funcionario.setEmail(JOptionPane.showInputDialog("Digite o email"));
//        funcionario.setFuncao(JOptionPane.showInputDialog("Digite a função"));
//        String dataNascimento= JOptionPane.showInputDialog("Digite a data de nascimento");
//        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
//        Date data = new java.sql.Date(fmt.parse(dataNascimento).getTime());
//        funcionario.setDataNascimento(data);
//        
//       Endereco endereco = new Endereco();
//        endereco.setBairro(JOptionPane.showInputDialog("Digite o Bairro"));
//        endereco.setCEP(JOptionPane.showInputDialog("Digite o CEP:"));
//        endereco.setComplemento(JOptionPane.showInputDialog("Digite o complemento"));
//        endereco.setFk_idCidade(3);
//        endereco.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da residência")));
//        endereco.setRua(JOptionPane.showInputDialog("Digite a rua:"));
//      
//        fc.adicionar(funcionario, endereco);
//    }
//}
