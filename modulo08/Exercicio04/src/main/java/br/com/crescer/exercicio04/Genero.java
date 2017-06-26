/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio04;

/**
 *
 * @author usuario
 */
public class Genero {
    int Id;
    String Descricao;
    
    public Genero (int id, String descricao){
        this.Id = id;
        this.Descricao = descricao;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    
}
