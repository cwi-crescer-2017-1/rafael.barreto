import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest{
    @Test
    public void vestirArmaduraDeixarArmaduraVestida(){
        //1.Arrange

        Armadura capricornio = new Armadura (new Constelacao("capricornio"),Categoria.OURO);
        Saint shura = new Saint("Shura", capricornio);           
        //2.Act
        shura.vestirArmadura();

        //3.Assert
        boolean resultado = shura.getArmaduraVestida();   
        assertEquals(true,resultado);
    }  

    @Test
    public void naoVestirArmaduraDeixarArmaduraNaoVestida(){
        Saint hyoga = new Saint("hyoga",new Armadura (new Constelacao("cisne"),Categoria.BRONZE));
        boolean resultado = hyoga.getArmaduraVestida();
        assertEquals(false,resultado);
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado(){
        Armadura virgem = new Armadura (new Constelacao("virgem"),Categoria.OURO);
        Saint shaka = new Saint ("shaka",virgem);
        assertEquals(Genero.NAO_INFORMADO,shaka.getGenero());
    }

    @Test
    public void verificaSeEstaVivo(){
        Armadura dragao = new Armadura (new Constelacao("dragao"),Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        assertEquals(Status.VIVO,shiryu.getStatus());
    }

    @Test
    public void testaPerdeVida10() throws Exception {
        Armadura dragao = new Armadura (new Constelacao("dragao"),Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.perderVida(10);
        assertEquals(90,0,shiryu.getVida());
    }

    @Test
    public void testaPerdeVida20() throws Exception {
        Armadura dragao = new Armadura (new Constelacao("dragao"),Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.perderVida(20);
        assertEquals(80,0,shiryu.getVida());
    }

    @Test
    public void testaPerdeVida80() throws Exception {
        Armadura dragao = new Armadura (new Constelacao("dragao"),Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.perderVida(80);
        assertEquals(20,0,shiryu.getVida());
    }

    @Test
    public void testaPerdeVida85() throws Exception {
        Armadura dragao = new Armadura (new Constelacao("dragao"),Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.perderVida(85.5);
        assertEquals(14.5,shiryu.getVida(),0.01);
    }

    @Test
    public void testaPerdeVida90() throws Exception{
        Armadura dragao = new Armadura (new Constelacao("dragao"),Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.perderVida(90);
        assertEquals(10,0,shiryu.getVida());
    }

    @Test
    public void testeSetarGenero(){
        Armadura dragao = new Armadura (new Constelacao("dragao"),Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.setGenero(Genero.FEMININO);

    }

    @Test
    public void testaPerdeVida100() throws Exception{
        Armadura dragao = new Armadura (new Constelacao("dragao"),Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        shiryu.perderVida(100);
        assertEquals(0,0,shiryu.getVida());
    }
    
    @Test
    public void mudarStatusParaMortoAoZerarVida(){
        SilverSaint retsu = new SilverSaint("Retsu",new Armadura(new Constelacao("Lince"),Categoria.PRATA));
        retsu.perderVida(100);
        assertEquals(Status.MORTO,retsu.getStatus());
    }    
    
    @Test(expected = Exception.class)
    public void testePerderVidaValorDanoNegativoDeveDarErro() throws Exception {
        GoldSaint aldebaram = new GoldSaint("Aldebaram",new Armadura(new Constelacao("Touro"),Categoria.OURO));
        aldebaram.perderVida(-10);
        aldebaram.perderVida(-90);
        aldebaram.perderVida(-1000);   
    }

    @Test
    public void testaMetodoGetCategoria(){
        Armadura dragao = new Armadura (new Constelacao("dragao"),Categoria.BRONZE);
        Saint shiryu = new Saint ("Shiryu",dragao);
        assertEquals(1,shiryu.getCategoria());
    }      

    @Test
    public void criarSaintNasce5SentidosDespertado(){
        Saint shiryu= new Saint("Shiryu", new Armadura(new Constelacao("Dragao"),Categoria.BRONZE));
        assertEquals(5,shiryu.getSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasce6SentidosDespertados(){
        SilverSaint prata = new SilverSaint("prata",new Armadura(new Constelacao("prata"),Categoria.PRATA));
        assertEquals(6,prata.getSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasce7SentidosDespertados() throws Exception{
        GoldSaint aldebaram = new GoldSaint ("Aldebaram",new Armadura(new Constelacao("Touro"),Categoria.OURO));
        assertEquals(7,aldebaram.getSentidosDespertados());
    }
    
    @Test (expected=Exception.class)
    public void constelacaoInvalidaDeveDarErro() throws Exception {
        GoldSaint jabu = new GoldSaint("Jabu",new Armadura(new Constelacao("unicornio"),Categoria.OURO));
    }
    
    @Test
    public void testeSaintGetGolpes() throws Exception{ 
        
        Golpe soco = new Golpe("soco",10);
        Golpe chute = new Golpe("chute",17);
        Golpe cabecada = new Golpe("Cabecada",25);        
        Armadura cancer = new Armadura(new Constelacao ("Cancer",chute,soco,cabecada),Categoria.OURO);
        String saintNome="Mascara Da Morte";
        
        GoldSaint mascaraDaMorte = new GoldSaint (saintNome,cancer);
        
        boolean teste = mascaraDaMorte.getGolpes()[0].getNome().equals(chute.getNome());
        assertEquals(true,teste);
        teste = mascaraDaMorte.getGolpes()[1].getNome().equals(soco.getNome());
        assertEquals(true,teste);
        teste = mascaraDaMorte.getGolpes()[2].getNome().equals(cabecada.getNome());
        assertEquals(true,teste);       
    
    }
}