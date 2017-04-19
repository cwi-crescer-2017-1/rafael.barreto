import java.util.ArrayList;

public class ListaSaints{
    
    ArrayList<Saint> listaSaints = new ArrayList<>();
  
    public void adicionar(Saint saint){
        this.listaSaints.add(saint);
    }
    
    public Saint get(int indice){
        Saint saint; 
        saint = this.listaSaints.get(indice);
        return saint;
    }
    
    public ArrayList todos(){
        return this.listaSaints;
    }
    
    public void remover(Saint saint){
        listaSaints.remove(saint);    
    }
    
    public Saint buscarPorNome(String nome){        
        int tamanhoLista = listaSaints.size();
        
        for(int i = 0; i<tamanhoLista;i++){
            Saint saint = this.listaSaints.get(i);
            if(nome.equals(saint.getNome())){
                return saint;                
            }
        }
        return null;
    }
    
    public Saint buscarPorCategoria(Categoria categoria){return null;}
    
    public Saint buscarPorStatus(Status status){
        int tamanhoLista = listaSaints.size();
        
        for(int i=0; i<tamanhoLista;i++){
            Saint saint = this.listaSaints.get(i);
            if(status == saint.getStatus()){
                return saint;
            }        
        }
    return null;
    }
    
    
    public Saint getSaintMaiorVida(){//retorna primeiro saint encontrado com a maior vida
        return null;
    }
    
    
    public Saint getSaintMenorVida(){//retorna primeiro saint encontrado com a menor vida
        return null;
    }
    
    public void ordenar(){   }   

}