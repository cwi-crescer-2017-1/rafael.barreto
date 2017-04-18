import java.util.ArrayList;

public class ListaSaints{
    
    ArrayList listaSaints = new ArrayList<>();

    public void adicionar(Saint saint){
        this.listaSaints.add(saint);
    }
    
    public Saint get(int indice){
        return null;
    }
    
    public ArrayList todos(){return null;}
    
    public void remover(Saint saint){}
    
    public String buscarPorNome(String nome){return null;}
    
    public ArrayList buscarPorStatus(Status status){return null;}
    
    public Saint getSaintMaiorVida(){return null;}
    
    public Saint getSaintMenorVida(){return null;}
    
    public void ordenar(){}
}