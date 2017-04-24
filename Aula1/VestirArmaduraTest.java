import static org.junit.Assert.*; 
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test;
 
public class VestirArmaduraTest{
 
    @Test 
    public void testeMetodoExecutarClasseVestirArmadura(){ 
        BronzeSaint seiya = new BronzeSaint("Seiya","Pegaso");
        VestirArmadura seiyaVestirArmadura = new VestirArmadura(seiya); 
        
        seiyaVestirArmadura.executar();
        
        assertEquals(true,seiya.getArmaduraVestida()); 
    } 
    
    @Test (expected = NullPointerException.class)
    public void testeMetodoExecutarClasseVestirArmaduraComSaintNull(){
        BronzeSaint seiya = null;
        VestirArmadura seiyaVestirArmadura = new VestirArmadura(seiya); 
       
        seiyaVestirArmadura.executar();
    }
}
 