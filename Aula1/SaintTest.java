import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest{
    @Test
    public void vestirArmaduraDeixarArmaduraVestida(){
        //1.Arrange

        Armadura capricornio = new Armadura ("capricornio",Categoria.OURO);
        Saint shura = new Saint("Shura", capricornio);           
        //2.Act
        shura.vestirArmadura();

        //3.Assert
        boolean resultado = shura.getArmaduraVestida();   
        assertEquals(true,resultado);
    }  

    @Test
    public void naoVestirArmaduraDeixarArmaduraNaoVestida(){
        Saint hyoga = new Saint("hyoga",new Armadura ("cisne",Categoria.BRONZE));
        boolean resultado = hyoga.getArmaduraVestida();
        assertEquals(false,resultado);
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado(){
        Armadura virgem = new Armadura ("virgem",Categoria.OURO);
        Saint shaka = new Saint ("shaka",virgem);
        assertEquals(Genero.NAO_INFORMADO,shaka.getGenero());
    }

    @Test
    public void verificaSeEstaVivo(){
        Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        assertEquals(Status.VIVO,shiryu.getStatus());
    }

    @Test
    public void testaPerdeVida10(){
        Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.perderVida(10);
        assertEquals(90,0,shiryu.getVida());
    }

    @Test
    public void testaPerdeVida20(){
        Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.perderVida(20);
        assertEquals(80,0,shiryu.getVida());
    }

    @Test
    public void testaPerdeVida80(){
        Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.perderVida(80);
        assertEquals(20,0,shiryu.getVida());
    }

    @Test
    public void testaPerdeVida85(){
        Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.perderVida(85.5);
        assertEquals(14.5,shiryu.getVida(),0.01);
    }

    @Test
    public void testaPerdeVida90(){
        Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.perderVida(90);
        assertEquals(10,0,shiryu.getVida());
    }

    @Test
    public void testeSetarGenero(){
        Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.setGenero(Genero.FEMININO);

    }

    @Test
    public void testaPerdeVida100(){
        Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.perderVida(100);
        assertEquals(0,0,shiryu.getVida());
    }

    @Test
    public void testaMetodoGetCategoria(){
        Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        assertEquals(1,shiryu.getCategoria());
    }      

    @Test
    public void criarSaintNasce5SentidosDespertado(){
		Saint shiryu= new Saint("Shiryu", new Armadura("Dragao",Categoria.BRONZE));
		assertEquals(5,shiryu.getSentidosDespertados());
    }

	@Test
	public void criarSaintPrataNasce6SentidosDespertados(){
		Saint prata = new Saint("prata",new Armadura("prata",Categoria.PRATA));
		assertEquals(6,prata.getSentidosDespertados());
	}
}