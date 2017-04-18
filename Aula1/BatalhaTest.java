

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BatalhaTest
{
        @Test
        public void categoria1MaiorQueCategoria2() throws Exception{
        Golpe meteoroPegaso = new Golpe("Meteoro de pegaso",10);
        Golpe exclamacaoAthena = new Golpe("Exclamaçao de Athena ",70);
        Golpe cometaPegaso = new Golpe("Cometa de Pegaso",30);
            
        Saint seiya = new Saint ("Seiya",new Armadura (new Constelacao("pegaso",meteoroPegaso,exclamacaoAthena,cometaPegaso),Categoria.BRONZE));
        Saint shaina = new Saint ("Shaina",new Armadura (new Constelacao("pegaso",meteoroPegaso,exclamacaoAthena,cometaPegaso),Categoria.PRATA));       
        Batalha batalha1 = new Batalha(shaina,seiya);

        batalha1.iniciar();

        assertEquals(100.0,shaina.getVida(),0.01);
        assertEquals(90.0,seiya.getVida(),0.01);
        }

        @Test
        public void categoriasIguais() throws Exception{
        Golpe grandeChifre = new Golpe("Grande Chifre",10);
        Golpe grandeSoco = new Golpe("Grande Chifre",10);
        Golpe grandeChute = new Golpe("Grande Chifre",10);            
        Saint aldebaram = new Saint ("aldebaram",new Armadura (new Constelacao("Touro",grandeChifre,grandeChute,grandeSoco),Categoria.OURO));
        
        Golpe muralhaCelestial = new Golpe("Muralha Celestial",20);
        Golpe extincaoEstelar = new Golpe("Extincao estelar",45);
        Golpe revolucaoEstelar = new Golpe("Revolucao Estelar",60);
        Saint mu = new Saint ("Mu",new Armadura (new Constelacao("Aries",muralhaCelestial,extincaoEstelar,revolucaoEstelar),Categoria.OURO));
        Batalha batalha = new Batalha (aldebaram,mu);

        batalha.iniciar();

        assertEquals(100.0,aldebaram.getVida(),0.01);
        assertEquals(90.0,mu.getVida(),0.01);
      }
}
