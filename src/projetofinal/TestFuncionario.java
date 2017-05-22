package projetofinal;

import br.com.projeto.controle.ClienteControle;
import br.com.projeto.controle.FuncionarioControle;
import br.com.projeto.negocio.entidades.Cliente;
import br.com.projeto.negocio.entidades.Endereco;
import br.com.projeto.negocio.entidades.Funcionario;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TestFuncionario {

    public void testInsert() {
        FuncionarioControle fc = new FuncionarioControle();
        Funcionario funcionario = new Funcionario();

        funcionario.setNome("Alisson");
        funcionario.setCPF("06118077965");
        funcionario.setEmail("alisson@gmail.com");
        funcionario.setFuncao("Advogado");
        String dataNascimento = "09/09/1975";
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        try {
            data = new java.sql.Date(fmt.parse(dataNascimento).getTime());
            funcionario.setDataNascimento(data);
        } catch (ParseException ex) {
            Logger.getLogger(TestFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        funcionario.setRG("98765");
        funcionario.setStatus(0);
        funcionario.setLogin("Alisson");
        funcionario.setSenha("123456");
        funcionario.setTelefone("999501735");
        funcionario.setCelular("33052470");

        Endereco endereco = new Endereco();
        endereco.setBairro("Monte Belo");
        endereco.setCEP("86041220");
        endereco.setComplemento("Perto Unopar");
        endereco.setFk_idCidade(3);
        endereco.setNumero(496);
        endereco.setRua("Antonio Piccinin");
        funcionario.setEndereco(endereco);
        
        fc.adicionar(funcionario);
        funcionario.obterMensagens();
    }

    public void testUpdate(int id) {
        FuncionarioControle cc = new FuncionarioControle();
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(id);
        funcionario.setNome("Jesse");
        funcionario.setCPF("10090897");
        funcionario.setEmail("Jesse@bol.com");
        funcionario.setRG("987123");
        String dataNascimento = "09/09/1999";
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        try {
            data = new java.sql.Date(fmt.parse(dataNascimento).getTime());
            funcionario.setDataNascimento(data);
        } catch (ParseException ex) {
            Logger.getLogger(TestCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        funcionario.setTelefone("33424382");
        funcionario.setCelular("99994567");

        Endereco endereco = new Endereco();
        endereco.setBairro("Vila Carli");
        endereco.setCEP("748973");
        endereco.setComplemento("Prox. Unopar");
        endereco.setFk_idCidade(3);
        endereco.setNumero(777);
        endereco.setRua("Lisboa");

        funcionario.setEndereco(endereco);
        cc.atualizar(funcionario);
    }

    public void testList() {
        FuncionarioControle cc = new FuncionarioControle();
        List<Funcionario> funcionarios = cc.listar();
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getIdFuncionario() + ":" + funcionario.getNome());
        }
    }

    public void testView(int id) {
        FuncionarioControle cc = new FuncionarioControle();
        Funcionario funcionario = cc.visualizar(id);
        System.out.println(funcionario.getIdFuncionario() + ":" + funcionario.getNome());
        System.out.println(funcionario.getEndereco().getIdEndereco() + ":" + funcionario.getEndereco().getCEP());

    }

}
