public enum Status{
    VIVO(1), 
    MORTO(2), 
    DESACORDADO(3);   
    
    private int valor;
    
    private Status(int valor){
        this.valor = valor;
    }  
   
    public int getStatusValor(){
        return this.valor;
    }
    
}