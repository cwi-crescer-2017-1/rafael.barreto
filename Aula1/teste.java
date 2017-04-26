import java.util.*;

public class teste {

    public static void imprimirSaint (){
       Map <Integer,Saint> todosSaints = new HashMap<>();

        try{
            Saint seiya = new GoldSaint ("Seiya","Sagitario");
            Saint shiryu = new GoldSaint ("shiryu","Libra");
            Saint shun = new GoldSaint ("shun","Virgem");
            Saint shaka = new GoldSaint ("shaka","Virgem");

            todosSaints.put(seiya.getId(),seiya);
            todosSaints.put(shiryu.getId(),shiryu);
            todosSaints.put(shun.getId(),shun);
            todosSaints.put(shaka.getId(),shaka); 
            
            seiya.vestirArmadura();
            
            for(Map.Entry<Integer,Saint> saint : todosSaints.entrySet()){
                System.out.println("nome : " + saint.getValue().getNome());  
                System.out.println("vida : " + saint.getValue().getVida());  
                System.out.println("Status : " + saint.getValue().getStatus());  
                System.out.println("Constelacao : " + saint.getValue().getArmadura().getConstelacao().getNome());
                String armaduraVestida = saint.getValue().getArmaduraVestida() ? "sim" : "nao" ;
                System.out.println("Constelacao : " + armaduraVestida );
                System.out.println("--------------------------------------------------------");
            }
            

        }catch(Exception classeInvalida){
            System.out.println(" Classe Invalida" +classeInvalida);
        }        
    }
}