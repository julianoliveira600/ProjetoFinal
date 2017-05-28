/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

import br.com.projeto.controle.ClienteControle;
import br.com.projeto.negocio.entidades.Alteracoes;
import br.com.projeto.negocio.entidades.Avaliacao;
import br.com.projeto.negocio.entidades.Biometria;
import br.com.projeto.negocio.entidades.Cliente;
import br.com.projeto.negocio.entidades.Endereco;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius
 */
public class TestCliente {

    public int testInsert() {
        ClienteControle cc = new ClienteControle();
        Cliente cliente = new Cliente();
        cliente.setNome("Aristides");
        cliente.setCpf("06118077932");
        cliente.setEmail("aristidesbord9@gmail.com");
        cliente.setRg("92666573");
        String dataNascimento = "09/09/1988";
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
        endereco.setRua("Antonio Piccinin");
        cliente.setEndereco(endereco);

        //////////Inserindo alteracoes///////////////////////
        Alteracoes alteracoes = new Alteracoes();
        alteracoes.setCardiaca(true);
        alteracoes.setVasculares(true);
        alteracoes.setReumaticas(true);
        alteracoes.setRenais(true);
        alteracoes.setGlandulares(true);
        alteracoes.setGinecologicas(true);
        alteracoes.setProteses(true);
        alteracoes.setBronquite(true);
        alteracoes.setAlergias(true);
        alteracoes.setUsadiu(true);
        alteracoes.setPressaoMembros(true);
        alteracoes.setConstipacao(true);
        alteracoes.setTratamentoMedico(true);
        alteracoes.setGestante(true);
        alteracoes.setMarcapasso(true);
        alteracoes.setEplepsia(true);
        alteracoes.setAncologia(true);
        alteracoes.setProtecaoPele(true);
        alteracoes.setDiabetes(true);
        alteracoes.setObservacoes("");
        cliente.setAlteracoes(alteracoes);

        ////// inserindo Avaliacao/////////
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setCorPele(1);
        avaliacao.setAparenciaPele(1);
        avaliacao.setSuperficiePele(1);
        avaliacao.setLesoesPele(1);
        avaliacao.setBiotipoCultaneo(1);
        avaliacao.setAcne(1);
        avaliacao.setFlacidez(1);
        avaliacao.setDesidratacao(1);
        avaliacao.setMiliun(true);
        avaliacao.setCopuperose(true);
        avaliacao.setTelangiectasia(true);
        avaliacao.setEfelidez(true);
        avaliacao.setXantelasma(true);
        avaliacao.setRugas(true);
        avaliacao.setRosacea(true);
        avaliacao.setSeborreia(true);
        avaliacao.setFoliculite(true);
        avaliacao.setCicatriz(true);
        avaliacao.setVerrugasPintas(true);
        avaliacao.setAcromia(true);
        avaliacao.setCloasma(true);
        avaliacao.setHipercromia(true);
        avaliacao.setHipocromia(true);
        avaliacao.setAngioma(true);
        avaliacao.setEritema(true);
        avaliacao.setPetequias(true);
        avaliacao.setCianose(true);
        avaliacao.setHematoma(true);
        avaliacao.setCeratose(true);
        avaliacao.setPapulas(true);
        avaliacao.setComedao(true);
        avaliacao.setNecrose(true);
        avaliacao.setNodulos(true);
        avaliacao.setBolhas(true);
        avaliacao.setPustulas(true);
        avaliacao.setVesicula(true);
        avaliacao.setCrosta(true);
        avaliacao.setEscara(true);
        avaliacao.setFisura(true);
        avaliacao.setUlceracao(true);
        avaliacao.setDescamacao(true);
        avaliacao.setEscoriacao(true);
        avaliacao.setFistula(true);
        avaliacao.setAtrofia(true);
        avaliacao.setHipertricose(true);
        avaliacao.setHirsutismo(true);
        avaliacao.setEczema(true);
        avaliacao.setHiperqueratose(true);
        avaliacao.setPsoariase(true);
        avaliacao.setOleosidadePele(1);
        avaliacao.setEspessura(0);
        avaliacao.setObservacoes("");

        ///////////////// Inserindo Biometria ///////////////
        Biometria biometria = new Biometria();
        biometria.setBracodir(0);
        biometria.setBracoesq(0);
        biometria.setBusto(0);
        biometria.setQuadril(0);
        biometria.setPernadir(0);
        biometria.setPernaesq(0);
        biometria.setCintura(0);
        biometria.setAbdomem(0);
        biometria.setCulote(0);
        biometria.setCoxaDir(0);
        biometria.setCoxaesq(0);
        biometria.setCelulite(true);
        biometria.setGraucelulite(0);
        biometria.setGorduraloc(true);
        biometria.setLocalgorduraloc("");
        biometria.setPtose(true);
        biometria.setLocalptose("");
        biometria.setLocalvibices("");
        
        cliente.setBiometria(biometria);
        cliente.setAlteracoes(alteracoes);
        cliente.setAvaliacao(avaliacao);
        cc.adicionar(cliente);
        cliente.obterMensagens();
        return cliente.getId();

       
    }
 ///////////////////////////// Update /////////////////////////////////////////////////
    public void testUpdate(int id) {
        ClienteControle cc = new ClienteControle();
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome("Aristides da Silva");
        cliente.setCpf("06118077932");
        cliente.setEmail("jose@gmail.com");
        cliente.setRg("92666573");
        String dataNascimento = "09/09/1988";
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

        ////////Atualiza Alteracoes ///////////////////
        Alteracoes alteracoes = new Alteracoes();
        alteracoes.setCardiaca(true);
        alteracoes.setVasculares(true);
        alteracoes.setReumaticas(true);
        alteracoes.setRenais(true);
        alteracoes.setGlandulares(true);
        alteracoes.setGinecologicas(true);
        alteracoes.setProteses(true);
        alteracoes.setBronquite(true);
        alteracoes.setAlergias(true);
        alteracoes.setUsadiu(true);
        alteracoes.setPressaoMembros(true);
        alteracoes.setConstipacao(true);
        alteracoes.setTratamentoMedico(true);
        alteracoes.setGestante(true);
        alteracoes.setMarcapasso(true);
        alteracoes.setEplepsia(true);
        alteracoes.setAncologia(true);
        alteracoes.setProtecaoPele(true);
        alteracoes.setDiabetes(true);
        alteracoes.setObservacoes("");
        cliente.setAlteracoes(alteracoes);

        //////////Atualiza Avaliacao /////////////
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setCorPele(1);
        avaliacao.setAparenciaPele(1);
        avaliacao.setSuperficiePele(1);
        avaliacao.setLesoesPele(1);
        avaliacao.setBiotipoCultaneo(1);
        avaliacao.setAcne(1);
        avaliacao.setFlacidez(1);
        avaliacao.setDesidratacao(1);
        avaliacao.setMiliun(true);
        avaliacao.setCopuperose(true);
        avaliacao.setTelangiectasia(true);
        avaliacao.setEfelidez(true);
        avaliacao.setXantelasma(true);
        avaliacao.setRugas(true);
        avaliacao.setRosacea(true);
        avaliacao.setSeborreia(true);
        avaliacao.setFoliculite(true);
        avaliacao.setCicatriz(true);
        avaliacao.setVerrugasPintas(true);
        avaliacao.setAcromia(true);
        avaliacao.setCloasma(true);
        avaliacao.setHipercromia(true);
        avaliacao.setHipocromia(true);
        avaliacao.setAngioma(true);
        avaliacao.setEritema(true);
        avaliacao.setPetequias(true);
        avaliacao.setCianose(true);
        avaliacao.setHematoma(true);
        avaliacao.setCeratose(true);
        avaliacao.setPapulas(true);
        avaliacao.setComedao(true);
        avaliacao.setNecrose(true);
        avaliacao.setNodulos(true);
        avaliacao.setBolhas(true);
        avaliacao.setPustulas(true);
        avaliacao.setVesicula(true);
        avaliacao.setCrosta(true);
        avaliacao.setEscara(true);
        avaliacao.setFisura(true);
        avaliacao.setUlceracao(true);
        avaliacao.setDescamacao(true);
        avaliacao.setEscoriacao(true);
        avaliacao.setFistula(true);
        avaliacao.setAtrofia(true);
        avaliacao.setHipertricose(true);
        avaliacao.setHirsutismo(true);
        avaliacao.setEczema(true);
        avaliacao.setHiperqueratose(true);
        avaliacao.setPsoariase(true);
        avaliacao.setOleosidadePele(1);
        avaliacao.setEspessura(0);
        avaliacao.setObservacoes("");

        ///////////////Atualiza Biometria////////////////////qqqq
        Biometria biometria = new Biometria();
        biometria.setBracodir(0);
        biometria.setBracoesq(0);
        biometria.setBusto(0);
        biometria.setQuadril(0);
        biometria.setPernadir(0);
        biometria.setPernaesq(0);
        biometria.setCintura(0);
        biometria.setAbdomem(0);
        biometria.setCulote(0);
        biometria.setCoxaDir(0);
        biometria.setCoxaesq(0);
        biometria.setCelulite(true);
        biometria.setGraucelulite(0);
        biometria.setGorduraloc(true);
        biometria.setLocalgorduraloc("");
        biometria.setPtose(true);
        biometria.setLocalptose("");
        biometria.setLocalvibices("");

        cliente.setBiometria(biometria);
        cliente.setAlteracoes(alteracoes);
        cliente.setAvaliacao(avaliacao);
    }

    public void testList() {
        ClienteControle cc = new ClienteControle();
        List<Cliente> clientes = cc.listar();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getId() + ":" + cliente.getNome() + ":" + cliente.getCpf());
        }
    }

    public void testView(int id) {
        ClienteControle cc = new ClienteControle();
        Cliente cliente = cc.visualizar(id);
        System.out.println(cliente.getId() + ":" + cliente.getNome());
        System.out.println(cliente.getEndereco().getIdEndereco() + ":" + cliente.getEndereco().getCEP());
        System.out.println(cliente.getAlteracoes().getObservacoes());
        System.out.println(cliente.getAvaliacao().getAcne() + ":" + cliente.getAvaliacao().getDesidratacao());
        System.out.println(cliente.getBiometria().getCoxaesq() + ":" + cliente.getBiometria().getCintura());
    }
}
