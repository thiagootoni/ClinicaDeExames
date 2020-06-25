/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.domain.laboratorio;

import br.vianna.aula.jsf.model.domain.laboratorio.enuns.EResultadoTeste;
import br.vianna.aula.jsf.model.domain.laboratorio.enuns.EStatusTeste;
import br.vianna.aula.jsf.model.domain.usuario.Usuario;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author thiago
 */
@Entity
public class Teste implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "coleta_id")
    private Coleta coleta;
    
    @Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataHoraTeste;
    
    @Enumerated(EnumType.STRING)
    private EResultadoTeste resultado;
    
    @Enumerated(EnumType.STRING)
    private EStatusTeste statusTeste = EStatusTeste.LACRADO;
    
    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Usuario resposavelTecnico;

    public Teste() {
        this(0, new Coleta(), LocalDateTime.now(), EResultadoTeste.NAO_DETECTADO, new Usuario());
    }

    public Teste(int id, Coleta coleta, LocalDateTime dataHoraTeste, EResultadoTeste resultado, Usuario resposavelTecnico) {
        this.id = id;
        this.coleta = coleta;
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

    public Coleta getColeta() {
        return coleta;
    }

    public void setColeta(Coleta coleta) {
        this.coleta = coleta;
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

    public EStatusTeste getStatusTeste() {
        return statusTeste;
    }

    public void setStatusTeste(EStatusTeste statusTeste) {
        this.statusTeste = statusTeste;
    }

    public Usuario getResposavelTecnico() {
        return resposavelTecnico;
    }

    public void setResposavelTecnico(Usuario resposavelTecnico) {
        this.resposavelTecnico = resposavelTecnico;
    }   
    
    
}
