/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula04;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author carloshenrique
 */
@Entity
public class Cliente implements Serializable {

    @Id // Identifica a PK
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NM_CLIENTE")
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
