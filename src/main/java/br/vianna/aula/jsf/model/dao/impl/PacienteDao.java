/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.dao.impl;

import br.vianna.aula.jsf.model.dao.IGenericsDao;
import br.vianna.aula.jsf.model.domain.laboratorio.Paciente;
import br.vianna.aula.jsf.model.domain.usuario.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.EntityMode;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author thiago
 */
public class PacienteDao implements IGenericsDao<Paciente, Integer>{

    @Autowired
    EntityManager em;
    
    @Override
    public Paciente inserir(Paciente obj) {
        em.persist(obj);
        return obj;
    }

    @Override
    public Paciente editar(Paciente obj) {
        em.merge(obj);
        return obj;
    }

    @Override
    public void apagar(Paciente obj) {
        obj = this.buscarUm(obj.getId());
        em.remove(obj);
    }

    @Override
    public Paciente buscarUm(Integer key) {
        Query q = em.createQuery("select p from Paciente p where p.id =: id");
        
        q.setParameter("id", key);
        try{
            return (Paciente) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Paciente> buscarTodos() {
        Query q = em.createQuery("select p from Paciente p");
        return q.getResultList();
    }
    
    public Paciente buscarPorCpf(String cpf){
        Query q = em.createQuery("select p from Paciente p where p.cpf =: cpf");
        
        q.setParameter("id", cpf);
        try{
            return (Paciente) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
}
