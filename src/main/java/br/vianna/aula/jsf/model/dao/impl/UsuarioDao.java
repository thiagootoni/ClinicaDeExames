/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.dao.impl;

import br.vianna.aula.jsf.model.dao.IGenericsDao;
import br.vianna.aula.jsf.model.domain.usuario.Usuario;
import br.vianna.aula.jsf.model.domain.usuario.dto.UsuarioSessaoDto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author thiago
 */
@Component
public class UsuarioDao implements IGenericsDao<Usuario, Integer>{
    
    @Autowired
    EntityManager em;

    @Override
    public Usuario inserir(Usuario obj) {
        em.persist(obj);
        return obj;
    }

    @Override
    public Usuario editar(Usuario obj) {
        em.merge(obj);
        return obj;
    }

    @Override
    public void apagar(Usuario obj) {
        obj = em.find(Usuario.class, obj);
        em.remove(obj);
    }

    @Override
    public Usuario buscarUm(Integer key) {
        Query q = em.createQuery("select u from Usuario u where u.id =: id");
        
        q.setParameter("id", key);
        try{
            return (Usuario) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Usuario> buscarTodos() {
        Query q = em.createQuery("select u from Usuario u ");
        return q.getResultList();
    }
    
    public UsuarioSessaoDto buscarPorProntuarioESenha(String prontuario, String senha){
        
        Query q = em.createQuery("select new br.vianna.aula.jsf.model.domain.usuario.dto.UsuarioSessaoDto(u.id, u.nome, u.prontuario, u.senha, u.funcao) from Usuario u where u.prontuario =: prontuario and u.senha =: senha");
        
        q.setParameter("prontuario", prontuario);
        q.setParameter("senha", senha);
        
        try {
            return (UsuarioSessaoDto) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    }
    
    
}
