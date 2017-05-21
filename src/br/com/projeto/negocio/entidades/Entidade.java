/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.negocio.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public abstract class Entidade {
    
    private List<String> mensagens = new ArrayList<String>();
    
    public void adicionarMensagem(String mensagem){
        this.mensagens.add(mensagem);
    }
    
    public List<String> obterMensagens(){
       return this.mensagens;
    }
    
    public void limparMensagens(){
        this.mensagens.clear();
    }
        
}
