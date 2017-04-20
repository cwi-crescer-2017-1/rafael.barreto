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

    public Saint getSaintMenorVida(){  //retorna primeiro saint encontrado com a menor vida
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
        boolean precisaTrocarPosicao;

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

    public ListaSaints unir(ListaSaints lista){        
         ListaSaints listaUnida = new ListaSaints();

         listaUnida.unirlistas(this.listaSaints);
         listaUnida.unirlistas(lista.todos());   
         
         return listaUnida;
    } 
    
    public ListaSaints diff(ListaSaints lista){
        ListaSaints listaDiff = new ListaSaints();
        
        listaDiff.unirlistas(this.listaSaints);
        listaDiff.diffListas(lista.todos());
    
        return listaDiff;
    }
    
   
    public ListaSaints intersec(ListaSaints lista){
        ListaSaints listaIntersec = new ListaSaints();
        
        int tamanhoLista1 = this.listaSaints.size();
        int tamanhoLista2 = lista.todos().size();
        int tamanho;
        
        if(tamanhoLista1 > tamanhoLista2) {tamanho = tamanhoLista2;}
        else {tamanho = tamanhoLista1;}
        
        for(int i=0; i < tamanho ; i++){
            listaIntersec.adicionar(this.listaSaints.get(i));
            listaIntersec.adicionar(lista.todos().get(i));        
        }                
        
       return listaIntersec;
    }
    
    // METODOS PRIVADOS
    
    private void unirlistas(ArrayList<Saint> lista){              
       
        for ( Saint saint : lista){
            listaSaints.add(saint);
        }        
    }
    
    private void diffListas( ArrayList<Saint> lista2){        
        int tamanhoLista1 = this.listaSaints.size();
        int tamanhoLista2 = lista2.size();
        int tamanho;
        
        if (tamanhoLista1>tamanhoLista2){tamanho = tamanhoLista2;}
        else {tamanho = tamanhoLista1;}
        
        for( int i =0; i<tamanho; i++){
            
            String nome1 = this.listaSaints.get(i).getNome();
            String nome2 = lista2.get(i).getNome();
            
            boolean saintNomeIgual = !nome1.equals(nome2);            
            
            if(saintNomeIgual){
                listaSaints.add(lista2.get(i));
            }        
        }        
    }       
}