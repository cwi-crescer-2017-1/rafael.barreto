

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
        
        AtaqueDuplo ataque = new AtaqueDuplo(ikki,seiya);
        ataque.executarTesteGolpeDuploTrue();
        
       
        
        assertEquals(90,seiya.getVida(),0.01);
    }
    
     @Test (expected = Exception.class) 
    public void testeAtaqueDuploSemGolpe(){
        Saint ikki = new BronzeSaint("ikki","fenix");
        Saint seiya = new BronzeSaint("seiya","pegaso");  
        
        ikki.golpear(seiya);
        ikki.adicionarMovimento(new AtaqueDuplo(ikki,seiya));
        
        AtaqueDuplo ataque = new AtaqueDuplo(ikki,seiya);
        ataque.executarTesteGolpeDuploTrue();
        
        
        assertEquals(100,seiya.getVida(),0.01);
    }
    
    @Test 
    public void testeAtaqueDuploArmaduraVestida(){
        Saint ikki = new BronzeSaint("ikki","fenix");
        Saint seiya = new BronzeSaint("seiya","pegaso");
                
        ikki.aprenderGolpe(new Golpe("ave Fenix",15));        
        
        ikki.vestirArmadura();
       
        AtaqueDuplo ataque = new AtaqueDuplo(ikki,seiya);
        ataque.executarTesteGolpeDuploTrue();
                
        
        assertEquals(40,seiya.getVida(),0.01);
    }
    
      @Test 
    public void testeAtaqueDuploGolpeadorPerdeDadoLevaDano(){
        Saint ikki = new BronzeSaint("ikki","fenix");
        Saint seiya = new BronzeSaint("seiya","pegaso");
                
        ikki.aprenderGolpe(new Golpe("ave Fenix",15));        
        
        ikki.vestirArmadura();
       
        AtaqueDuplo ataque = new AtaqueDuplo(ikki,seiya);
        ataque.executarTesteGolpeDuploFalse();
                
        
        assertEquals(95,ikki.getVida(),0.01);
    }
}
