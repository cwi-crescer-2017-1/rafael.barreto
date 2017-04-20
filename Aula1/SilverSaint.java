public class SilverSaint extends Saint{
      
    public SilverSaint (String nome, Armadura armadura){
        super(nome,armadura);
        this.qtdsentidos=6;
    }
    
    public SilverSaint(String nome, String armadura){
          super(nome,armadura,Categoria.PRATA);
          this.qtdsentidos = 5;         
    }
}