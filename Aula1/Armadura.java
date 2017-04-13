public class Armadura{
    private String constelacao;
    private Categoria categoria = Categoria.BRONZE;
    
    public Armadura(String constelacao, Categoria categoria ){
        this.constelacao=constelacao;   
        this.categoria = categoria;
    }    
}