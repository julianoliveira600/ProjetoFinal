package br.com.projeto.controle;

import java.util.List;

public interface BaseControle<T> {

    public void adicionar(T entidade);

    public void atualizar(T entidade);

    public List<T> listar();

    public T visualizar(int id);
}
