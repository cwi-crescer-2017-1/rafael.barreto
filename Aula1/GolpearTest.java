
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest
{
    @Test
    public void  testeGolpearSaintSemArmaduraVestida()throws Exception{
        Saint seiya = new BronzeSaint("Seiya","Pegaso");
        Saint shiryu = new BronzeSaint("Seiya","pegaso");
        
        seiya.aprenderGolpe(new Golpe("meteoro de pegaso",10));
        
        Golpear seiyaGolpea = new Golpear(seiya,shiryu);
        seiyaGolpea.executar();
        
        assertEquals(90,shiryu.getVida(),0.01);           
    } 
    
     @Test
    public void  testeGolpearSaintArmaduraBronzeVestida()throws Exception{
        BronzeSaint seiya = new BronzeSaint("Seiya","Pegaso");
        BronzeSaint shiryu = new BronzeSaint("shiryu","dragao");
        
        new VestirArmadura(seiya).executar();
        seiya.aprenderGolpe(new Golpe("meteoro de pegaso",10));
        
        Golpear seiyaGolpea = new Golpear(seiya,shiryu);
        seiyaGolpea.executar();
        
        assertEquals(80,shiryu.getVida(),0.01);           
    } 
    
    @Test
    public void  testeGolpearSaintArmaduraPrataVestida()throws Exception{
        SilverSaint babel = new SilverSaint("Babel","Centauro");
        BronzeSaint shiryu = new BronzeSaint("Seiya","pegaso");
        
         new VestirArmadura(babel).executar();
        babel.aprenderGolpe(new Golpe("Turbilhao de Chamas",10));
        
        Golpear babelGolpea = new Golpear(babel,shiryu);
        babelGolpea.executar();
        
        assertEquals(70,shiryu.getVida(),0.01);           
    } 
    
    @Test
    public void  testeGolpearSaintArmaduraOuroVestida() throws Exception{
        GoldSaint aldebaram =  new GoldSaint("aldebaram","Touro");
        BronzeSaint shiryu = new BronzeSaint("Seiya","pegaso");
        
         new VestirArmadura(aldebaram).executar();
        aldebaram.aprenderGolpe(new Golpe("Grande Chifre",20));
        Golpear aldebaramGolpea = new Golpear(aldebaram,shiryu);
        aldebaramGolpea.executar();
        
        assertEquals(20,shiryu.getVida(),0.01);   
    } 
    
    @Test(expected = NullPointerException.class)
    public void  testeGolpearSaintSemGolpeLancaNullPointerException()throws Exception{
        Saint seiya = new BronzeSaint("Seiya","Pegaso");
        Saint shiryu = new BronzeSaint("Seiya","pegaso");
        
        Golpear seiyaGolpea = new Golpear(seiya,shiryu);
        seiyaGolpea.executar();
        
        assertEquals(90,shiryu.getVida(),0.01);           
    } 
}
