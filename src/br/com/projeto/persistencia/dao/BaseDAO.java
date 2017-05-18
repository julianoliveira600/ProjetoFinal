package br.com.projeto.persistencia.dao;


import br.com.projeto.persistencia.exception.PersistenciaException;
import java.util.List;

public interface BaseDAO<T>{

    
    public int insert(T entidade) throws PersistenciaException;

    public void remove(int id) throws PersistenciaException;

    public void edit(T entidade) throws PersistenciaException;

    public List<T> list() throws PersistenciaException;
}
