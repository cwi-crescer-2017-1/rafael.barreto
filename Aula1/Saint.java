import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Saint{   
    private String nome; 
    private boolean armaduraVestida;
    private double vida = 100;
    protected int qtdsentidos = 5;
    private int acumulador = 0;
    private Armadura armadura;
    private Genero genero=Genero.NAO_INFORMADO;
    private Status status;
   


    public Saint(String nome, Armadura armadura){
        this.nome = nome;
        this.armadura = armadura;
        this.status = Status.VIVO;
        this.vida = 100;
    }  
    
    public String getNome(){
        return this.nome;
    }

    public double getVida(){
        return this.vida;
    }

    public void vestirArmadura(){
        this.armaduraVestida = true;
    }

    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }

    public Genero getGenero (){
        return this.genero;
    }

    public void setGenero(Genero genero){
        this.genero = genero;
    }

    public Status getStatus(){
        return this.status;
    }

    public void perderVida (double perdeVida) throws InvalidParameterException {
        int status=this.status.getStatusValor();

        if(perdeVida<0){
            throw new InvalidParameterException(" valor passado nao pode ser negativo ");
        }else if(this.vida>=1){           
            this.vida-=perdeVida;
            if(vida <= 0 && status !=2){this.status = Status.MORTO; this.vida=0;}
        }
    }   

    public int getCategoria(){
        int categoria = this.armadura.getCategoria().getValor();    
        return categoria;
    }

    public int getSentidosDespertados(){
        return this.qtdsentidos;   
    }

    private Constelacao getConstelacao(){
        return this.armadura.getConstelacao();
    }

    public ArrayList<Golpe> getGolpes(){    
        return this.getConstelacao().getGolpe();
    }

    public void aprenderGolpe(Golpe golpe){
        this.getConstelacao().adicionarGolpe(golpe);         
    }

    public Golpe getProximoGolpe(){         
        ArrayList<Golpe> golpesArray = getConstelacao().getGolpe();     
        if(golpesArray.size() > 0){
            int posicao = this.acumulador % golpesArray.size();
            Golpe golpe = golpesArray.get(posicao);
            this.acumulador++;
            return golpe;  
        }
        return null;                      
    }  
    
    public boolean equals(Object object){
        Saint saintFora = (Saint)object;      
    
        return this.nome.equals(saintFora.getNome())
            && this.status == saintFora.getStatus()
            && this.vida == saintFora.getVida()  
            && this.getCategoria() == saintFora.getCategoria();
    }  
    
    public int compareTo(Saint saint){        
        return this.nome.compareTo(saint.getNome());
    }
}