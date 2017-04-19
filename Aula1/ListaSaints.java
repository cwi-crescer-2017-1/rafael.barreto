import java.util.*;
import java.util.stream.Collectors;

public class ListaSaints{

    private ArrayList<Saint> listaSaints = new ArrayList<>(); 

    public void adicionar(Saint saint){
        this.listaSaints.add(saint);
    }

    public Saint get(int indice){       
        return this.listaSaints.get(indice);
    }

    public ArrayList<Saint> todos(){
        return this.listaSaints;
    }

    public void remover(Saint saint){
        this.listaSaints.remove(saint);    
    }

    public Saint buscarPorNome(String nome){

        for(Saint saint : listaSaints){
            if(saint.getNome().equals(nome)){
                return saint;
            }
        }
        return null;
    }
    //Arrumar teste deste metodo
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria){        
        ArrayList<Saint> subLista = new ArrayList<>();
        for ( Saint saint : this.listaSaints){
            if(saint.getArmadura().getCategoria().equals(categoria) ){
                subLista.add(saint); 
            }
        }      
        return subLista;
        /*
        return (ArrayList<Saint>)this.listaSaints.stream()
        .filter(s-> s.getArmadura().getCategoria().equals(categoria))
        .collect(Collectors.toList()); */ // exercicio resolvida com lambda do java 8

    }
    //Arrumar teste dese metodo
    public ArrayList<Saint> buscarPorStatus(Status status){
        ArrayList<Saint> subLista = new ArrayList<>();

        for(Saint saint : this.listaSaints){            
            if(status == saint.getStatus()){
                subLista.add(saint);
            }        
        }
        return subLista;
    }

    public Saint getSaintMaiorVida(){//retorna primeiro saint encontrado com a maior vida
        if(listaSaints.isEmpty())return null;
        int tamanhoLista = listaSaints.size();
        Saint saint = listaSaints.get(0);

        for(int i=0; i<tamanhoLista;i++){
            Saint saintLista = listaSaints.get(i);

            if(saintLista.getVida() > saint.getVida()){
                saint = saintLista;                                
            }
        }       
        return saint;
    }

    public Saint getSaintMenorVida(){
        //retorna primeiro saint encontrado com a menor vida
        if(listaSaints.isEmpty())return null;
        int tamanhoLista = listaSaints.size();       

        Saint saint = listaSaints.get(0);

        for(int i=0; i<tamanhoLista;i++){
            Saint saintLista = listaSaints.get(i);
            boolean saintMaior = saintLista.getVida() < saint.getVida();

            if(saintMaior){
                saint = saintLista;               
            }
        }    
        return saint;
    };

    public void ordenar(){      
        int tamanhoLista = listaSaints.size();
        int resultado;
        Saint saintTemp;        

        for (int i = 0; i < listaSaints.size(); i++) {
            for (int j = listaSaints.size() - 1; j > i; j--) {                
                if (listaSaints.get(i).getVida() < listaSaints.get(j).getVida()) {
                    saintTemp = listaSaints.get(i);
                    listaSaints.set(i, listaSaints.get(j));
                    listaSaints.set(j, saintTemp);
                }
            }
        }
    }

    public void ordenar(TipoOrdenacao ordenacao){
        boolean precisaTrocarPosicao=false;
        if(ordenacao.equals(TipoOrdenacao.ASCENDENTE)){
            do { 
                precisaTrocarPosicao = false; 
                for (int i = 0; i < this.listaSaints.size() - 1; i++) { 
                    Saint atual = this.listaSaints.get(i); 
                    Saint proximo = this.listaSaints.get(i + 1); 
                    boolean precisaTrocar = atual.getVida() < proximo.getVida(); 
                    if (precisaTrocar) { 
                        this.listaSaints.set(i, proximo); 
                        this.listaSaints.set(i + 1, atual); 
                        precisaTrocarPosicao = true; 
                    } 
                } 
            } while (precisaTrocarPosicao);  
        }

        if(ordenacao.equals(TipoOrdenacao.DESCENDENTE)){
            do { 
                precisaTrocarPosicao = false; 
                for (int i = 0; i < this.listaSaints.size() - 1; i++) { 
                    Saint atual = this.listaSaints.get(i); 
                    Saint proximo = this.listaSaints.get(i + 1); 
                    boolean precisaTrocar = atual.getVida() > proximo.getVida(); 
                    if (precisaTrocar) { 
                        this.listaSaints.set(i, proximo); 
                        this.listaSaints.set(i + 1, atual); 
                        precisaTrocarPosicao = true; 
                    } 
                } 
            } while (precisaTrocarPosicao); 
        }
    }
    
    public ListaSaints unir(ArrayList<Saint> lista){
        int tamanho = listaSaints.size();       
        tamanho = lista.size();
        for(int i = 0 ; i < tamanho ; i++){
            listaSaints.add(lista.get(i));        
        } 
        return null;
    }   
}