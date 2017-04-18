public class Constelacao{
    private String nome;
    private Golpe[] golpe = new Golpe[3];
    private int ultimaPosicaoPreenchida =0;
    
    public Constelacao (String nome){
        this.nome = nome;    
    }
    
    
    public Constelacao (String nome,Golpe golpe1,Golpe golpe2,Golpe golpe3){
        this.nome = nome;
        this.golpe[0] = golpe1;
        this.golpe[1] = golpe2;
        this.golpe[2] = golpe3;    
    }
    /*
    public Constelacao (String nome,Golpe[] golpe){
        this.nome = nome;
        this.golpe[0] = golpe[0];
        this.golpe[1] = golpe[1];
        this.golpe[2] = golpe[2];    
    }*///teste 
    
    public String getNome(){
        return this.nome; 
    }
    
    public void adicionarGolpe(Golpe golpe){
       this.golpe[ultimaPosicaoPreenchida++] = golpe;      
    }  
    
    public Golpe[] getGolpe(){
        return this.golpe;
    }   
}