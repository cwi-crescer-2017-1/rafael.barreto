/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exerciciocrud.entidades;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author usuario
 */

@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQGENERO")
    @SequenceGenerator(name = "SQGENERO", sequenceName = "SEQ_GENERO", allocationSize = 1)
    @Basic(optional = false)
    private long id;

    @Basic(optional = false)
    private String descricao;    
    
    public Genero() {        
    }

    public Genero(String descricao) {
        this.descricao = descricao;
    }

    public Genero(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
