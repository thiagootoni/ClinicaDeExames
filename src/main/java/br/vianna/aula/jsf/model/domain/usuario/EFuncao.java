/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.domain.usuario;

/**
 *
 * @author thiago
 */
public enum EFuncao {
    TECNICO("Técnico"), SUPERVISOR("Supervisor"), ATENDENTE("Atendente");
    
    private String descricao;
    
    EFuncao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }  
    
}
