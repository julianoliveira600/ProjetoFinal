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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius
 */
public class TestCliente {
    
    
    public void testInsert(){
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
        Endereco endereco = new Endereco();
        endereco.setBairro("Vila Carli");
        endereco.setCEP("85040210");
        endereco.setComplemento("Prox. Cedeted");
        endereco.setFk_idCidade(3);
        endereco.setNumero(752);
        endereco.setRua("Xavantes");
      
        cc.adicionar(cliente, endereco);
    }
    
    public void testUpdate(){
        ClienteControle cc = new ClienteControle();
        Cliente cliente = new Cliente();
        cliente.setId(1);
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
        Endereco endereco = new Endereco();
        endereco.setIdEndereco(1);
        endereco.setBairro("Vila Carli");
        endereco.setCEP("85040210");
        endereco.setComplemento("Prox. Cedeted");
        endereco.setFk_idCidade(3);
        endereco.setNumero(752);
        endereco.setRua("Xavantes");
      
        cc.atualizar(cliente, endereco);
    }
}
