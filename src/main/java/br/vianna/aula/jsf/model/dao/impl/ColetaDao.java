/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.dao.impl;

import br.vianna.aula.jsf.model.dao.IGenericsDao;
import br.vianna.aula.jsf.model.domain.laboratorio.Coleta;
import br.vianna.aula.jsf.model.domain.laboratorio.dto.ColetaDto;
import br.vianna.aula.jsf.model.domain.laboratorio.enuns.EStatusColeta;
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
public class ColetaDao implements IGenericsDao<Coleta, Integer> {

    @Autowired
    EntityManager em;

    @Override
    public Coleta inserir(Coleta obj) {
        em.persist(obj);
        return obj;
    }

    @Override
    public Coleta editar(Coleta obj) {
        em.merge(obj);
        return obj;
    }

    @Override
    public void apagar(Coleta obj) {
        obj = this.buscarUm(obj.getId());
        em.remove(obj);
    }

    @Override
    public Coleta buscarUm(Integer key) {
        Query q = em.createQuery("select c from Coleta c where c.id =: id");

        q.setParameter("id", key);
        try {
            return (Coleta) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Coleta> buscarTodos() {
        Query q = em.createQuery("select c from Coleta c");
        return q.getResultList();
    }
    
    public List<ColetaDto> buscarTodasColetasDto(){
        Query q = em.createQuery("select new br.vianna.aula.jsf.model.domain.laboratorio.dto.ColetaDto(c.id, c.dataHoraColeta, c.statusColeta) from Coleta c WHERE c.statusColeta =: valida or c.statusColeta =: emanalise");
        
        //where c.statusColeta =: valida or c.statusColeta =: emanalise
        q.setParameter("valida", EStatusColeta.VALIDA);
        q.setParameter("emanalise", EStatusColeta.EM_ANALISE);
        
        return q.getResultList();
    }

}
