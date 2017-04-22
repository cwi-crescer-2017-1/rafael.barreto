public class CsvToString extends Saint{
    
    public CsvToString(String nome, String armaduraNome){
        super (nome,armaduraNome,Categoria.BRONZE);
    }

     
   public String[] toString (String nome){
       String [] csv  = nome.split(",", 1);
       
       
       
       return csv;
   }
}