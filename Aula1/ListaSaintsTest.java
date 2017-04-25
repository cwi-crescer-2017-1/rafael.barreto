import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.lang.NullPointerException;

public class ListaSaintsTest
{
    @Test
    public void buscarSaintPorNome() throws Exception{

        Saint shura = new GoldSaint("Shura","Capricornio");

        Saint mu = new GoldSaint("Mu","Aries");
        ListaSaints cavaleiros = new ListaSaints();           
        cavaleiros.adicionar(shura);
        cavaleiros.adicionar(mu);

        Saint resultado;     
        resultado = cavaleiros.buscarPorNome("Shura");     
        assertEquals(shura,resultado);

        resultado = cavaleiros.buscarPorNome("Mu");
        assertEquals(mu,resultado);

    }

    @Test
    public void buscarSaintPorStatusVivo() throws Exception{

        Saint shura = new GoldSaint("Shura","Capricornio");

        Saint mu = new GoldSaint("Mu","Aries");
        ListaSaints cavaleiros = new ListaSaints();           
        mu.perderVida(100);

        cavaleiros.adicionar(shura);
        cavaleiros.adicionar(mu);

        ArrayList<Saint> resultado = new ArrayList<>();
        resultado  = cavaleiros.buscarPorStatus(Status.VIVO);

        assertEquals(shura,resultado.get(0)); 
    } 

    @Test
    public void buscarSaintPorStatusMorto() throws Exception{

        Saint shura = new GoldSaint("Shura","Capricornio");

        Saint mu = new GoldSaint("Mu","Aries");
        ListaSaints cavaleiros = new ListaSaints();           
        mu.perderVida(100);

        cavaleiros.adicionar(shura);
        cavaleiros.adicionar(mu);

        ArrayList<Saint> resultado = new ArrayList<>();
        resultado  = cavaleiros.buscarPorStatus(Status.MORTO);  
        assertEquals(mu,resultado.get(0)); 

    } 

    @Test
    public void buscarSaintPorCategoria() throws Exception{

        Saint shura = new GoldSaint("Shura","Capricornio");     
        Saint seiya = new BronzeSaint("Seiya","pegaso");

        ListaSaints cavaleiros = new ListaSaints();                
        cavaleiros.adicionar(shura);
        cavaleiros.adicionar(seiya);

        ArrayList<Saint> resultado = new ArrayList<>();     
        resultado = cavaleiros.buscarPorCategoria(Categoria.BRONZE);//este metodo retornar uma arry list arrumar isto   
        assertEquals(seiya,resultado.get(0));
    } 

    @Test
    public void buscaSaintComMaiorVida() throws Exception{

        Saint shura = new GoldSaint("Shura","Capricornio");

        Saint mu = new GoldSaint("Mu","Aries");
        ListaSaints cavaleiros = new ListaSaints();           
        mu.perderVida(50);

        cavaleiros.adicionar(shura);
        cavaleiros.adicionar(mu);

        Saint resultado;     
        resultado = cavaleiros.getSaintMaiorVida();     
        assertEquals(shura,resultado); 

    } 

    @Test
    public void buscaSaintComMaiorVidaListaVazia() throws Exception{

        ListaSaints cavaleiros = new ListaSaints();
        Saint resultado;     
        resultado = cavaleiros.getSaintMaiorVida(); 
        assertEquals(null,resultado);
    }

    @Test
    public void buscaSaintComMenorVida() throws Exception{

        Saint shura = new GoldSaint("Shura","Capricornio");

        Saint mu = new GoldSaint("Mu","Aries");
        ListaSaints cavaleiros = new ListaSaints();           
        mu.perderVida(50);

        cavaleiros.adicionar(shura);
        cavaleiros.adicionar(mu);

        Saint resultado;     
        resultado = cavaleiros.getSaintMenorVida();     
        assertEquals(mu,resultado); 

    } 

    @Test
    public void buscaSaintComMenorVidaListaVazia() throws Exception{

        ListaSaints cavaleiros = new ListaSaints();
        Saint resultado;     
        resultado = cavaleiros.getSaintMenorVida(); 
        assertEquals(null,resultado);
    } 

    // TESTES DO METODO ORDENAR

