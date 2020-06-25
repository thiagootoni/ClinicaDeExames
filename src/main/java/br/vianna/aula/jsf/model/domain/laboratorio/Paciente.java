/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.domain.laboratorio;

import java.io.Serializable;
import java.time.LocalDate;
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

      
    
    
}
