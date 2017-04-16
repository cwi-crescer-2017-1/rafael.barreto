

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BatalhaTest
{
       @Test
        public void testeDaBatalhaSaintCategoriaDiferenteBronzeXOuro(){
            Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
            Saint shiryu = new Saint ("Shiryu",dragao);
            
            Armadura virgem = new Armadura ("virgem",Categoria.OURO);
            Saint shaka = new Saint ("shaka",virgem);
            
            Batalha batalha = new Batalha();
            
            batalha.iniciar(shaka,shiryu);
            
            assertEquals(100,0,shaka.getVida());
            assertEquals(90,0,shiryu.getVida());
            
        }
        
        @Test
        public void testeDaBatalhaSaintCategoriaDiferenteOuroXBronze(){
            Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
            Saint shiryu = new Saint ("Shiryu",dragao);
            
            Armadura virgem = new Armadura ("virgem",Categoria.OURO);
            Saint shaka = new Saint ("shaka",virgem);
            
            Batalha batalha = new Batalha();
            
            batalha.iniciar(shiryu,shaka);
            
            assertEquals(100,0,shaka.getVida());
            assertEquals(90,0,shiryu.getVida());
            
        }
        
        @Test
        public void testeDaBatalhaSaintCategoriaDiferenteOuroXPrata(){
            Armadura virgem = new Armadura ("virgem",Categoria.OURO);
            Saint shaka = new Saint ("shaka",virgem);
            
            Armadura caesDeCaca = new Armadura ("caes de caca",Categoria.PRATA);
            Saint asterion = new Saint ("Asterion",caesDeCaca);
            
            Batalha batalha = new Batalha();
            
            batalha.iniciar(shaka,asterion);
            
            assertEquals(100,0,shaka.getVida());
            assertEquals(90,0,asterion.getVida());
            
        }
        
        @Test
        public void testeDaBatalhaSaintCategoriaDiferentePrataXOuro(){
            Armadura virgem = new Armadura ("virgem",Categoria.OURO);
            Saint shaka = new Saint ("shaka",virgem);
            
            Armadura caesDeCaca = new Armadura ("caes de caca",Categoria.PRATA);
            Saint asterion = new Saint ("Asterion",caesDeCaca);
            
            Batalha batalha = new Batalha();
            
            batalha.iniciar(asterion,shaka);
            
            assertEquals(100,0,shaka.getVida());
            assertEquals(90,0,asterion.getVida());
            
        }
        
        @Test
        public void testeDaBatalhaSaintCategoriaDiferentePrataXBronze(){
            Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
            Saint shiryu = new Saint ("Shiryu",dragao);
            
            Armadura caesDeCaca = new Armadura ("caes de caca",Categoria.PRATA);
            Saint asterion = new Saint ("Asterion",caesDeCaca);
            
            Batalha batalha = new Batalha();
            
            batalha.iniciar(asterion,shiryu);
            
            assertEquals(100,0,asterion.getVida());
            assertEquals(90,0,shiryu.getVida());
            
        }
        
        @Test
        public void testeDaBatalhaSaintCategoriaDiferenteBronzeXPrata(){
            Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
            Saint shiryu = new Saint ("Shiryu",dragao);
            
            Armadura caesDeCaca = new Armadura ("caes de caca",Categoria.PRATA);
            Saint asterion = new Saint ("Asterion",caesDeCaca);
            
            Batalha batalha = new Batalha();
            
            batalha.iniciar(shiryu,asterion);
            
            assertEquals(100,0,asterion.getVida());
            assertEquals(90,0,shiryu.getVida());
            
        }
        
        @Test
        public void testeBatalhaSaintMesmaCategoriaBronze(){
            Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
            Saint shiryu = new Saint ("Shiryu",dragao);
            
            Armadura pegaso = new Armadura ("Pegaso",Categoria.BRONZE);
            Saint seiya = new Saint ("seiya",pegaso);
            
            Batalha batalha = new Batalha();
            
            batalha.iniciar(seiya,shiryu);
            
            assertEquals(100,0,seiya.getVida());
            assertEquals(90,0,shiryu.getVida());
        }    
        
        @Test
        public void testeBatalhaSaintMesmaCategoriaPrata(){
            Armadura altar = new Armadura ("Altar",Categoria.PRATA);
            Saint harukei = new Saint ("Harukei",altar);
            
            Armadura caesDeCaca = new Armadura ("caes de caca",Categoria.PRATA);
            Saint asterion = new Saint ("Asterion",caesDeCaca);
            
            Batalha batalha = new Batalha();
            
            batalha.iniciar(asterion,harukei);
            
            assertEquals(100,0,asterion.getVida());
            assertEquals(90,0,harukei.getVida());
        }  
        
        @Test
        public void testeBatalhaSaintMesmaCategoriaOuro(){
            Armadura escorpiao   = new Armadura ("Escorpiao",Categoria.OURO);
            Saint milo = new Saint ("Milo",escorpiao);
            
            Armadura cancer = new Armadura ("Cancer",Categoria.OURO);
            Saint mascaraDaMorte = new Saint ("Mascara da Morte",cancer);
            
            Batalha batalha = new Batalha();
            
            batalha.iniciar(mascaraDaMorte,milo);
            
            assertEquals(100,0,mascaraDaMorte.getVida());
            assertEquals(90,0,milo.getVida());
        }  
}
