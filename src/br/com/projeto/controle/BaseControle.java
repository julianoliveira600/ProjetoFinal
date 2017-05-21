/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controle;

import java.util.List;

/**
 *
 * @author Vinicius
 */
public interface BaseControle<T> {
    public void adicionar(T entidade);
    public void atualizar(T entidade);
    public List<T> listar();
    public T visualizar(int id);
}
