/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.controller;

import br.vianna.aula.jsf.model.dao.impl.UsuarioDao;
import br.vianna.aula.jsf.model.domain.usuario.EFuncao;
import br.vianna.aula.jsf.model.domain.usuario.dto.UsuarioSessaoDto;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author thiago
 */

@Component(value = "sessao")
@SessionScoped
public class SessionMb implements Serializable{
    
    private UsuarioSessaoDto usuarioSessao;
    
    @Autowired
    UsuarioDao uDao;

    public SessionMb() {
        this.usuarioSessao = new UsuarioSessaoDto();
    }    

    @PostConstruct
    public void iniciar() {

    }

    @PreDestroy
    public void destruir() {
        FacesContext ct = FacesContext.getCurrentInstance();
        ct.addMessage(null, new FacesMessage("Sessão Expirada", ""));
        this.callLogout();
    }

    public String callLogout() {
        FacesContext ct = FacesContext.getCurrentInstance();

        ct.getExternalContext().invalidateSession();

        return "login?faces-redirect=true";

    }
    
    public String callViewCadastro(){
        return "cadastro?faces-redirect=true";
    }
    
    public String callViewLaboratorio(){
        return "laboratorio?faces-redirect=true";
    }
    
    public String autenticaUsuario(){
        
        FacesContext ct = FacesContext.getCurrentInstance();
        
        String prontuario = usuarioSessao.getProntuario();
        String senha = usuarioSessao.getSenha();
        
        try {
            this.usuarioSessao = uDao.buscarPorProntuarioESenha(prontuario, senha);
            if (usuarioSessao != null) {
                this.usuarioSessao.setSenha("");
                if (ehFuncionarioCadastral()){
                    return "cadastro?faces-redirect=true";
                }                    
                return "laboratorio?faces-redirect=true";
            }
            
        } catch (Exception e) {
            ct.addMessage(null, new FacesMessage("Login ou senha incorretas!", ""));
        }       
        return "";
    }
    
    public boolean ehFuncionarioCadastral(){
        return this.usuarioSessao.getFuncao().equals(EFuncao.ATENDENTE);
    }
    
    public boolean ehFuncionarioTecnico(){
        return !this.usuarioSessao.getFuncao().equals(EFuncao.ATENDENTE);
    }

    public UsuarioSessaoDto getUsuarioSessao() {
        return usuarioSessao;
    }

    public void setUsuarioSessao(UsuarioSessaoDto usuarioSessao) {
        this.usuarioSessao = usuarioSessao;
    }

    public UsuarioDao getuDao() {
        return uDao;
    }

    public void setuDao(UsuarioDao uDao) {
        this.uDao = uDao;
    }
    
    
}
