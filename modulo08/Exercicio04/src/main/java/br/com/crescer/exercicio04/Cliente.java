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
public class Cliente extends Pessoa {
    
    public Cliente(String nome, Date data, String bairro, String cidade, String numero, String rua, String rg, String email, String telefone, String celular, String cpf) {
        super(nome, data, bairro, cidade, numero, rua, rg, email, telefone, celular, cpf);
    }
}
