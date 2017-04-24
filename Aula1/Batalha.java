import java.util.ArrayList;

public class Batalha{

    private Saint saint1,saint2;
    final double dano=10;
    public Batalha(Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }   

    public void iniciar()throws Exception{
        boolean saint1Vivo= saint1.getStatus().equals(Status.VIVO);
        boolean saint2Vivo= saint1.getStatus().equals(Status.VIVO);        
        boolean saint1MaiorCategoria = (saint1.getCategoria()>=saint2.getCategoria());
        Saint saintEmAcao = null ;
        
        Movimento movimentoSaint1 = new Golpear(saint1,saint2);
        Movimento movimentoSaint2 = new Golpear(saint2,saint1);

        while(saint1Vivo && saint2Vivo){
            
            if(saint1MaiorCategoria ) {                
                saint1Vivo= saint1.getStatus().equals(Status.VIVO);
               
                if(saint1Vivo){ 
                    movimentoSaint1.executar(); 
                }
                saint2Vivo= saint2.getStatus().equals(Status.VIVO); 
                if(saint2Vivo){
                    movimentoSaint2.executar(); 
                }
            }else{                
                 saint2Vivo= saint2.getStatus().equals(Status.VIVO);
                
                 if(saint2Vivo){
                    movimentoSaint2.executar(); 
                }
                saint1Vivo= saint1.getStatus().equals(Status.VIVO); 
                if(saint1Vivo){
                     movimentoSaint1.executar(); 
                }
            } 
        }
    }   
}

