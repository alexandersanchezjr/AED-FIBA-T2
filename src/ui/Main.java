package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



import dataStructures.BST;
import model.FIBA;
import model.Player;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*


        long inicio = System.currentTimeMillis();
        BST<Player> players=new BST<>();
        String archCSV = "data/Dataset.csv";
        BufferedReader br=new BufferedReader(new FileReader(archCSV));
        
        String s;
        br.readLine();
        while ((s = br.readLine()) != null) {
            String[] line=s.split(",");
            Player player=new Player(line[0], line[1], Integer.parseInt(line[2]), line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]), Integer.parseInt(line[8]));
            players.insert(player);
            
            
        }

      
         
        long fin = System.currentTimeMillis();
         
        double tiempo = (double) ((fin - inicio)/1000);
         
        System.out.println(tiempo +" segundos");

        br.close();
        */

        long inicio = System.currentTimeMillis();

        FIBA test=new FIBA();


        long fin = System.currentTimeMillis();
         
        double tiempo = (double) ((fin - inicio)/1000);
         
        System.out.println(tiempo +" segundos");

    }


  
}
