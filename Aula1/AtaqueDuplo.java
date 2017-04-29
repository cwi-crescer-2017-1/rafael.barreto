
public class AtaqueDuplo implements Movimento{
    private Saint golpeador,golpeado;  
    
    public AtaqueDuplo(Saint saint1,Saint saint2){
        golpeador = saint1;
        golpeado = saint2;
    }
    
    public void executar(){
        int numeroSorteado = new DadoD6().sortear();        
        boolean ataqueDuplo = numeroSorteado > 2 ? true : false;
        
        if(ataqueDuplo){
            int posicao = golpeador.posicaoGolpe()  %  golpeador.getArmadura().getConstelacao().getGolpe().size();
            int dano = golpeador.getGolpes().get(posicao).getFatorDano() * 2 ;            
            golpeado.perderVida(dano);
        }        
    }     
}