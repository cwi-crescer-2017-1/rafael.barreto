/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repositorio;

import br.com.crescer.social.entidade.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rafael.barreto
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

     public Usuario findOneByEmail(String email);
    
}
