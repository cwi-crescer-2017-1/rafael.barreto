/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Post;
import br.com.crescer.social.repositorio.PostRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class PostService {
    
    @Autowired
    PostRepositorio postRep;
    
    public void postar(Post post){
        post.setData();
        postRep.save(post);
    }

    public List<Post> buscarPostagem() {
       return (List<Post>) postRep.findAll();
    }    
    
}
