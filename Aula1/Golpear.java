import java.util.ArrayList;

public class Golpear implements Movimento{
    private Saint golpeador,golpeado;    
    private ArrayList<Golpe> listaGolpes = new ArrayList<>();
            
    public Golpear(Saint saint1, Saint saint2){
        this.golpeador = saint1;
        this.golpeado = saint2;    
    }
    
    public void executar(){
        double dano ;
        
        dano = this.golpeador.getProximoGolpe().getFatorDano();
        int multiplicador = golpeador.getCategoria()+1;
        
        dano = golpeador.getArmaduraVestida() ? dano * multiplicador : dano ;
        
        golpeado.perderVida(dano);
    }   
}
