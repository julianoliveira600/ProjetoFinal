/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.negocio.entidades;

import br.com.projeto.persistencia.conexao.FabricaConexao;
import br.com.projeto.persistencia.exception.PersistenciaException;
import br.com.projeto.persistencia.validacao.Campo;
import br.com.projeto.persistencia.validacao.Chave;
import br.com.projeto.persistencia.validacao.Tabela;
import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    private StringBuilder collection;
   
    private List<String> camposSelect;
    
    private List<String> condicao;
    
    private String tabela;
    
    private String id;
    
    private List<String> juncaoRelacao;
    
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
    
    
    public Entidade prepareSelect() throws PersistenciaException, IllegalArgumentException, IllegalAccessException{
        Tabela[] annotationsClass = this.getClass().getDeclaredAnnotationsByType(Tabela.class);
        List<Campo> campos = this.getFieldsWithAnnotationsCampo();
        List<Field> fields = this.getFieldsWithAnnotationsChave();
        if(annotationsClass.length == 0){
            throw new PersistenciaException("Falta Anotação Tabela na entidade");
        }

        Tabela annotationClass = annotationsClass[0];
        this.tabela = annotationClass.nome();
        this.camposSelect = new ArrayList<String>();
        for(Campo c : campos){
           if(c.isId()){
               this.id = c.nome();
           }
           this.camposSelect.add(this.tabela+"."+c.nome()+" AS "+this.tabela+"_"+c.nome());
        }       

        this.juncaoRelacao = new ArrayList<String>();
        for(Field f : fields){
            Chave c = f.getAnnotation(Chave.class);
            f.setAccessible(true);
            Entidade e = (Entidade) f.get(this);
            if(e instanceof Entidade){
                e.prepareSelect();
                String fk = (c.fk())? c.campo() : this.id;
                this.juncaoRelacao.add("LEFT JOIN "+e.getTabela()+" ON "+e.getTabela()+"."+e.getStringId()+"="+this.tabela+"."+fk+" \n");
                for(String campoSelect : e.getCamposSelect()){
                    this.camposSelect.add(campoSelect);
                }
                
                for(String join : e.getJuncaoRelacao()){
                    this.juncaoRelacao.add(join);
                }
            }
        }
        
        int count = this.camposSelect.size();
        int i = 0;
        this.collection = new StringBuilder();
        this.collection.append("SELECT ");
        for(String c : this.camposSelect){
            if(i < count - 1){
                this.collection.append(c);
                this.collection.append(",\n");
            }else{
                this.collection.append(c);
                this.collection.append("\n ");
            }
            i++;
        }
        this.collection.append("FROM ");
        this.collection.append(this.tabela);
        this.collection.append(" \n");
       
        for(String c : this.juncaoRelacao){            
            this.collection.append(c);
            this.collection.append("\n");
        }
       
        this.collection.append("\n");
    
        return this;
    }
    
    public String getStringId(){
        return this.id;
    }
    
    public List<String> getJuncaoRelacao(){
        return this.juncaoRelacao;
    }
    
    public String getTabela(){
        return this.tabela;
    }
    
    private List<Campo> getFieldsWithAnnotationsCampo(){
        List<Campo> list = new ArrayList<Campo>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(Campo.class)){
                Campo campo = field.getAnnotation(Campo.class);
                list.add(campo);
            }
        }
        return list;
    }

    private List<Field> getFieldsWithAnnotationsChave() throws IllegalArgumentException, IllegalAccessException{
        List<Field> list = new ArrayList<Field>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(Chave.class)){
                list.add(field);
            }
        }
        return list;
    }
    
    private List<Field> getFieldsWithAnnotations() throws IllegalArgumentException, IllegalAccessException{
        List<Field> list = new ArrayList<Field>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(Chave.class) || field.isAnnotationPresent(Campo.class)  ){
                list.add(field);
            }
        }
        return list;
    }
        
    public List<String> getCamposSelect(){
        return this.camposSelect;
    }
    
    
    public Entidade prepareWhere(String field, Object value) throws PersistenciaException{
        Field[] fields = this.getClass().getDeclaredFields();
        String condition = new String();
        for (Field f : fields){
            if (f .isAnnotationPresent(Campo.class)){
                Campo campo = f.getAnnotation(Campo.class);
                condition = field+"="+value;
            }
        }
        if(condition.length() == 0){
            throw new PersistenciaException("Campo não encontrado ao preparar condições");
        }
        
        if(!this.collection.toString().matches("(.*)WHERE(.*)")){
            this.collection.append("\n");
            this.collection.append("WHERE ");
            this.collection.append(condition);
            return this;
        }
        
        this.collection.append("AND ");
        this.collection.append(condition); 
        return this;
    }
    
    public String getSelect(){
       return this.collection.toString();
    }
    
    public Entidade loadOne() throws SQLException, IllegalArgumentException, IllegalAccessException{
        PreparedStatement select = FabricaConexao.obterConexao().prepareStatement(this.getSelect());
        ResultSet rs = select.executeQuery();
        while (rs.next()) {
            this.setValuesFieldsByResultSet(rs);
        }
        return this;
    }
    
    public List<? extends Entidade> loadAll() throws SQLException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InstantiationException{
        PreparedStatement select = FabricaConexao.obterConexao().prepareStatement(this.getSelect());
        ResultSet rs = select.executeQuery();
        String className = this.getClass().getName();
        List<Entidade> entidades = new ArrayList<Entidade>();

        while (rs.next()) {
            Entidade e = (Entidade) Class.forName(className).newInstance();
            Tabela[] annotationsClass = e.getClass().getDeclaredAnnotationsByType(Tabela.class);
            Tabela annotationClass = annotationsClass[0];
            e.tabela = annotationClass.nome();
            e.setValuesFieldsByResultSet(rs);
            entidades.add(e);
        }
        return entidades;
    }
    
    private void setValuesFieldsByResultSet(ResultSet rs) throws IllegalArgumentException, IllegalAccessException, SQLException{
        List<Field> fields = this.getFieldsWithAnnotations();
        for(Field f : fields){
            if (f.isAnnotationPresent(Campo.class)){
                f.setAccessible(true);
                if(f.getType().isAssignableFrom(Integer.TYPE)){
                    f.set(this, rs.getInt(this.tabela+"_"+f.getAnnotation(Campo.class).nome()));
                }

                if(f.getType().isAssignableFrom(String.class)){
                    f.set(this, rs.getString(this.tabela+"_"+f.getAnnotation(Campo.class).nome()));
                }

                if(f.getType().isAssignableFrom(Date.class)){
                    f.set(this, rs.getDate(this.tabela+"_"+f.getAnnotation(Campo.class).nome()));
                }

                if(f.getType().isAssignableFrom(Boolean.TYPE)){
                    f.set(this, (Boolean) (rs.getInt(this.tabela+"_"+f.getAnnotation(Campo.class).nome()) == 0) ? false : true);
                } 
            }


            if(f.isAnnotationPresent(Chave.class)){
                f.setAccessible(true);
                Entidade e = (Entidade) f.get(this);
                if(e instanceof Entidade){
                    e.setValuesFieldsByResultSet(rs);
                }
            }     
        }
        
        return;
    }
}
