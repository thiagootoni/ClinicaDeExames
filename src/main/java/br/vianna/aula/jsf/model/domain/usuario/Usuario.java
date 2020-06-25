/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.domain.usuario;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author thiago
 */
@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String prontuario;
    
    @Column(nullable = false)
    private String senha;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EFuncao funcao;

    public Usuario() {
        this(0, "", "", "", EFuncao.ATENDENTE);
    }

    public Usuario(int id, String nome, String prontuario, String senha, EFuncao funcao) {
        this.id = id;
        this.nome = nome;
        this.prontuario = prontuario;
        this.senha = senha;
        this.funcao = funcao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EFuncao getFuncao() {
        return funcao;
    }

    public void setFuncao(EFuncao funcao) {
        this.funcao = funcao;
    }

    
        
}
