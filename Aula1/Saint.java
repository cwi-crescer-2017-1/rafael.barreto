import java.security.InvalidParameterException;
import java.util.ArrayList;


public abstract class Saint{   
    private String nome; 
    private boolean armaduraVestida;
    private double vida = 100;
    protected int qtdsentidos = 5;
    private int acumuladorGolpes = 0;
    private int acumuladorMovimento =0;
    private int id = 0;
    private static int quantidadeDeSaints = 0;
    private static int qtdSaints = 0;
    private ArrayList <Movimento> movimentos = new ArrayList<>();
    private Armadura armadura;
    private Genero genero=Genero.NAO_INFORMADO;
    private Status status;
    

  
    public Saint(String nome, String nomeConstelacao, Categoria categoriaArmadura){        
        Constelacao constelacao = new Constelacao(nomeConstelacao);
        Armadura armadura = new Armadura(constelacao,categoriaArmadura);

        this.nome = nome;
        this.status = Status.VIVO;
        this.vida = 100; 
        this.armadura = armadura;
        this.id =  ++Saint.quantidadeDeSaints;
        Saint.qtdSaints ++;
    }
    
    public int posicaoGolpe(){
        return this.acumuladorGolpes;
    }
    
    protected void finalize() throws Throwable {
        Saint.qtdSaints --;    
    }
    
    public static int getQtdSaints(){
        return Saint.qtdSaints;
    }
    
    public static int quantidadeDeSaints(){
      return Saint.quantidadeDeSaints;  
    }
    
    public int getId(){
        return this.id;
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

    public Armadura getArmadura(){
        return this.armadura;
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
        
        boolean contemGolpe = this.getConstelacao().getGolpe().isEmpty();
        if(contemGolpe){ return null;  }
        else{  return this.getConstelacao().getGolpe(); }
    }

    public void aprenderGolpe(Golpe golpe){
        this.getConstelacao().adicionarGolpe(golpe);         
    }

    public Golpe getProximoGolpe(){         
        ArrayList<Golpe> golpesArray = getConstelacao().getGolpe();     
        if(golpesArray.size() > 0){
            int posicao = this.acumuladorGolpes % golpesArray.size();
            Golpe golpe = golpesArray.get(posicao);
            this.acumuladorGolpes++;
            return golpe;  
        }
        return null;                      
    }  

    public boolean equals(Object object){
        Saint saintFora = (Saint)object;      

        return this.nome.equals(saintFora.getNome())
        && this.status == saintFora.getStatus()
        && this.vida == saintFora.getVida()  
        && this.getCategoria() == saintFora.getCategoria()
        && this.getId() == saintFora.getId();
    }

     public String getCSV(){        

         return String.format(
            "%s,%s,%s,%s,%s,%s,%s",
            this.nome,
            this.vida,
            this.getConstelacao().getNome(),
            this.armadura.getCategoria(),
            this.status,
            this.genero,
            this.armaduraVestida);
     }
    
    public void adicionarMovimento(Movimento movimento){        
        this.movimentos.add(movimento);
    }
    
    public Movimento getProximoMovimento(){
        Movimento movimentos = null; 
        
        if(this.movimentos.size()>0){
            int posicao  = acumuladorMovimento % this.movimentos.size();
            movimentos = (this.movimentos.get(posicao));
            this.acumuladorMovimento ++;
            return movimentos;
        }    
        return null;
    } 
    
    //"agendando" execução do golpe no saint passado por parâmetro
    // o golpe de fato só será executado na batalha.
    public void golpear(Saint golpeado) {
        this.adicionarMovimento(new Golpear(this, golpeado));
    }
    
    
}