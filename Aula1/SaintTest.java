import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest{
    @Test
    public void SaintVestirArmaduraDeixarArmaduraVestida() throws Exception{
        //1.Arrange      
        GoldSaint shura = new GoldSaint("Shura","Capricornio");          
        //2.Act
        shura.vestirArmadura();
        //3.Assert
        boolean resultado = shura.getArmaduraVestida();   
        assertEquals(true,resultado);
    }  

    @Test
    public void SaintNaoVestirArmaduraDeixarArmaduraNaoVestida(){
        Saint hyoga = new BronzeSaint("Hyoga","Cisne");
        boolean resultado = hyoga.getArmaduraVestida();
        assertEquals(false,resultado);
    }

    @Test
    public void SaintAoCriarSaintGeneroENaoInformado() throws Exception {        
        Saint shaka = new GoldSaint ("shaka","Virgem");
        assertEquals(Genero.NAO_INFORMADO,shaka.getGenero());
    }

    @Test
    public void SaintVerificaSeEstaVivo(){        
        Saint shiryu = new BronzeSaint ("Shiryu","dragao");
        assertEquals(Status.VIVO,shiryu.getStatus());
    }

    @Test
    public void SaintTestaPerdeVida10() throws Exception {        
        Saint shiryu = new BronzeSaint ("Shiryu","dragao");
        shiryu.perderVida(10);
        assertEquals(90,0,shiryu.getVida());
    }

    @Test
    public void SaintPerdeVida20() throws Exception {        
        Saint shiryu = new BronzeSaint ("Shiryu","dragao");
        shiryu.perderVida(20);
        assertEquals(80,0,shiryu.getVida());
    }

    @Test
    public void SaintPerdeVida80() throws Exception {        
        Saint shiryu = new BronzeSaint ("Shiryu","dragao");
        shiryu.perderVida(80);
        assertEquals(20,0,shiryu.getVida());
    }

    @Test
    public void saintPerdeVida85() throws Exception {        
        Saint shiryu = new BronzeSaint ("Shiryu","dragao");
        shiryu.perderVida(85.5);
        assertEquals(14.5,shiryu.getVida(),0.01);
    }

    @Test
    public void saintPerdeVida90() throws Exception{        
        Saint shiryu = new BronzeSaint ("Shiryu","dragao");
        shiryu.perderVida(90);
        assertEquals(10,0,shiryu.getVida());
    }

    @Test
    public void saintPerdeVida110() throws Exception{        
        Saint shiryu = new BronzeSaint ("Shiryu","dragao");
        shiryu.perderVida(110);
        assertEquals(0,shiryu.getVida(),0.01);
    }

    @Test
    public void saintSetarGenero(){        
        Saint shiryu = new BronzeSaint ("Shiryu","dragao");
        shiryu.setGenero(Genero.FEMININO);

    }

    @Test
    public void saintPerdeVida100() throws Exception{        
        Saint shiryu = new BronzeSaint("Shiryu","Dragao");
        shiryu.perderVida(100);
        assertEquals(0,0,shiryu.getVida());
    }

    @Test
    public void saintMudarStatusParaMortoAoZerarVida(){
        SilverSaint retsu = new SilverSaint("Retsu","Lince");
        retsu.perderVida(100);
        assertEquals(Status.MORTO,retsu.getStatus());
    }    

    @Test(expected = InvalidParameterException.class)
    public void saintPerderVidaValorDanoNegativoDeveDarErro() throws Exception {
        GoldSaint aldebaram = new GoldSaint("Aldebaram","Touro");
        aldebaram.perderVida(-10);
        aldebaram.perderVida(-90);
        aldebaram.perderVida(-1000);   
    }

    @Test
    public void saintMetodoGetCategoria(){        
        Saint shiryu = new BronzeSaint ("Shiryu","dragao");
        assertEquals(1,shiryu.getCategoria());
    }      

    @Test
    public void saintCriarSaintNasce5SentidosDespertado(){
        Saint shiryu= new BronzeSaint ("Shiryu","dragao");
        assertEquals(5,shiryu.getSentidosDespertados());
    }

    @Test
    public void saintCriarSaintPrataNasce6SentidosDespertados(){
        SilverSaint prata = new SilverSaint("prata","prata");
        assertEquals(6,prata.getSentidosDespertados());
    }

    @Test
    public void saintCriarSaintPrataNasce7SentidosDespertados() throws Exception{
        GoldSaint aldebaram = new GoldSaint ("Aldebaram", "Touro");
        assertEquals(7,aldebaram.getSentidosDespertados());
    }

    @Test (expected=Exception.class)
    public void saintConstelacaoInvalidaDeveDarErro() throws Exception {
        GoldSaint jabu = new GoldSaint("Jabu","Unicornio");
    }    

    public void testeSaintGetGolpes() throws Exception{ 

        Golpe soco = new Golpe("soco",10);
        Golpe chute = new Golpe("chute",17);
        Golpe cabecada = new Golpe("Cabecada",25);                        

        GoldSaint mascaraDaMorte = new GoldSaint ("mascara da Morte","Cancer");

        mascaraDaMorte.aprenderGolpe(soco);
        mascaraDaMorte.aprenderGolpe(chute);
        mascaraDaMorte.aprenderGolpe(cabecada);

        boolean teste = mascaraDaMorte.getGolpes().get(0).equals(soco.getNome());
        assertEquals(true,teste);
        teste = mascaraDaMorte.getGolpes().get(0).getNome().equals(chute.getNome());
        assertEquals(true,teste);
        teste = mascaraDaMorte.getGolpes().get(0).getNome().equals(cabecada.getNome());
        assertEquals(true,teste);       

    }   

    @Test
    public void saintTestaSeEstaTrocandoDeGolpe() throws Exception{      

        Golpe meteoroDePegaso = new Golpe("Meteoro de Pegaso",10);
        Golpe cometaDePegaso = new Golpe("Cometa de Pegaso",10);
        Golpe centelhaDePegaso = new Golpe("Centelha de Pegaso",10);         
        Saint seiya = new BronzeSaint ("Seiya","Pegaso");

        seiya.aprenderGolpe(meteoroDePegaso);        
        seiya.aprenderGolpe(cometaDePegaso);    
        seiya.aprenderGolpe(centelhaDePegaso);  

        seiya.getProximoGolpe();        
        assertEquals(meteoroDePegaso,seiya.getGolpes().get(0));

        seiya.getProximoGolpe();        
        assertEquals(cometaDePegaso,seiya.getGolpes().get(1));

        seiya.getProximoGolpe();        
        assertEquals(centelhaDePegaso,seiya.getGolpes().get(2));

        seiya.getProximoGolpe();        
        assertEquals(meteoroDePegaso,seiya.getGolpes().get(0));

    }

    @Test
    public void saintAdiciona3Golpes(){
        Golpe meteoroDePegaso = new Golpe("Meteoro de Pegaso",10);
        Golpe cometaDePegaso = new Golpe("Cometa de Pegaso",10);
        Golpe centelhaDePegaso = new Golpe("Centelha de Pegaso",10);         
        Saint seiya = new BronzeSaint ("Seiya","Pegaso");

        seiya.aprenderGolpe(meteoroDePegaso);        
        seiya.aprenderGolpe(cometaDePegaso);    
        seiya.aprenderGolpe(centelhaDePegaso);    

        assertEquals(meteoroDePegaso,seiya.getGolpes().get(0));
        assertEquals(cometaDePegaso,seiya.getGolpes().get(1));
        assertEquals(centelhaDePegaso,seiya.getGolpes().get(2));

    }    

    @Test
    public void saintAdiciona9Golpes(){
        Golpe meteoroDePegaso = new Golpe("Meteoro de Pegaso",10);
        Golpe cometaDePegaso = new Golpe("Cometa de Pegaso",20);
        Golpe centelhaDePegaso = new Golpe("Centelha de Pegaso",60);

        Golpe capsulaDoPoder = new Golpe("capsula do Poder",20);
        Golpe relampagoDePlasma = new Golpe("relampago de Plasma",30);
        Golpe pataDoLeao = new Golpe("pata do Leao",60);  

        Golpe circuloDeGelo = new Golpe("circulo de Gelo",15);
        Golpe poDeDiamante = new Golpe("po de Diamante",35);
        Golpe trovaoAuroraAtaque = new Golpe("trovao Aurora Ataque",50);  

        Saint seiya = new BronzeSaint ("Seiya","Pegaso");

        seiya.aprenderGolpe(meteoroDePegaso);        
        seiya.aprenderGolpe(cometaDePegaso);    
        seiya.aprenderGolpe(centelhaDePegaso);    

        seiya.aprenderGolpe(capsulaDoPoder);        
        seiya.aprenderGolpe(relampagoDePlasma);    
        seiya.aprenderGolpe(pataDoLeao);    

        seiya.aprenderGolpe(circuloDeGelo);        
        seiya.aprenderGolpe(poDeDiamante);    
        seiya.aprenderGolpe(trovaoAuroraAtaque);    

        assertEquals(meteoroDePegaso,seiya.getGolpes().get(0));
        assertEquals(cometaDePegaso,seiya.getGolpes().get(1));
        assertEquals(centelhaDePegaso,seiya.getGolpes().get(2));

        assertEquals(capsulaDoPoder,seiya.getGolpes().get(3));
        assertEquals(relampagoDePlasma,seiya.getGolpes().get(4));
        assertEquals(pataDoLeao,seiya.getGolpes().get(5));

        assertEquals(circuloDeGelo,seiya.getGolpes().get(6));
        assertEquals(poDeDiamante,seiya.getGolpes().get(7));
        assertEquals(trovaoAuroraAtaque,seiya.getGolpes().get(8));
    }   

    @Test
    public void saintTestaMetodoComparaSaintIdDiferente(){
        Saint seiya = new BronzeSaint("Seiya","Pegaso");
        Saint shiryu = new BronzeSaint("Seiya","pegaso");

        assertFalse(seiya.equals(shiryu));
    }
    
    @Test
    public void saintTestaMetodoComparaSaintIdIgual(){
        Saint seiya = new BronzeSaint("Seiya","Pegaso");
        Saint shiryu = seiya;

        assertEquals(seiya,shiryu);
    }

    // TESTE METODO ADICIONA MOVIMENTO 
    @Test
    public void saintAdicionarMovimento(){
        Saint seiya = new BronzeSaint("Seiya","Pegaso");
        Saint shiryu = new BronzeSaint("Seiya","pegaso");

        Movimento seiyaGolpea = new Golpear(seiya,shiryu);
        seiya.aprenderGolpe(new Golpe("meteoro de pegaso",10));
       
        seiya.adicionarMovimento(seiyaGolpea);
        //seiya.getProximoMovimento()     
        
        assertEquals("meteoro de pegaso",seiya.getGolpes().get(0).getNome());

    }    
    // TERMINAR
    @Test
    public void qtdSaints(){           
           Saint seiya = new BronzeSaint("Seiya","Pegaso");
           Saint shiryu = new BronzeSaint("Seiya","pegaso"); 
    }

     @Test  
     public void getProximoMovimentoDuasVezesComUmMovimento() throws Exception { 
        
    
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Movimento vestirArmadura = new VestirArmadura(hyoga);
        hyoga.adicionarMovimento(vestirArmadura);
        hyoga.getProximoMovimento();
        assertEquals(vestirArmadura, hyoga.getProximoMovimento());
    
    } 
    
    
    @Test
    public void golpearDeveAdicionarMovimentoGolpear() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gemeos");
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        saga.golpear(seiya);
        Golpear golpear = new Golpear(saga, seiya);
        assertEquals(golpear, saga.getProximoMovimento());
    }   
    
    // Testes de contagem de saints criados
    @Test
    public void criar3SaintsOuro() throws Exception {
        int saintsCriados = Saint.getQtdSaints();
        
        Saint seiya = new GoldSaint("Seiya","Sagitario");
        Saint shiryu = new GoldSaint("Shiryu","Libra");
        Saint ikki = new GoldSaint("Ikki","Leao");        
        
        saintsCriados = Saint.getQtdSaints() - saintsCriados;            
        
        assertEquals(3,saintsCriados);
    }
    
    @Test
    public void criar2SaintsOuroPrata() throws Exception {
        int saintsCriados = Saint.getQtdSaints();
        
        Saint seiya = new GoldSaint("Seiya","Sagitario");
        Saint babel = new SilverSaint("babel","Torre");   
        
        saintsCriados = Saint.getQtdSaints() - saintsCriados;            
        
        assertEquals(2,saintsCriados);
    }
    
     @Test
    public void criar1SaintsBronze() throws Exception {
        int saintsCriados = Saint.getQtdSaints();
        
        Saint seiya = new BronzeSaint("Seiya","Pegaso");
        
        saintsCriados = Saint.getQtdSaints() - saintsCriados;            
        
        assertEquals(1,saintsCriados);
    }
    
     // Testes de Id
    @Test
    public void criar3SaintsOuroComId() throws Exception {        
        int saintSeiya, saintShiryu, saintIkki; 
        
        saintIkki = saintShiryu = saintSeiya = Saint.getQtdSaints();
        
        Saint seiya = new GoldSaint("Seiya","Sagitario");
        Saint shiryu = new GoldSaint("Shiryu","Libra");
        Saint ikki = new GoldSaint("Ikki","Leao"); 
        
        saintSeiya = Saint.getQtdSaints() - seiya.getId();
        saintShiryu = Saint.getQtdSaints() - shiryu.getId();
        saintIkki = Saint.getQtdSaints() - ikki.getId();
        
        assertEquals(3,saintSeiya);
        assertEquals(2,saintShiryu);
        assertEquals(1,saintIkki);
        
    }
    
    @Test
    public void criar2SaintsOuroPrataComId() throws Exception {
        int saintSeiya, saintShiryu, saintIkki; 
        
        saintIkki = saintShiryu = saintSeiya = Saint.getQtdSaints();
        
        Saint seiya = new GoldSaint("Seiya","Sagitario");
        Saint shiryu = new GoldSaint("Shiryu","Libra");        
        
        saintSeiya = Saint.getQtdSaints() - seiya.getId();
        saintShiryu = Saint.getQtdSaints() - shiryu.getId();        
        
        assertEquals(2,saintSeiya);
        assertEquals(1,saintShiryu);        
    }
    
    @Test
    public void criar1SaintsBronzeComId() throws Exception {
        int saintSeiya, saintShiryu, saintIkki; 
        
        saintIkki = saintShiryu = saintSeiya = Saint.getQtdSaints();
        
        Saint seiya = new GoldSaint("Seiya","Sagitario");        
        saintSeiya = Saint.getQtdSaints() - seiya.getId();       
        assertEquals(1,saintSeiya);        
    }
}