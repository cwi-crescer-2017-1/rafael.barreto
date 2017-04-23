public class GoldSaint extends Saint {

    public GoldSaint(String nome, String nomeConstelacao) throws Exception {
          super(nome,nomeConstelacao,Categoria.OURO);
          this.qtdsentidos = 7;    
          
          String constelacao = this.getArmadura().getConstelacao().getNome();
          // getarmadura().getConstelacao().getNome();
        
        if( !constelacao.equals("Aries") 
         && !constelacao.equals("Touro")
         && !constelacao.equals("Gemeos")
         && !constelacao.equals("Cancer")
         && !constelacao.equals("Virgem")
         && !constelacao.equals("Leao")
         && !constelacao.equals("Libra")
         && !constelacao.equals("Escorpiao")
         && !constelacao.equals("Sagitario")
         && !constelacao.equals("Capricornio")
         && !constelacao.equals("Aquario")
         && !constelacao.equals("Peixes")){
             
             throw new Exception("Constelacao invaida");         
        } 
    }
}