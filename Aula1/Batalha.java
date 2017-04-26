import java.util.ArrayList;

public class Batalha{

    private Saint saint1,saint2;
    final double dano=10;
    public Batalha(Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }   

    public void iniciar()throws Exception{
        int valor1 = this.saint1.getCategoria();
        int valor2 = this.saint2.getCategoria();
        final double dano =10;
        Saint saintEmAcao = null;
        
        if(valor1>= valor2){
             saintEmAcao = saint1;
             this.saint2.perderVida(dano);
        }else{
            saintEmAcao = saint2;
            this.saint1.perderVida(dano);
        }
        
        boolean saintsVivos = true;
        while(saintsVivos){
            
            saintEmAcao = saintEmAcao == this.saint1 ? this.saint2 : this.saint1;
            
            Movimento proximoMovimento = saintEmAcao.getProximoMovimento();
            proximoMovimento.executar();
        
            saintsVivos = this.saint1.getStatus() != Status.MORTO && this.saint2.getStatus() != Status.MORTO;
        
        }
    }   
}

