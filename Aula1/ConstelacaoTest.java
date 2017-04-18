
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest
{
    @Test
    public void constelacaoAdicionarGolpeUltimaPosicaoArray(){
        Constelacao aries = new Constelacao("aries");
        Golpe exclamacaoDeAthena = new Golpe ("Exclamacao de Athena",100);                
        aries.adicionarGolpe(exclamacaoDeAthena);
        
        
    }

    @Test
    public void constelacaoAdiciona3Golpes(){
         Golpe meteoroDePegaso = new Golpe("Meteoro de Pegaso",10);
         Golpe cometaDePegaso = new Golpe("Cometa de Pegaso",10);
         Golpe centelhaDePegaso = new Golpe("Centelha de Pegaso",10);         
        
         Constelacao pegaso = new Constelacao("pegaso");
         
         pegaso.adicionarGolpe(meteoroDePegaso);
         pegaso.adicionarGolpe(cometaDePegaso);
         pegaso.adicionarGolpe(centelhaDePegaso);
        
         assertEquals(meteoroDePegaso,pegaso.getGolpe().get(0));
         assertEquals(cometaDePegaso,pegaso.getGolpe().get(1));
         assertEquals(centelhaDePegaso,pegaso.getGolpe().get(2));        
    }   
}
