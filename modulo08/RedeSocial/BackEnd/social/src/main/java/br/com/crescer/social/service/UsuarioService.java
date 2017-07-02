/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Post;
import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.repositorio.PostRepositorio;
import br.com.crescer.social.repositorio.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafael.barreto
 */
@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepositorio repositorio;
    @Autowired
    PostRepositorio postRep;
    
    public void novoUsuario(Usuario u){
        u.setSenha(new BCryptPasswordEncoder().encode(u.getSenha()));        
        repositorio.save(u);
    }
    
    public Usuario buscarUsuario(long id){       
        return repositorio.findOne(id);
    }
    
    public Usuario buscarPorEmail(String email){
        return repositorio.findByEmail(email);
    }

    public List<Usuario> listarUsuario() {
        return (List)repositorio.findAll();
    }

    public void novaPostagem(Post post) {
        post.setData();                        
        postRep.save(post);
    }
    
}
