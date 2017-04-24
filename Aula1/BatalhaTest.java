import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BatalhaTest
{
        @Test
        public void batalhaSaintPrataXSaintBronzeComArmadura() throws Exception{
        Golpe meteoroPegaso = new Golpe("Meteoro de pegaso",10);
        Golpe exclamacaoAthena = new Golpe("Exclamacao de Athena ",30);
        Golpe cometaPegaso = new Golpe("Cometa de Pegaso",30);
            
        Saint seiya = new BronzeSaint("seiya","pegaso");
        Saint shaina = new SilverSaint("Shaina","Cobra");
        
        seiya.vestirArmadura();
        shaina.vestirArmadura();
        
        seiya.aprenderGolpe(meteoroPegaso);
        shaina.aprenderGolpe(exclamacaoAthena);
        
        Batalha luta = new Batalha(shaina,seiya);
        luta.iniciar();
        
        
        assertEquals(80.0,shaina.getVida(),0.01);
        assertEquals(0.0,seiya.getVida(),0.01);
        }

       @Test
       public void categoriasIguais() throws Exception{                 
       Golpe meteoroPegaso = new Golpe("Meteoro de pegaso",10);
       Golpe exclamacaoAthena = new Golpe("Exclamacao de Athena ",30);
       Golpe correnteDeAndromeda = new Golpe("Corrente de Andromeda",15);
            
        BronzeSaint seiya = new BronzeSaint("seiya","pegaso");
        BronzeSaint shun = new BronzeSaint("Shun","Andromeda");
        
        seiya.vestirArmadura();
        shun.vestirArmadura();
        
        seiya.aprenderGolpe(meteoroPegaso);
        seiya.aprenderGolpe(exclamacaoAthena);
        shun.aprenderGolpe(correnteDeAndromeda);
        
        Batalha luta = new Batalha(shun,seiya);
        luta.iniciar();        
        
        assertEquals(0.0,shun.getVida(),0.01);
        assertEquals(10.0,seiya.getVida(),0.01);
      }
      
      @Test
       public void batalhaSemArmadura() throws Exception{                 
       Golpe meteoroPegaso = new Golpe("Meteoro de pegaso",10);
       Golpe exclamacaoAthena = new Golpe("Exclamacao de Athena ",30);
       Golpe correnteDeAndromeda = new Golpe("Tesouro do ceu",25);
            
        BronzeSaint seiya = new BronzeSaint("seiya","pegaso");
        GoldSaint shaka = new GoldSaint ("Shaka","Virgem");     
        
        seiya.aprenderGolpe(meteoroPegaso);       
        shaka.aprenderGolpe(correnteDeAndromeda);
        
        Batalha luta = new Batalha(shaka,seiya);
        luta.iniciar();        
        
        assertEquals(70.0,shaka.getVida(),0.01);
        assertEquals(0.0,seiya.getVida(),0.01);
      }
      
       @Test(expected = NullPointerException.class)
       public void batalhaSemGolpesLancaNullPointerException() throws Exception,NullPointerException{                 
       Golpe meteoroPegaso = new Golpe("Meteoro de pegaso",10);
       Golpe exclamacaoAthena = new Golpe("Exclamacao de Athena ",30);
       Golpe correnteDeAndromeda = new Golpe("Tesouro do ceu",25);
            
        BronzeSaint seiya = new BronzeSaint("seiya","pegaso");
        GoldSaint shaka = new GoldSaint ("Shaka","Virgem");
        
        Batalha luta = new Batalha(shaka,seiya);
        luta.iniciar(); 
      }
}
