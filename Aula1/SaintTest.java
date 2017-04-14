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
        public void testaPerdeVida(){
            Armadura dragao = new Armadura ("dragao",Categoria.BRONZE);
            Saint shiryu = new Saint ("Shiryu",dragao);
            shiryu.perderVida();
            assertEquals(90,0,shiryu.getVida());
        }
}