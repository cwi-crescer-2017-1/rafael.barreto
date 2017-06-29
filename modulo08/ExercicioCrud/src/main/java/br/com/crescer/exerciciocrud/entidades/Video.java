/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exerciciocrud.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author rafael.barreto
 */
@Entity
@Table(name="VIDEO")
public class Video implements Serializable {
    
    private static final String SQ_NAME = "SQ_VIDEO";
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_VIDEO")
    private long Id;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String Nome;

    @Basic(optional = false)
    @Column(name = "VALOR")
    private double Valor;
    
    @Basic(optional = false)
    @Column(name = "DURACAO")
    private String Duracao;
    
    @Basic(optional = false)
    @Column(name = "ID_GENERO")
    private long IdGenero;
    
    @Basic(optional = false)
    @Column(name = "QUANTIDADE_ESTOQUE")
    private long QuantidadeEstoque;
    
    @Basic(optional = false)
    @Column(name = "DATA_LANCAMENTO")
    private Date DataLancamento;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public String getDuracao() {
        return Duracao;
    }

    public void setDuracao(String Duracao) {
        this.Duracao = Duracao;
    }

    public long getIdGenero() {
        return IdGenero;
    }

    public void setIdGenero(long IdGenero) {
        this.IdGenero = IdGenero;
    }

    public long getQuantidadeEstoque() {
        return QuantidadeEstoque;
    }

    public void setQuantidadeEstoque(long QuantidadeEstoque) {
        this.QuantidadeEstoque = QuantidadeEstoque;
    }

    public Date getDataLancamento() {
        return DataLancamento;
    }

    public void setDataLancamento(Date DataLancamento) {
        this.DataLancamento = DataLancamento;
    }
    
}
