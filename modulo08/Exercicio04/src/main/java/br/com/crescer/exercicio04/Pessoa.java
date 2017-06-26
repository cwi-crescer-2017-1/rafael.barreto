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
public abstract class Pessoa {
    private int Id;
    private String Nome; 
    private Date DataNascimento;
    private String Bairro;
    private String Cidade;
    private String NumeroDaCasa;
    private String Rua;    
    private String Rg;
    private String Email;
    private String Telefone;
    private String Celular;       
    private String Cpf;
    
    public Pessoa(String nome, Date data, String bairro,String cidade,String numero, String rua,String rg,String email,String telefone,String celular,String cpf){
       this.Nome = nome;
       this.DataNascimento = data;
       this.Bairro = bairro;
       this.Celular = celular;
       this.Cidade = cidade;
       this.Cpf = cpf;
       this.Email = email;
       this.NumeroDaCasa = numero;
       this.Rg = rg;
       this.Rua = rua;
       this.Telefone = telefone;        
    }
    
    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getNumeroDaCasa() {
        return NumeroDaCasa;
    }

    public void setNumeroDaCasa(String NumeroDaCasa) {
        this.NumeroDaCasa = NumeroDaCasa;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }    
     
}
