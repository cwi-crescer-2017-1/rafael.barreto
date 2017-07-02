/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author rafael.barreto
 */

@Entity
public class Usuario {
    private static final String SQ_NAME = "SQ_USUARIO";
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")        
    private long usuarioId;
    
    @Basic(optional = false)
    @Column(name = "NOME")        
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    
    @Basic(optional = true)
    @Column(name = "SEXO")
    private String sexo;
    
    @Basic(optional = false)
    @Column(name = "SENHA")            
    private String senha;
                                                                                                                                                                                 
    @Basic(optional = false)
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;
    
    @OneToMany(mappedBy = "usuario")
    @Basic(optional = true) 
    @JsonIgnore
    private Set<Post> postagem;
    

    public long getUsuarioIdId() {
        return usuarioId;
    }

    public void setUsuarioId(long id) {
        this.usuarioId = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Set<Post> getPostagem() {
        return postagem;
    }

    public void setPostagem(Set<Post> postagem) {
        this.postagem = postagem;
    }

    public void adicionarPostagem(Post post){
        this.postagem.add(post);
    }
    
}
