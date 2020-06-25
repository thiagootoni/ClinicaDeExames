/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.domain.laboratorio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author thiago
 */
@Entity
public class Paciente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String nome;
    
    private String telefone;
    
    @Column(nullable = false)
    private String cpf;
    
    @Column(nullable = false,columnDefinition = "DATE")
    private LocalDate dataNascimento;
    
    private boolean acimaDeSessentaAnos;
    
    @Column(nullable = false)
    private boolean temComorbidades;
    
    private boolean grupoDeRisco;
    
    private boolean marcadoParaRecoleta;
    
    @OneToMany(mappedBy = "paciente")
    private List<Coleta> coletas;

    public Paciente() {
        this(0, "", "", "", LocalDate.parse("01/01/1990"), false, false, false, false, new ArrayList<Coleta>());
    }

    public Paciente(int id, String nome, String telefone, String cpf, LocalDate dataNascimento, boolean acimaDeSessentaAnos, boolean temComorbidades, boolean grupoDeRisco, boolean marcadoParaRecoleta, List<Coleta> coletas) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.acimaDeSessentaAnos = acimaDeSessentaAnos;
        this.temComorbidades = temComorbidades;
        this.grupoDeRisco = grupoDeRisco;
        this.marcadoParaRecoleta = marcadoParaRecoleta;
        this.coletas = coletas;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isAcimaDeSessentaAnos() {
        return acimaDeSessentaAnos;
    }

    public void setAcimaDeSessentaAnos(boolean acimaDeSessentaAnos) {
        this.acimaDeSessentaAnos = acimaDeSessentaAnos;
    }

    public boolean isTemComorbidades() {
        return temComorbidades;
    }

    public void setTemComorbidades(boolean temComorbidades) {
        this.temComorbidades = temComorbidades;
    }

    public boolean isGrupoDeRisco() {
        return grupoDeRisco;
    }

    public void setGrupoDeRisco(boolean grupoDeRisco) {
        this.grupoDeRisco = grupoDeRisco;
    }

    public boolean isMarcadoParaRecoleta() {
        return marcadoParaRecoleta;
    }

    public void setMarcadoParaRecoleta(boolean marcadoParaRecoleta) {
        this.marcadoParaRecoleta = marcadoParaRecoleta;
    }

    public List<Coleta> getColetas() {
        return coletas;
    }

    public void setColetas(List<Coleta> coletas) {
        this.coletas = coletas;
    }

    
      
    
    
}
