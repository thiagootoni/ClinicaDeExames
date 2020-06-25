/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.domain.laboratorio;

import br.vianna.aula.jsf.model.domain.laboratorio.enuns.ETipoMaterial;
import br.vianna.aula.jsf.model.domain.laboratorio.enuns.EStatusColeta;
import br.vianna.aula.jsf.model.domain.usuario.Usuario;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    private ETipoMaterial tipoMaterial;
    
    @Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataHoraColeta;
    
    @Enumerated(EnumType.STRING)
    private EStatusColeta statusColeta = EStatusColeta.VALIDA;
    
    @OneToMany(mappedBy = "coleta")
    private List<Teste> testes;
    
    @OneToOne
    @JoinColumn(name = "teste_id")
    private Teste testeResultadoFinal;
    
    
}
