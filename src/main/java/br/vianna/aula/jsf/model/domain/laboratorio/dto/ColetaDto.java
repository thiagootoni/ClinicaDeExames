/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.domain.laboratorio.dto;

import br.vianna.aula.jsf.controller.enuns.EEstadoPgLaboratorio;
import br.vianna.aula.jsf.model.domain.laboratorio.enuns.EStatusColeta;
import java.time.LocalDateTime;

/**
 *
 * @author thiago
 */
public class ColetaDto {
    
    private int id;
    private LocalDateTime dataHoraColeta;
    private EStatusColeta statusColeta;

    public ColetaDto() {
        this.statusColeta = EStatusColeta.VALIDA;
    }

    public ColetaDto(int id, LocalDateTime dataHoraColeta, EStatusColeta statusColeta) {
        this.id = id;
        this.dataHoraColeta = dataHoraColeta;
        this.statusColeta = statusColeta;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraColeta() {
        return dataHoraColeta;
    }

    public void setDataHoraColeta(LocalDateTime dataHoraColeta) {
        this.dataHoraColeta = dataHoraColeta;
    }

    public EStatusColeta getStatusColeta() {
        return statusColeta;
    }

    public void setStatusColeta(EStatusColeta statusColeta) {
        this.statusColeta = statusColeta;
    }
    
}
