/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repositorio;

import br.com.crescer.social.entidade.Post;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author usuario
 */
public interface PostRepositorio extends CrudRepository<Post, Long> {
    
}
