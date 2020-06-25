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
public enum ETipoMaterial {
    ASPIRADO_TRAQUEAL("Aspirado traqueal"), 
    ASPIRADO_BRONQUICO("Aspirado brônquico"),
    ASPIRADO_NASO_FARINEO("Aspirado naso-faríngeo"),
    SECRECAO_TRAQUEAL("Secreção traqueal"),
    ESCARRO("Escarro"),
    LAVADO_BRONCOALVELAR("Lavado brocoalvelar"),    
    SWAB_COMBINADO("Swab combinado"),
    SWAB_NASOFARINGE("Swab nasorfainge");
    
    private final String descricao;
    
    ETipoMaterial(String tipo){
        this.descricao = tipo;
    }

    public String getDescricao() {
        return descricao;
    }  
    
}
