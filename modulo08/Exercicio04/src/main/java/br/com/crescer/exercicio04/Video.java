/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio04;

import java.util.Date;

/**
 *
 * @author usuario
 */
public class Video {
    String nome;
    int Id;
    long Valor;
    String Duracao;
    int Idgenero;
    int QuantidadeEstoque;
    Date DataLancamento;
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public long getValor() {
        return Valor;
    }

    public void setValor(long Valor) {
        this.Valor = Valor;
    }

    public String getDuracao() {
        return Duracao;
    }

    public void setDuracao(String Duracao) {
        this.Duracao = Duracao;
    }

    public int getIdgenero() {
        return Idgenero;
    }

    public void setIdgenero(int Idgenero) {
        this.Idgenero = Idgenero;
    }

    public int getQuantidadeEstoque() {
        return QuantidadeEstoque;
    }

    public void setQuantidadeEstoque(int QuantidadeEstoque) {
        this.QuantidadeEstoque = QuantidadeEstoque;
    }

    public Date getDataLancamento() {
        return DataLancamento;
    }

    public void setDataLancamento(Date DataLancamento) {
        this.DataLancamento = DataLancamento;
    }   
    
}
