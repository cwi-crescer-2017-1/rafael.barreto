public class Saint{   
    private String nome; 
    private boolean armaduraVestida;
    private double vida = 100;
    protected int qtdsentidos = 5;
    private Armadura armadura;
    private Genero genero=Genero.NAO_INFORMADO;
    private Status status;       

    public Saint(String nome, Armadura armadura){
        this.nome = nome;
        this.armadura = armadura;
        this.status = Status.VIVO;
        this.vida = 100;
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

    public void perderVida(double perdeVida){
        this.vida-=perdeVida;
    }   

    public int getCategoria(){
        int categoria = this.armadura.getCategoria().getValor();    
        return categoria;
    }

    public int getSentidosDespertados(){
        return this.qtdsentidos;   
    }
}