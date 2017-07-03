/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entidade;

import java.util.Date;

/**
 *
 * @author rafa
 */
public class PostRetorno extends Post{
    
    private String nomeUsuario;
    private long idUsuario;
    private Date dataPostagem;
    private long idPostagem;
    private String Postagem;

    public PostRetorno(String nomeUsuario, long idUsuario, Date dataPostagem, long idPostagem, String Postagem) {
        this.nomeUsuario = nomeUsuario;
        this.idUsuario = idUsuario;
        this.dataPostagem = dataPostagem;
        this.idPostagem = idPostagem;
        this.Postagem = Postagem;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public long getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(long idPostagem) {
        this.idPostagem = idPostagem;
    }

    public String getPostagem() {
        return Postagem;
    }

    public void setPostagem(String Postagem) {
        this.Postagem = Postagem;
    }
    
}
