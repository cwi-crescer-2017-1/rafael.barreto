public class DadoViciado implements Sorteador{
    int valor;
    public DadoViciado(int numero ){
        valor = numero;
    }

    public int sortear() {
        return valor;
    }    


}
