/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.domain.usuario.dto;

import br.vianna.aula.jsf.model.domain.usuario.EFuncao;

/**
 *
 * @author thiago
 */
public class UsuarioSessaoDto {
    
    private int id;
    private String nome;
    private String prontuario;
    private String senha;
    private EFuncao funcao;

    public UsuarioSessaoDto() {
    }

    public UsuarioSessaoDto(int id, String nome, String prontuario, String senha, EFuncao funcao) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
