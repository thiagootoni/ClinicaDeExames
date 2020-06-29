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
public enum EStatusColeta {
    VALIDA("Válida"), 
    VENCIDA("Vencida"), 
    EM_ANALISE("Em análise"), 
    COM_RESULTADO("Com resultado"),
    INVALIDA("Inválida");
    
    private String descricao;

    private EStatusColeta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
}
