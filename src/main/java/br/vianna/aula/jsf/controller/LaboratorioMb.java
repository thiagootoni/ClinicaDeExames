/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.controller;

import br.vianna.aula.jsf.controller.enuns.EEstadoPgLaboratorio;
import br.vianna.aula.jsf.model.dao.impl.ColetaDao;
import br.vianna.aula.jsf.model.dao.impl.TesteDao;
import br.vianna.aula.jsf.model.domain.laboratorio.Coleta;
import br.vianna.aula.jsf.model.domain.laboratorio.Teste;
import br.vianna.aula.jsf.model.domain.laboratorio.dto.ColetaDto;
import br.vianna.aula.jsf.model.domain.laboratorio.dto.TesteDto;
import br.vianna.aula.jsf.model.domain.usuario.EFuncao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
    
    private List<TesteDto> testesDtoDaColeta;
    
    private Coleta coleta;
    
    private Teste teste;
    
    private EEstadoPgLaboratorio estadoPagina = EEstadoPgLaboratorio.LISTAGEM;
    
    @Autowired
    private SessionMb sessao;
    
    @Autowired
    private ColetaDao cDao;
    
    @Autowired
    private TesteDao tDao;

    public LaboratorioMb() {
        this.coleta = new Coleta();
        this.teste = new Teste();
        this.coletasDto = new ArrayList<>();
        this.testesDtoDaColeta = new ArrayList<>();
    }
    
    @PostConstruct
    public void iniciar() {
        this.coletasDto = cDao.buscarTodasColetasDto();

    }

    @PreDestroy
    public void destruir() {

    }
    
    public String navegarParaTestagem(int id){
        this.estadoPagina = EEstadoPgLaboratorio.TESTAGEM;
        this.testesDtoDaColeta = tDao.buscarTodosTestesDtoDaColeta(id);
        return "";
    }
    
    
    public boolean estadoListagem(){
        return this.estadoPagina.equals(EEstadoPgLaboratorio.LISTAGEM);
    }
    
    public boolean estadoTestagem(){
        return this.estadoPagina.equals(EEstadoPgLaboratorio.TESTAGEM);
    } 
    
    public boolean ehSupervisor(){
        return this.sessao.getUsuarioSessao().getFuncao().equals(EFuncao.SUPERVISOR);
    }
    
    public boolean ehTecnico(){
        return this.sessao.getUsuarioSessao().getFuncao().equals(EFuncao.TECNICO);
    }
    
    /* ----------------------------------------------*/

    public int getQtdTestes() {
        return qtdTestes;
    }

    public void setQtdTestes(int qtdTestes) {
        this.qtdTestes = qtdTestes;
    }

    public List<ColetaDto> getColetasDto() {
        return coletasDto;
    }

    public void setColetasDto(List<ColetaDto> coletasDto) {
        this.coletasDto = coletasDto;
    }

    public Coleta getColeta() {
        return coleta;
    }

    public void setColeta(Coleta coleta) {
        this.coleta = coleta;
    }

    public EEstadoPgLaboratorio getEstadoPagina() {
        return estadoPagina;
    }

    public void setEstadoPagina(EEstadoPgLaboratorio estadoPagina) {
        this.estadoPagina = estadoPagina;
    }

    public SessionMb getSessao() {
        return sessao;
    }

    public void setSessao(SessionMb sessao) {
        this.sessao = sessao;
    }

    public ColetaDao getcDao() {
        return cDao;
    }

    public void setcDao(ColetaDao cDao) {
        this.cDao = cDao;
    }

    public List<TesteDto> getTestesDtoDaColeta() {
        return testesDtoDaColeta;
    }

    public void setTestesDtoDaColeta(List<TesteDto> testesDtoDaColeta) {
        this.testesDtoDaColeta = testesDtoDaColeta;
    }

    public Teste getTeste() {
        return teste;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }
    
    
    
}
