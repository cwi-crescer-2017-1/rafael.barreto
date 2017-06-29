/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exerciciocrud.Controller;
import br.com.crescer.exerciciocrud.entidades.Video;
import br.com.crescer.exerciciocrud.services.VideoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael.barreto
 */

@RestController
@RequestMapping("/video")
public class VideoController {   
    
    @Autowired
    VideoService service;
    
    @GetMapping
    public List<Video> getVideos(){
        return service.listarVideos();
    } 
    
    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody Video video){
        service.Cadastrar(video);
    }    
}
