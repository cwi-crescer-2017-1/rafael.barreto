

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AtaqueDuploTest
{
    @Test 
    public void testeAtaqueDuplo(){
        Saint ikki = new BronzeSaint("ikki","fenix");
        Saint seiya = new BronzeSaint("seiya","pegaso");
        
        ikki.aprenderGolpe(new Golpe("golpe diabolico",5));
        ikki.aprenderGolpe(new Golpe("ave Fenix",15));        
        
        ikki.golpear(seiya);
        ikki.adicionarMovimento(new AtaqueDuplo(ikki,seiya));
        
        ikki.getProximoMovimento().executar();
        ikki.getProximoMovimento().executar();
        ikki.getProximoMovimento().executar();
        
        assertEquals(50,seiya.getVida(),0.01);
    }
    
     @Test (expected = NullPointerException.class) 
    public void testeAtaqueDuploSemGolpe(){
        Saint ikki = new BronzeSaint("ikki","fenix");
        Saint seiya = new BronzeSaint("seiya","pegaso");  
        
        ikki.golpear(seiya);
        ikki.adicionarMovimento(new AtaqueDuplo(ikki,seiya));
        
        ikki.getProximoMovimento().executar();
        ikki.getProximoMovimento().executar();
        ikki.getProximoMovimento().executar();
        
        assertEquals(100,seiya.getVida(),0.01);
    }
    
    @Test 
    public void testeAtaqueDuploArmaduraVestida(){
        Saint ikki = new BronzeSaint("ikki","fenix");
        Saint seiya = new BronzeSaint("seiya","pegaso");
        
        ikki.aprenderGolpe(new Golpe("golpe diabolico",5));
        ikki.aprenderGolpe(new Golpe("ave Fenix",15));        
        
        ikki.vestirArmadura();
        ikki.golpear(seiya);        
        ikki.adicionarMovimento(new AtaqueDuplo(ikki,seiya));
        
        ikki.getProximoMovimento().executar();
        ikki.getProximoMovimento().executar();
        ikki.getProximoMovimento().executar();
        
        assertEquals(60,seiya.getVida(),0.01);
    }
}
