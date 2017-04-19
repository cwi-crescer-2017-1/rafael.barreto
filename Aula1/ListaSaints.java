import java.util.*;

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

    public Saint buscarPorCategoria(Categoria categoria){
        int tamanhoLista = listaSaints.size();

        for(int i = 0 ; i<tamanhoLista; i++){
            Saint saint = this.listaSaints.get(i);
            if(saint.getCategoria() == categoria.getValor()){
                return saint;
            }        
        }
        return null;
    }

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

    public Saint getSaintMenorVida(){//retorna primeiro saint encontrado com a menor vida
        int tamanhoLista = listaSaints.size();
        Saint saint = listaSaints.get(0);

        for(int i=0; i<tamanhoLista;i++){
            Saint saintLista = listaSaints.get(i);

            if(saintLista.getVida() < saint.getVida()){
                saint = saintLista;               
            }
        }    
        return saint;
    }

    public void ordenar(){ 
        int tamanhoLista = listaSaints.size();
        int resultado;
        Saint saint;
        Saint saintLista;
        Saint saintTemp;         
        
        for (int i = 0; i < listaSaints.size(); i++) {

            for (int j = listaSaints.size() - 1; j > i; j--) {
                if (listaSaints.get(i).getNome().compareToIgnoreCase(listaSaints.get(j).getNome()) > 0) {

                    saintTemp = listaSaints.get(i);
                    listaSaints.set(i, listaSaints.get(j));
                    listaSaints.set(j, saintTemp);

                }
            }
        }

    }
}