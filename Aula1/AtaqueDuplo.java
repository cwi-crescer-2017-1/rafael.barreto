
public class AtaqueDuplo implements Movimento{
    private Saint golpeador,golpeado;  
    
    public AtaqueDuplo(Saint saint1,Saint saint2){
        golpeador = saint1;
        golpeado = saint2;
    }
    
    public void executar(){
        int numeroSorteado = new DadoD6().sortear();  
        boolean ataqueDuplo = numeroSorteado > 2 ? true : false;
        boolean armaduraVestida = golpeador.getArmaduraVestida();
        
        
        if(ataqueDuplo){
            int posicao = golpeador.posicaoGolpe()  %  golpeador.getArmadura().getConstelacao().getGolpe().size();
            double dano = golpeador.getArmaduraVestida() ? golpeador.getGolpes().get(posicao).getFatorDano() * 2 : golpeador.getGolpes().get(posicao).getFatorDano();
            dano = dano * 2 ;
            golpeado.perderVida(dano);
        }else{
            golpeador.perderVida(5);
        }        

    }    
    
    // ---- TRECHO DE CODIGO UTILIZADO SOMENTE PARA TESTAR A CLASSE ATAQUE DUPLO -----------
    
    public void executarTesteGolpeDuploTrue(){
        int numeroSorteado = new DadoViciado(3).sortear();    // UTILIZANDO DADO VICIADO NO TESTE
        boolean ataqueDuplo = numeroSorteado > 2 ? true : false;
        boolean armaduraVestida = golpeador.getArmaduraVestida();
        
        
        if(ataqueDuplo){
            int posicao = golpeador.posicaoGolpe()  %  golpeador.getArmadura().getConstelacao().getGolpe().size();
            double dano = golpeador.getArmaduraVestida() ? golpeador.getGolpes().get(posicao).getFatorDano() * 2 : golpeador.getGolpes().get(posicao).getFatorDano();
            dano = dano * 2 ;
            golpeado.perderVida(dano);
        }else{
            golpeador.perderVida(5);
        }    
    }
    
    public void executarTesteGolpeDuploFalse(){
        int numeroSorteado = new DadoViciado(1).sortear();    // UTILIZANDO DADO VICIADO NO TESTE
        boolean ataqueDuplo = numeroSorteado > 2 ? true : false;
        boolean armaduraVestida = golpeador.getArmaduraVestida();
        
        
        if(ataqueDuplo){
            int posicao = golpeador.posicaoGolpe()  %  golpeador.getArmadura().getConstelacao().getGolpe().size();
            double dano = golpeador.getArmaduraVestida() ? golpeador.getGolpes().get(posicao).getFatorDano() * 2 : golpeador.getGolpes().get(posicao).getFatorDano();
            dano = dano * 2 ;
            golpeado.perderVida(dano);
        }else{
            golpeador.perderVida(5);
        }    
    }
}