    @Test
    public void ordenarAListaPorVida() throws Exception{

        GoldSaint shura = new GoldSaint("Shura","Capricornio");

        GoldSaint mu = new GoldSaint("Mu","Aries");

        BronzeSaint shiryu = new BronzeSaint ("Shiryu","dragao");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","cisne");
        GoldSaint aldebaram = new GoldSaint ("aldebaram","Touro");
        BronzeSaint jabu = new BronzeSaint ("jabu","unicornio");
        ListaSaints cavaleiros = new ListaSaints();     

        cavaleiros.adicionar(shura);
        shura.perderVida(70);
        cavaleiros.adicionar(mu);
        mu.perderVida(20);
        cavaleiros.adicionar(hyoga);
        hyoga.perderVida(30);
        cavaleiros.adicionar(shiryu);
        shiryu.perderVida(3);
        cavaleiros.adicionar(aldebaram);
        cavaleiros.adicionar(jabu);
        jabu.perderVida(5);

        cavaleiros.ordenar();

        assertEquals(aldebaram,cavaleiros.get(0)); 
        assertEquals(shiryu,cavaleiros.get(1)); 
        assertEquals(jabu,cavaleiros.get(2)); 
        assertEquals(mu,cavaleiros.get(3)); 
        assertEquals(hyoga,cavaleiros.get(4)); 
        assertEquals(shura,cavaleiros.get(5));
    }

    // TESTES DO METODO ORDENAR COM PARAMETROS 

    @Test
    public void ordenarAListaPorVidaFormaAscendente() throws Exception{

        GoldSaint shura = new GoldSaint("Shura","Capricornio");

        GoldSaint mu = new GoldSaint("Mu","Aries");

        BronzeSaint shiryu = new BronzeSaint ("Shiryu","dragao");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","cisne");
        GoldSaint aldebaram = new GoldSaint ("aldebaram","Touro");
        BronzeSaint jabu = new BronzeSaint ("jabu","unicornio");
        ListaSaints cavaleiros = new ListaSaints();     

        cavaleiros.adicionar(shura);
        shura.perderVida(70);
        cavaleiros.adicionar(mu);
        mu.perderVida(20);
        cavaleiros.adicionar(hyoga);
        hyoga.perderVida(30);
        cavaleiros.adicionar(shiryu);
        shiryu.perderVida(3);
        cavaleiros.adicionar(aldebaram);
        cavaleiros.adicionar(jabu);
        jabu.perderVida(5);

        cavaleiros.ordenar(TipoOrdenacao.ASCENDENTE);

        assertEquals(aldebaram,cavaleiros.get(0)); 
        assertEquals(shiryu,cavaleiros.get(1)); 
        assertEquals(jabu,cavaleiros.get(2)); 
        assertEquals(mu,cavaleiros.get(3)); 
        assertEquals(hyoga,cavaleiros.get(4)); 
        assertEquals(shura,cavaleiros.get(5));
    }

    @Test
    public void ordenarAListaPorVidaFormaDescendente() throws Exception{

        GoldSaint shura = new GoldSaint("Shura","Capricornio");

        GoldSaint mu = new GoldSaint("Mu","Aries");

        BronzeSaint shiryu = new BronzeSaint ("Shiryu","dragao");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","cisne");
        GoldSaint aldebaram = new GoldSaint ("aldebaram","Touro");
        BronzeSaint jabu = new BronzeSaint ("jabu","unicornio");
        ListaSaints cavaleiros = new ListaSaints();     

        cavaleiros.adicionar(shura);
        shura.perderVida(70);
        cavaleiros.adicionar(mu);
        mu.perderVida(20);
        cavaleiros.adicionar(hyoga);
        hyoga.perderVida(30);
        cavaleiros.adicionar(shiryu);
        shiryu.perderVida(3);
        cavaleiros.adicionar(aldebaram);
        cavaleiros.adicionar(jabu);
        jabu.perderVida(5);

        cavaleiros.ordenar(TipoOrdenacao.DESCENDENTE);

        assertEquals(aldebaram,cavaleiros.get(5)); 
        assertEquals(shiryu,cavaleiros.get(4)); 
        assertEquals(jabu,cavaleiros.get(3)); 
        assertEquals(mu,cavaleiros.get(2)); 
        assertEquals(hyoga,cavaleiros.get(1)); 
        assertEquals(shura,cavaleiros.get(0));
    }

    //testa metodo unir

