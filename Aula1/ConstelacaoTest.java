

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest
{
    @Test
    public void testaAdicionarGolpeUltimaPosicaoArray(){
        Constelacao aries = new Constelacao("aries");
        aries.adicionarGolpe(new Golpe("exclamacao de athena",70));
        boolean teste = aries.getGolpe()[2].getNome().equals("exclamacao de athena");
        assertEquals(true,teste);
    }
}
