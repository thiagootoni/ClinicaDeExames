/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.domain.laboratorio;

import br.vianna.aula.jsf.model.domain.laboratorio.enuns.ETipoMaterial;
import br.vianna.aula.jsf.model.domain.laboratorio.enuns.EStatusColeta;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author thiago
 */
@Entity
public class Coleta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    
    @Enumerated(EnumType.STRING)
    private ETipoMaterial tipoMaterial = ETipoMaterial.ESCARRO;
    
    @Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataHoraColeta;
    
    @Enumerated(EnumType.STRING)
    private EStatusColeta statusColeta = EStatusColeta.VALIDA;
    
    @OneToMany(mappedBy = "coleta")
    private List<Teste> testes;
    
    @OneToOne
    @JoinColumn(name = "teste_id")
    private Teste testeResultadoFinal;

    public Coleta() {
        this.testes = new ArrayList<>();
        this.dataHoraColeta = LocalDateTime.now();
    }

    public Coleta(int id, Paciente paciente, ETipoMaterial tipoMaterial, LocalDateTime dataHoraColeta, List<Teste> testes, Teste testeResultadoFinal) {
        this.id = id;
        this.paciente = paciente;
        this.tipoMaterial = tipoMaterial;
        this.dataHoraColeta = dataHoraColeta;
        this.testes = testes;
        this.testeResultadoFinal = testeResultadoFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ETipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(ETipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
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

    public List<Teste> getTestes() {
        return testes;
    }

    public void setTestes(List<Teste> testes) {
        this.testes = testes;
    }

    public Teste getTesteResultadoFinal() {
        return testeResultadoFinal;
    }

    public void setTesteResultadoFinal(Teste testeResultadoFinal) {
        this.testeResultadoFinal = testeResultadoFinal;
    }
    
    
}
