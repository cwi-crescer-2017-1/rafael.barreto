import java.util.ArrayList;

public class Golpear implements Movimento{
    private Saint golpeador,golpeado;    
    private ArrayList<Golpe> listaGolpes = new ArrayList<>();

    public Golpear(Saint saint1, Saint saint2){
        this.golpeador = saint1;
        this.golpeado = saint2;    
    }

    public void executar() throws NullPointerException{
        double dano = this.golpeador.getProximoGolpe().getFatorDano();;
        boolean saintContemGolpe = golpeador.getGolpes().isEmpty();
        boolean armaduraVestida = golpeador.getArmaduraVestida();
        
        if(!saintContemGolpe){           
            int multiplicador = golpeador.getCategoria()+1;
            dano = armaduraVestida ? dano * multiplicador : dano ;
        }else{
            throw new NullPointerException (" Saint nao pode golpear sem ter aprendido golpe " );
        }
        this.golpeado.perderVida(dano);
    }
    
     public boolean equals(Object outro) { 
        Golpear outroGolpear = (Golpear)outro; 
        return this.golpeador.equals(outroGolpear.golpeador) 
            && this.golpeado.equals(outroGolpear.golpeado); 
    } 
}
