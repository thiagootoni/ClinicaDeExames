/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.domain.laboratorio.dto;

import br.vianna.aula.jsf.model.domain.laboratorio.enuns.EResultadoTeste;
import br.vianna.aula.jsf.model.domain.usuario.Usuario;
import java.time.LocalDateTime;

/**
 *
 * @author thiago
 */
public class TesteDto {
 
    private int id;
    private LocalDateTime dataHoraTeste;
    private EResultadoTeste resultado;
    private Usuario resposavelTecnico;

    public TesteDto() {
    }

    public TesteDto(int id, LocalDateTime dataHoraTeste, EResultadoTeste resultado, Usuario resposavelTecnico) {
        this.id = id;
        this.dataHoraTeste = dataHoraTeste;
        this.resultado = resultado;
        this.resposavelTecnico = resposavelTecnico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraTeste() {
        return dataHoraTeste;
    }

    public void setDataHoraTeste(LocalDateTime dataHoraTeste) {
        this.dataHoraTeste = dataHoraTeste;
    }

    public EResultadoTeste getResultado() {
        return resultado;
    }

    public void setResultado(EResultadoTeste resultado) {
        this.resultado = resultado;
    }

    public Usuario getResposavelTecnico() {
        return resposavelTecnico;
    }

    public void setResposavelTecnico(Usuario resposavelTecnico) {
        this.resposavelTecnico = resposavelTecnico;
    }
    
    
    
}
