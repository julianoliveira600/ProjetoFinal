/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

import br.com.projeto.controle.ClienteControle;
import br.com.projeto.negocio.entidades.Cliente;
import br.com.projeto.negocio.entidades.Endereco;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius
 */
public class TestCliente {
    
    
    public int testInsert(){
        ClienteControle cc = new ClienteControle();
        Cliente cliente = new Cliente();
        cliente.setNome("Vinicius");
        cliente.setCpf("06118077932");
        cliente.setEmail("viniciusbord9@gmail.com");
        cliente.setRg("92666573");
        String dataNascimento= "09/09/1988";
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        try {
            data = new java.sql.Date(fmt.parse(dataNascimento).getTime());
            cliente.setDataNascimento(data);
        } catch (ParseException ex) {
            Logger.getLogger(TestCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cliente.setTelefone("33042563");
        cliente.setCelular("999501735");
        
        Endereco endereco = new Endereco();
        endereco.setBairro("Vila Carli");
        endereco.setCEP("85040210");
        endereco.setComplemento("Prox. Cedeted");
        endereco.setFk_idCidade(3);
        endereco.setNumero(752);
        endereco.setRua("Xavantes");
        cliente.setEndereco(endereco);
      
        cc.adicionar(cliente);
        cliente.obterMensagens();
        return cliente.getId();
    }
    
    public void testUpdate(int id){
        ClienteControle cc = new ClienteControle();
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome("Jose");
        cliente.setCpf("06118077932");
        cliente.setEmail("jose@gmail.com");
        cliente.setRg("92666573");
        String dataNascimento= "09/09/1988";
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        try {
            data = new java.sql.Date(fmt.parse(dataNascimento).getTime());
            cliente.setDataNascimento(data);
        } catch (ParseException ex) {
            Logger.getLogger(TestCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cliente.setTelefone("33042563");
        cliente.setCelular("999501735");
      
        Endereco endereco = new Endereco();
        endereco.setBairro("Vila Bela");
        endereco.setCEP("85040211");
        endereco.setComplemento("Prox. Unicentro");
        endereco.setFk_idCidade(3);
        endereco.setNumero(777);
        endereco.setRua("Lisboa");
        
        cliente.setEndereco(endereco);
        cc.atualizar(cliente); 
    }
    
    public void testList(){
        ClienteControle cc = new ClienteControle();
        List<Cliente> clientes = cc.listar();
        for(Cliente cliente : clientes){
            System.out.println(cliente.getId()+":"+cliente.getNome());
        }
    }
    
    public void testView(int id){
        ClienteControle cc = new ClienteControle();
        Cliente cliente = cc.visualizar(id);
        System.out.println(cliente.getId()+":"+cliente.getNome());
        System.out.println(cliente.getEndereco().getIdEndereco()+":"+cliente.getEndereco().getCEP());
        System.out.println(cliente.getAlteracoes().getObservacoes());
    }
}