    @Test public void unirListasCavaleiros() throws Exception{

        GoldSaint shura = new GoldSaint("Shura","Capricornio");
        GoldSaint mu = new GoldSaint("Mu","Aries");
        BronzeSaint shiryu = new BronzeSaint ("Shiryu","dragao");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","cisne");
        GoldSaint aldebaram = new GoldSaint ("aldebaram","Touro");
        BronzeSaint jabu = new BronzeSaint ("jabu","unicornio");
        ListaSaints cavaleirosOuro = new ListaSaints(); 

        cavaleirosOuro.adicionar(shura);
        cavaleirosOuro.adicionar(mu);
        cavaleirosOuro.adicionar(aldebaram);

        ListaSaints cavaleirosBronze = new ListaSaints(); 
        cavaleirosBronze.adicionar(shiryu); 
        cavaleirosBronze.adicionar(hyoga);
        cavaleirosBronze.adicionar(jabu); 

        ListaSaints todosCavaleiros = new ListaSaints();

        todosCavaleiros = cavaleirosOuro.unir(cavaleirosBronze);

        assertEquals(shura,todosCavaleiros.get(0));
        assertEquals(mu,todosCavaleiros.get(1));
        assertEquals(aldebaram,todosCavaleiros.get(2));
        assertEquals(shiryu,todosCavaleiros.get(3));
        assertEquals(hyoga,todosCavaleiros.get(4));
        assertEquals(jabu,todosCavaleiros.get(5));

    } 

    @Test public void unirListasVazias(){
        ListaSaints cavaleirosOuro = new ListaSaints();
        ListaSaints cavaleirosBronze = new ListaSaints();

        cavaleirosOuro.unir(cavaleirosBronze);        

    }

    // testa metodo diff

    @ Test 
    public void diffListaTotalmenteDiferente() throws Exception {

        GoldSaint shura = new GoldSaint("Shura","Capricornio");
        GoldSaint mu = new GoldSaint("Mu","Aries");
        BronzeSaint shiryu = new BronzeSaint ("Shiryu","dragao");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","cisne");
        GoldSaint aldebaram = new GoldSaint ("aldebaram","Touro");
        BronzeSaint jabu = new BronzeSaint ("jabu","unicornio");

        ListaSaints cavaleirosOuro = new ListaSaints(); 
        cavaleirosOuro.adicionar(shura);
        cavaleirosOuro.adicionar(mu);
        cavaleirosOuro.adicionar(aldebaram);

        ListaSaints cavaleirosBronze = new ListaSaints(); 
        cavaleirosBronze.adicionar(shiryu); 
        cavaleirosBronze.adicionar(hyoga);        
        cavaleirosBronze.adicionar(jabu); 

        ListaSaints todosCavaleiros = new ListaSaints();    
        todosCavaleiros = cavaleirosOuro.diff(cavaleirosBronze);   

        assertEquals(shiryu,todosCavaleiros.get(0));  
        assertEquals(hyoga,todosCavaleiros.get(1));  
        assertEquals(jabu,todosCavaleiros.get(2)); 

    }

    @ Test public void diffListaAlgunsDiferente() throws Exception {

        GoldSaint shura = new GoldSaint("Shura","Capricornio");
        GoldSaint mu = new GoldSaint("Mu","Aries");
        BronzeSaint shiryu = new BronzeSaint ("Shiryu","dragao");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","cisne");
        GoldSaint aldebaram = new GoldSaint ("aldebaram","Touro");
        BronzeSaint jabu = new BronzeSaint ("jabu","unicornio");

        ListaSaints cavaleirosOuro = new ListaSaints(); 
        cavaleirosOuro.adicionar(shura);
        cavaleirosOuro.adicionar(mu);
        cavaleirosOuro.adicionar(aldebaram);

        ListaSaints cavaleirosBronze = new ListaSaints(); 
        cavaleirosBronze.adicionar(shiryu); 
        cavaleirosBronze.adicionar(aldebaram);       
        cavaleirosBronze.adicionar(shura);

        ListaSaints todosCavaleiros = new ListaSaints();    
        todosCavaleiros = cavaleirosOuro.diff(cavaleirosBronze);

        assertEquals(shiryu,todosCavaleiros.get(0));             
    }

    @ Test (expected = NullPointerException.class)
    public void diffListaTotalmenteIgual() throws Exception  {

        GoldSaint shura = new GoldSaint("Shura","Capricornio");
        GoldSaint mu = new GoldSaint("Mu","Aries");
        BronzeSaint shiryu = new BronzeSaint ("Shiryu","dragao");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","cisne");
        GoldSaint aldebaram = new GoldSaint ("aldebaram","Touro");
        BronzeSaint jabu = new BronzeSaint ("jabu","unicornio");

        ListaSaints cavaleirosOuro = new ListaSaints(); 
        cavaleirosOuro.adicionar(shura);
        cavaleirosOuro.adicionar(mu);
        cavaleirosOuro.adicionar(aldebaram);

        ListaSaints cavaleirosBronze = new ListaSaints(); 
        cavaleirosBronze.adicionar(mu); 
        cavaleirosBronze.adicionar(aldebaram);       
        cavaleirosBronze.adicionar(shura);

        ListaSaints todosCavaleiros = new ListaSaints();    
        todosCavaleiros = cavaleirosOuro.diff(cavaleirosBronze); 

        assertEquals(null,cavaleirosOuro.diff(cavaleirosBronze));
    }

