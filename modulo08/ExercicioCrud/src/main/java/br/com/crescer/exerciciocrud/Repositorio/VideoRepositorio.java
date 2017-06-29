/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exerciciocrud.Repositorio;

import br.com.crescer.exerciciocrud.entidades.Video;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rafael.barreto
 */
public interface VideoRepositorio extends CrudRepository<Video, Long>{
    
}
