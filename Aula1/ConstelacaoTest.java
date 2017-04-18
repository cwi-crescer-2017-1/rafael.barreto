
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest
{
    /*@Test
    public void testaAdicionarGolpeUltimaPosicaoArray(){
        Constelacao aries = new Constelacao("aries");
        String nomeGolpe = "exclamacao de athena";
        aries.adicionarGolpe(new Golpe(nomeGolpe,70));
        boolean teste = aries.getGolpe()[2].getNome().equals(nomeGolpe);
        assertEquals(true,teste);
    }*/
    //modificar este teste usando o equals da classe Golpe.
    @Test
    public void adicionaGolpeEmPosicaoLivre(){
         String golpe1="soco",golpe2="chute", golpe3="cabecada";
         Saint seiya = new Saint("Seiya",new Armadura(new Constelacao("pegaso"),Categoria.BRONZE));
         seiya.aprenderGolpe(new Golpe(golpe1 ,10));        
         boolean teste = seiya.getGolpes()[0].getNome().equals(golpe1);
         assertEquals(true,teste);
        
         seiya.aprenderGolpe(new Golpe(golpe2 ,10));
         teste = seiya.getGolpes()[1].getNome().equals(golpe2);
         assertEquals(true,teste);
         
         seiya.aprenderGolpe(new Golpe(golpe3 ,10));
         teste = seiya.getGolpes()[2].getNome().equals(golpe3);
         assertEquals(true,teste);         
    }   
    
/*
    @Test
    public void testeCriarConstelacaoUsandoArrayParametro(){
        String golpe1="kamehameha" ,golpe2 = "galick-ho",golpe3 = "kiezan";
        Golpe[] golpes = {new Golpe(golpe1,10),new Golpe(golpe2,20),new Golpe(golpe3,5)};
        
        Constelacao dbz = new Constelacao("dbz",golpes);
        
        boolean valorTeste = dbz.getGolpe()[0].getNome().equals(golpe1);
        assertEquals(true,valorTeste);
        valorTeste = dbz.getGolpe()[1].getNome().equals(golpe2);
        assertEquals(true,valorTeste);
        valorTeste = dbz.getGolpe()[2].getNome().equals(golpe3);
        assertEquals(true,valorTeste);

    }*/
}
