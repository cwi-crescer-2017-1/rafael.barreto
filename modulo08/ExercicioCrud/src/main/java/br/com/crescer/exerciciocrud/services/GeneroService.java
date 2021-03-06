/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exerciciocrud.services;


import br.com.crescer.exerciciocrud.Repositorio.GeneroRepositorio;
import br.com.crescer.exerciciocrud.entidades.Genero;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafael.barreto
 */

@Service
public class GeneroService {

    @Autowired            
    GeneroRepositorio generoRepositorio;    

    public List<Genero> ListarGenero() {        
        return (List<Genero>) generoRepositorio.findAll();
    }
    
    public Genero NovoGenero(Genero g){
       return generoRepositorio.save(g);        
    }    
}
