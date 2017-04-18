public class Batalha{
    
    private Saint saint1,saint2;
    final double dano=10;
    public Batalha(Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }
    
    public void iniciar()throws Exception{
        int valor1 = saint1.getCategoria();
        int valor2 = saint2.getCategoria();
        
        if(valor1>=valor2){
          this.saint2.perderVida(dano);
        }else{
          this.saint1.perderVida(dano);
        }
    }   
}
    