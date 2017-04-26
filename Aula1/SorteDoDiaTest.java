import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SorteDoDiaTest
{
    @Test
    public void verificaReultadoTrue(){
        SorteDoDia sorte = new SorteDoDia(new DadoD6());
        
        boolean verificar = sorte.estouComSorte();
        
        while(verificar != true){                      
            verificar = sorte.estouComSorte();
        }        
        assertEquals(true,verificar);
    }
    
    @Test
    public void verificaReultadoFalse(){
        SorteDoDia sorte = new SorteDoDia(new DadoD6());
        
        boolean verificar = sorte.estouComSorte();
        
        while(verificar == true){            
            verificar = sorte.estouComSorte();
        }        
        assertEquals(false,verificar);
    }
}
