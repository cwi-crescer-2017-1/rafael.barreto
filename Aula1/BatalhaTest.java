

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BatalhaTest
{
		@Test
		public void categoria1MaiorQueCategoria2(){
		Saint seiya = new Saint ("Seiya",new Armadura ("pegaso",Categoria.BRONZE));
		Saint shaina = new Saint ("Shaina",new Armadura ("cobra",Categoria.PRATA));		
		Batalha batalha1 = new Batalha(shaina,seiya);

		batalha1.iniciar();

		assertEquals(100.0,shaina.getVida(),0.01);
		assertEquals(90.0,seiya.getVida(),0.01);
		}

		@Test
		public void categoriasIguais(){
		Saint aldebaram = new Saint ("aldebaram",new Armadura ("touro",Categoria.OURO));
		Saint mu = new Saint ("Mu",new Armadura ("Aries",Categoria.OURO));
		Batalha batalha = new Batalha (aldebaram,mu);

		batalha.iniciar();

		assertEquals(100.0,aldebaram.getVida(),0.01);
		assertEquals(90.0,mu.getVida(),0.01);
	  }
}
