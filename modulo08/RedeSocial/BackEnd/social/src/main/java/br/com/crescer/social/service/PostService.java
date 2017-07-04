/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Post;
import br.com.crescer.social.entidade.PostBusca;
import br.com.crescer.social.repositorio.PostRepositorio;
import br.com.crescer.social.repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Autowired
    UsuarioRepositorio userRep;

    public void postar(PostBusca post) {
        Post postar = new Post();
        postar.setData();
        postar.setUsuario(userRep.findOneByEmail(post.getEmail()));
        postar.setPostagem(post.getPostagem());
        postRep.save(postar);        
    }

    public List buscarPostagem() {
        return (List)postRep.findAll();
    }
}

//posts.add(new PostRetorno(
//                    post.getUsuario().getNome(),
//                    post.getUsuario().getUsuarioIdId(),
//                    post.getData(),
//                    post.getId(),
//                    post.getPostagem()
