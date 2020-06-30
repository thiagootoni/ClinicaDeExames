/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.controller;

import br.vianna.aula.jsf.controller.enuns.EEstadoPgCadastro;
import br.vianna.aula.jsf.controller.enuns.EEstadoPgLaboratorio;
import br.vianna.aula.jsf.model.dao.impl.ColetaDao;
import br.vianna.aula.jsf.model.domain.laboratorio.Coleta;
import br.vianna.aula.jsf.model.domain.laboratorio.dto.ColetaDto;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author thiago
 */
@Component(value="laboratorio")
@ViewScoped
public class LaboratorioMb implements Serializable{
    
    private int qtdTestes;
    
    private List<ColetaDto> coletasDto;
    
    private Coleta coleta;
    
    private EEstadoPgLaboratorio estadoPagina = EEstadoPgLaboratorio.LISTAGEM;
    
    @Autowired
    private SessionMb sessao;
    
    @Autowired
    private ColetaDao cDao;
    
}
