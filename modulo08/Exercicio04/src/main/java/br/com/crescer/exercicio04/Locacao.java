/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio04;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author usuario
 */
public class Locacao {
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    int Id;
    
    @Basic(optional = false)
    @Column(name = "VALOR_TOTAL")
    long ValorTotal;    
    
    @Basic(optional = false)
    @Column(name = "ID_FUNCIONARIO")
    int FuncionarioId;
    
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    int ClienteId;
    
    @Basic(optional = false)
    @Column(name = "ID_VIDEO")
    int VideId;

    public Locacao(int Id, long ValorTotal, int FuncionarioId, int ClienteId, int VideId) {
        this.Id = Id;
        this.ValorTotal = ValorTotal;
        this.FuncionarioId = FuncionarioId;
        this.ClienteId = ClienteId;
        this.VideId = VideId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public long getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(long ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public int getFuncionarioId() {
        return FuncionarioId;
    }

    public void setFuncionarioId(int FuncionarioId) {
        this.FuncionarioId = FuncionarioId;
    }

    public int getClienteId() {
        return ClienteId;
    }

    public void setClienteId(int ClienteId) {
        this.ClienteId = ClienteId;
    }

    public int getVideId() {
        return VideId;
    }

    public void setVideId(int VideId) {
        this.VideId = VideId;
    }
}