    // TESTA METODO INTERSEC 

    @ Test public void intersecListaTotalmenteDiferente() throws Exception {

        GoldSaint shura = new GoldSaint("Shura","Capricornio");
        GoldSaint mu = new GoldSaint("Mu","Aries");
        BronzeSaint shiryu = new BronzeSaint ("Shiryu","dragao");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","cisne");
        GoldSaint aldebaram = new GoldSaint ("aldebaram","Touro");
        BronzeSaint jabu = new BronzeSaint ("jabu","unicornio");

        ListaSaints cavaleirosOuro = new ListaSaints(); 
        cavaleirosOuro.adicionar(shura);
        cavaleirosOuro.adicionar(mu);
        cavaleirosOuro.adicionar(aldebaram);

        ListaSaints cavaleirosBronze = new ListaSaints(); 
        cavaleirosBronze.adicionar(shiryu); 
        cavaleirosBronze.adicionar(hyoga);        
        cavaleirosBronze.adicionar(jabu); 

        ListaSaints todosCavaleiros = new ListaSaints();    
        todosCavaleiros = cavaleirosOuro.intersec(cavaleirosBronze);

        assertEquals(shura,todosCavaleiros.get(0));
        assertEquals(shiryu,todosCavaleiros.get(1));
        assertEquals(mu,todosCavaleiros.get(2));
        assertEquals(hyoga,todosCavaleiros.get(3));
        assertEquals(aldebaram,todosCavaleiros.get(4));
        assertEquals(jabu,todosCavaleiros.get(5));
    }

    @ Test public void intersecListaVazia(){  

        ListaSaints cavaleirosOuro = new ListaSaints();          
        ListaSaints cavaleirosBronze = new ListaSaints();        
        ListaSaints todosCavaleiros = new ListaSaints(); 

        assertEquals(true, todosCavaleiros.todos().isEmpty());

    }

    @ Test public void intersecListacheiaComListaVazia() throws Exception {

        GoldSaint shura = new GoldSaint("Shura","Capricornio");
        GoldSaint mu = new GoldSaint("Mu","Aries");
        BronzeSaint shiryu = new BronzeSaint ("Shiryu","dragao");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","cisne");
        GoldSaint aldebaram = new GoldSaint ("aldebaram","Touro");
        BronzeSaint jabu = new BronzeSaint ("jabu","unicornio");

        ListaSaints cavaleirosOuro = new ListaSaints(); 
        cavaleirosOuro.adicionar(shura);
        cavaleirosOuro.adicionar(mu);
        cavaleirosOuro.adicionar(aldebaram);

        ListaSaints cavaleirosBronze = new ListaSaints();         

        ListaSaints todosCavaleiros = new ListaSaints();    
        todosCavaleiros = cavaleirosOuro.intersec(cavaleirosBronze);

        assertEquals(shura,todosCavaleiros.get(0));
        assertEquals(mu,todosCavaleiros.get(1));
        assertEquals(aldebaram,todosCavaleiros.get(2));

    }

    // TESTES CSV
    @ Test public void csvComListaCom2Saints()throws Exception{

        GoldSaint shura = new GoldSaint("Shura","Capricornio");
        GoldSaint mu = new GoldSaint("Mu","Aries");
        

        ListaSaints cavaleiros = new ListaSaints(); 
        cavaleiros.adicionar(shura);
        cavaleiros.adicionar(mu); 
        mu.perderVida(10);

        String csv = cavaleiros.getCSV();  
        String compara = "Shura,100.0,Capricornio,OURO,VIVO,NAO_INFORMADO,false"+System.lineSeparator()+"Mu,90.0,Aries,OURO,VIVO,NAO_INFORMADO,false"+System.lineSeparator();

        assertEquals(compara,csv);
    }

    @ Test public void csvComListaCom1Saints() throws Exception {

        GoldSaint shura = new GoldSaint("Shura","Capricornio");
        ListaSaints cavaleiros = new ListaSaints(); 
        cavaleiros.adicionar(shura);        

        String csv = cavaleiros.getCSV();
        String compara = "Shura,100.0,Capricornio,OURO,VIVO,NAO_INFORMADO,false"+System.lineSeparator();

        assertEquals(compara,csv);
       
    }

    @ Test public void csvComListaSemSaints(){
        
        ListaSaints cavaleiros = new ListaSaints();         

        String csv = cavaleiros.getCSV();  

        assertEquals(true,csv.isEmpty());
    }
}

