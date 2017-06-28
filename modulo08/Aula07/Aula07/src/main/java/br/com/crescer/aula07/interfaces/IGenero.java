/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.interfaces;

import br.com.crescer.aula07.entidades.Genero;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rafael.barreto
 */
public interface IGenero extends CrudRepository<Genero, Long>{
    
}
