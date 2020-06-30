/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.dao.impl;

import br.vianna.aula.jsf.model.dao.IGenericsDao;
import br.vianna.aula.jsf.model.domain.laboratorio.Teste;
import br.vianna.aula.jsf.model.domain.laboratorio.dto.TesteDto;
import br.vianna.aula.jsf.model.domain.usuario.Usuario;
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
public class TesteDao implements IGenericsDao<Teste, Integer>{
    
    @Autowired
    EntityManager em;

    @Override
    public Teste inserir(Teste obj) {
        em.persist(obj);
        return obj;
    }

    @Override
    public Teste editar(Teste obj) {
        em.merge(obj);
        return obj;
    }

    @Override
    public void apagar(Teste obj) {
         obj = em.find(Teste.class, obj);
        em.remove(obj);
    }

    @Override
    public Teste buscarUm(Integer key) {
       Query q = em.createQuery("select t from Teste t where t.id =: id");
        
        q.setParameter("id", key);
        try{
            return (Teste) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Teste> buscarTodos() {
        Query q = em.createQuery("select t from Teste t ");
        return q.getResultList();
    }
    
    public List<TesteDto> buscarTodosTestesDtoDaColeta(Integer id){
        Query q = em.createQuery("select new br.vianna.aula.jsf.model.domain.laboratorio.dto.TesteDto(t.id, t.dataHoraTeste, t.resultado, t.resposavelTecnico) from Teste t where t.id =: id");
        
        q.setParameter("id", id);
        try{
            return (List<TesteDto>) q.getResultList();
        }catch(NoResultException e){
            return null;
        }
    }
    
    
    
    
    
}
