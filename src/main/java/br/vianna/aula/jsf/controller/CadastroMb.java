/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.controller;

import br.vianna.aula.jsf.controller.enuns.EEstadoPgCadastro;
import br.vianna.aula.jsf.model.dao.impl.ColetaDao;
import br.vianna.aula.jsf.model.dao.impl.PacienteDao;
import br.vianna.aula.jsf.model.domain.laboratorio.Coleta;
import br.vianna.aula.jsf.model.domain.laboratorio.Paciente;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thiago
 */
@Component(value = "cadastro")
@ViewScoped
public class CadastroMb implements Serializable {

    private Paciente paciente;
    private EEstadoPgCadastro estadoPagina = EEstadoPgCadastro.BUSCAR;
    private String cpfBusca;
    private Coleta coleta;

    @Autowired
    private PacienteDao pDao;
    
    @Autowired
    private ColetaDao cDao;

    @Autowired
    private SessionMb sessao;

    public CadastroMb() {
        this.paciente = new Paciente();
        this.coleta = new Coleta();
        this.cpfBusca = "";
    }

    @PostConstruct
    public void iniciar() {

    }

    @PreDestroy
    public void destruir() {

    }

    public String buscaPaciente() {

        FacesContext ct = FacesContext.getCurrentInstance();

        this.paciente = pDao.buscarPorCpf(this.cpfBusca);

        if (this.paciente != null) {
            this.estadoPagina = EEstadoPgCadastro.COLETA;
        } else {
            this.estadoPagina = EEstadoPgCadastro.CADASTRO;
            this.paciente = new Paciente();
        }

        return "";
    }

    @Transactional
    public String salvarPaciente() {

        FacesContext ct = FacesContext.getCurrentInstance();
       //pDao.inserir(paciente);

        try {
            pDao.inserir(paciente);
        } catch (Exception e) {
            ct.addMessage(null, new FacesMessage("Falha ao Cadastrar Paciente!", ""));
            this.paciente = new Paciente();
            return "";
        }

        ct.addMessage(null, new FacesMessage("Paciente cadastrado com sucesso!", ""));
        this.estadoPagina = EEstadoPgCadastro.COLETA;
        //this.paciente = new Paciente();
        this.cpfBusca = "";
        return "";

    }
    
    @Transactional
    public String editarPaciente() {
        
        FacesContext ct = FacesContext.getCurrentInstance();
        
        try {
            pDao.editar(paciente);
        } catch (Exception e) {
            ct.addMessage(null, new FacesMessage("Paciente alterado com sucesso!", ""));
        }
        
        ct.addMessage(null, new FacesMessage("Paciente alterado com sucesso!", ""));
        //this.paciente = new Paciente();
        this.coleta = new Coleta();
        this.estadoPagina = EEstadoPgCadastro.COLETA;
        return "";
    }
    
    @Transactional
    public String salvarColeta() {
        FacesContext ct = FacesContext.getCurrentInstance();

        try {
            this.coleta.setDataHoraColeta(LocalDateTime.now());
            this.coleta.setPaciente(paciente);
            cDao.inserir(this.coleta);
        } catch (Exception e) {
            ct.addMessage(null, new FacesMessage("Falha ao Cadastrar Coleta!", ""));
            return "";
        }

        ct.addMessage(null, new FacesMessage("Coleta cadastrada com sucesso!", ""));
        this.paciente = new Paciente();
        this.coleta = new Coleta();
        this.cpfBusca = "";
        this.estadoPagina = EEstadoPgCadastro.BUSCAR;
        return "";
    }

    public boolean estadoBusca() {
        return this.estadoPagina.equals(EEstadoPgCadastro.BUSCAR);
    }

    public boolean estadoColeta() {
        return this.estadoPagina.equals(EEstadoPgCadastro.COLETA);
    }

    public boolean estadoCadastro() {
        return (this.estadoPagina.equals(EEstadoPgCadastro.CADASTRO));
    }
    
    public boolean estadoEditar() {
        return this.estadoPagina.equals(EEstadoPgCadastro.EDITAR);
    }
    
    public boolean estadoEditarOuCadastro(){
        return (this.estadoPagina.equals(EEstadoPgCadastro.CADASTRO) || this.estadoPagina.equals(EEstadoPgCadastro.EDITAR));
    }
    

    public String navegaPraCadastro() {
        this.estadoPagina = EEstadoPgCadastro.EDITAR;
        return "";
    }

    

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public EEstadoPgCadastro getEstadoPagina() {
        return estadoPagina;
    }

    public void setEstadoPagina(EEstadoPgCadastro estadoPagina) {
        this.estadoPagina = estadoPagina;
    }

    public PacienteDao getpDao() {
        return pDao;
    }

    public void setpDao(PacienteDao pDao) {
        this.pDao = pDao;
    }

    public SessionMb getSessao() {
        return sessao;
    }

    public void setSessao(SessionMb sessao) {
        this.sessao = sessao;
    }

    public String getCpfBusca() {
        return cpfBusca;
    }

    public void setCpfBusca(String cpfBusca) {
        this.cpfBusca = cpfBusca;
    }

    public Coleta getColeta() {
        return coleta;
    }

    public void setColeta(Coleta coleta) {
        this.coleta = coleta;
    }

    public ColetaDao getcDao() {
        return cDao;
    }

    public void setcDao(ColetaDao cDao) {
        this.cDao = cDao;
    }
    
    
}
