public class Batalha{
    
    public void iniciar(Saint saint1, Saint saint2){
          
        int categoriaSaint1 = saint1.getCategoria();
        int categoriaSaint2 = saint2.getCategoria();
        
        if(categoriaSaint1>categoriaSaint2 || categoriaSaint1==categoriaSaint2){
            saint2.perderVida(10);            
        }else{
                saint1.perderVida(10);         
         }
    }
}
    