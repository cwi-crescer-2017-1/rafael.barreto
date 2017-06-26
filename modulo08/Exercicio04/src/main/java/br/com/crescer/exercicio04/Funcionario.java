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
public class Funcionario extends Pessoa{
    long Salario;
    String Funcao;

    public Funcionario(String nome,String funcao,long salario, Date data, String bairro, String cidade, String numero, String rua, String rg, String email, String telefone, String celular, String cpf) {
        super(nome, data, bairro, cidade, numero, rua, rg, email, telefone, celular, cpf);
        this.Funcao = funcao;
        this.Salario = salario;
    }

    public long getSalario() {
        return Salario;
    }

    public void setSalario(long Salario) {
        this.Salario = Salario;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;        
    }
    
    
}
