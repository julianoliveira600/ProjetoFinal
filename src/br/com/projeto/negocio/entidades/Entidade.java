/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.negocio.entidades;

import br.com.projeto.persistencia.validacao.Campo;
import br.com.projeto.persistencia.validacao.Chave;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    public boolean valida(){
        boolean valida = true;
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object obj;
            try {
                obj = field.get(this);
             } catch (IllegalArgumentException ex) {
                Logger.getLogger(Entidade.class.getName()).log(Level.SEVERE, null, ex);
                valida = false;
                return valida;
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Entidade.class.getName()).log(Level.SEVERE, null, ex);
                valida = false;
                return valida;
            }
            if (field.isAnnotationPresent(Campo.class)) {
                Campo anotacao = field.getAnnotation(Campo.class);
                if (anotacao.tamanho() < obj.toString().length()){
                    this.mensagens.add(anotacao.mensagemTamanho() + field.getName());
                    valida = false;
                }

                if(anotacao.requerido() && obj.toString().isEmpty()){
                    this.mensagens.add(anotacao.mensagemRequerido() + field.getName());
                    valida = false;
                }

                if(anotacao.formato().length() > 0){
                    Pattern pattern = Pattern.compile(anotacao.formato());
                    Matcher matcher = pattern.matcher(obj.toString());
                    if(!matcher.matches()){
                        this.mensagens.add(anotacao.mensagemFormato() + field.getName());
                        valida = false;
                    }
                }
               
            }
            
            if (field.isAnnotationPresent(Chave.class)) {
                Chave anotacao = field.getAnnotation(Chave.class);
                if(anotacao.requerido() && !(obj instanceof Entidade)){
                    this.mensagens.add(anotacao.mensagemRequerido() + field.getName());
                    valida = false;
                }
            }
        }
        return valida;
    }        
}
