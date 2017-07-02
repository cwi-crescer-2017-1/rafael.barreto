/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entidade;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author usuario
 */
@Entity
public class Post {
    
    private static final String SQ_NAME = "SQ_POST";
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID") 
    private long postId;
    
    @Basic(optional = false)
    @Column(name = "POSTAGEM")
    private String Postagem;
    
    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    @Basic(optional = false)
    @Column(name = "DATA_POSTAGEM")
    private Date data;

    public long getId() {
        return postId;
    }

    public void setId(long id) {
        this.postId = id;
    }

    public String getPostagem() {
        return Postagem;
    }

    public void setPostagem(String Postagem) {
        this.Postagem = Postagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData() {        
        this.data = new Date(System.currentTimeMillis());
    }    
    
}
