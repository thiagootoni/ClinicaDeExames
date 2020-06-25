/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.domain.laboratorio.enuns;

/**
 *
 * @author thiago
 */
public enum EStatusTeste {
    LACRADO("Lacrado"), USADO("Usado");
    
    private final String descricao;

    EStatusTeste(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
}
