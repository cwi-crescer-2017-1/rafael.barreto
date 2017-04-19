
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest
{
   @Test
   public void buscarSaintPorNome() throws Exception{
     Armadura capricornio = new Armadura (new Constelacao("Capricornio"),Categoria.OURO);
     Saint shura = new GoldSaint("Shura",capricornio);
     
     Armadura aries = new Armadura (new Constelacao("Aries"),Categoria.OURO);
     Saint mu = new GoldSaint("Mu",aries);
     
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
     Armadura capricornio = new Armadura (new Constelacao("Capricornio"),Categoria.OURO);
     Saint shura = new GoldSaint("Shura",capricornio);
     
     Armadura aries = new Armadura (new Constelacao("Aries"),Categoria.OURO);
     Saint mu = new GoldSaint("Mu",aries);
     
     ListaSaints cavaleiros = new ListaSaints();           
     mu.perderVida(100);
     
     cavaleiros.adicionar(shura);
     cavaleiros.adicionar(mu);
     
     Saint resultado;     
     resultado = cavaleiros.buscarPorStatus(Status.VIVO);     
     assertEquals(shura,resultado); 
   } 
   
   @Test
   public void buscarSaintPorStatusMorto() throws Exception{
     Armadura capricornio = new Armadura (new Constelacao("Capricornio"),Categoria.OURO);
     Saint shura = new GoldSaint("Shura",capricornio);
     
     Armadura aries = new Armadura (new Constelacao("Aries"),Categoria.OURO);
     Saint mu = new GoldSaint("Mu",aries);
     
     ListaSaints cavaleiros = new ListaSaints();           
     mu.perderVida(100);
     
     cavaleiros.adicionar(shura);
     cavaleiros.adicionar(mu);
     
     Saint resultado;     
     resultado = cavaleiros.buscarPorStatus(Status.MORTO);     
     assertEquals(mu,resultado); 
 
   } 
   
    @Test
   public void buscarSaintPorCategoria() throws Exception{
     Armadura capricornio = new Armadura (new Constelacao("Capricornio"),Categoria.OURO);
     Saint shura = new GoldSaint("Shura",capricornio);
     
     Armadura pegaso = new Armadura (new Constelacao("pegaso"),Categoria.BRONZE);
     Saint seiya = new BronzeSaint("Seiya",pegaso);
     
     
     ListaSaints cavaleiros = new ListaSaints();                
     
     cavaleiros.adicionar(shura);
     cavaleiros.adicionar(seiya);
     
     Saint resultado;     
     resultado = cavaleiros.buscarPorCategoria(Categoria.BRONZE);     
     assertEquals(seiya,resultado); 
   } 
   
     @Test
   public void buscaSaintComMaiorVida() throws Exception{
     Armadura capricornio = new Armadura (new Constelacao("Capricornio"),Categoria.OURO);
     Saint shura = new GoldSaint("Shura",capricornio);
     
     Armadura aries = new Armadura (new Constelacao("Aries"),Categoria.OURO);
     Saint mu = new GoldSaint("Mu",aries);
     
     ListaSaints cavaleiros = new ListaSaints();           
     mu.perderVida(50);
     
     cavaleiros.adicionar(shura);
     cavaleiros.adicionar(mu);
     
     Saint resultado;     
     resultado = cavaleiros.getSaintMaiorVida();     
     assertEquals(shura,resultado); 
 
   } 
   
   @Test
   public void buscaSaintComMenorVida() throws Exception{
     Armadura capricornio = new Armadura (new Constelacao("Capricornio"),Categoria.OURO);
     Saint shura = new GoldSaint("Shura",capricornio);
     
     Armadura aries = new Armadura (new Constelacao("Aries"),Categoria.OURO);
     Saint mu = new GoldSaint("Mu",aries);
     
     ListaSaints cavaleiros = new ListaSaints();           
     mu.perderVida(50);
     
     cavaleiros.adicionar(shura);
     cavaleiros.adicionar(mu);
     
     Saint resultado;     
     resultado = cavaleiros.getSaintMenorVida();     
     assertEquals(mu,resultado); 
 
   } 
   
   @Test
   public void ordenarAListaPorOrdemDeNomes() throws Exception{
     Armadura capricornio = new Armadura (new Constelacao("Capricornio"),Categoria.OURO);
     Saint shura = new Saint("Shura",capricornio);     
     Armadura aries = new Armadura (new Constelacao("Aries"),Categoria.OURO);
     Saint mu = new Saint("Mu",aries);  
     Armadura dragao = new Armadura (new Constelacao("dragao"),Categoria.BRONZE);
     Saint shiryu = new Saint ("Shiryu",dragao);
     Saint hyoga = new Saint("hyoga",new Armadura (new Constelacao("cisne"),Categoria.BRONZE));
     Saint aldebaram = new Saint("Aldebaram",new Armadura(new Constelacao("Touro"),Categoria.OURO));
     Saint jabu = new Saint("Jabu",new Armadura(new Constelacao("unicornio"),Categoria.BRONZE));
     ListaSaints cavaleiros = new ListaSaints();           
     
     cavaleiros.adicionar(shura);
     cavaleiros.adicionar(mu);
     cavaleiros.adicionar(hyoga);
     cavaleiros.adicionar(shiryu);
     cavaleiros.adicionar(aldebaram);
     cavaleiros.adicionar(jabu);      
     
     cavaleiros.ordenar();
     
     assertEquals(aldebaram,cavaleiros.get(0)); 
     assertEquals(hyoga,cavaleiros.get(1)); 
     assertEquals(jabu,cavaleiros.get(2)); 
     assertEquals(mu,cavaleiros.get(3)); 
     assertEquals(shiryu,cavaleiros.get(4)); 
     assertEquals(shura,cavaleiros.get(5)); 

 
   } 
 
}
