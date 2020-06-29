/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.dao;

import java.util.List;

/**
 *
 * @author thiago
 */
public interface IGenericsDao<C,K> {
    
    public C inserir(C obj);
    public C editar(C obj);
    public void apagar(C obj);
    public C buscarUm(K key);
    public List<C> buscarTodos();
    
}
