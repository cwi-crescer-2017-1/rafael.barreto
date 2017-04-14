public class Batalha{
    
    public void iniciar(Saint saint1, Saint saint2){
          
        int categoriaSaint1 = saint1.getCategoria();
        int categoriaSaint2 = saint2.getCategoria();
        
        if(categoriaSaint1>categoriaSaint2){
            saint2.perderVida();            
        }else{
            if(categoriaSaint1==categoriaSaint2){
                saint2.perderVida();
            }else{
                saint1.perderVida();
            }
        }
    }
}
    