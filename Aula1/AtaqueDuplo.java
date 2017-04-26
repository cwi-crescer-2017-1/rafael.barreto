
public class AtaqueDuplo implements Movimento{
    public AtaqueDuplo(Saint saint1,Saint saint2){
        Saint golpeador = saint1;
        Saint golpeado = saint2;
    }
    
    public void executar(){
        double ataqueDuplo = new DadoD6().sortear()%3;       
        
    }     
}
