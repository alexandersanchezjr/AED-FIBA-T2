package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import dataStructures.*;

public class FIBA {

    private BST<Player> pointsBST;
    private AVL<Player> reboundsAVL;
    private AVL<Player> playersAVL;
    private RBT<Player> assistsRBT;
    private RBT<Player> testRBT;
    //private AVL<Player> playersAVL;
    //private BST<String> test;;



    public FIBA() {


        pointsBST = new BST<>(new Comparator<Player>() {
            public int compare(Player i1,Player i2)
            {
                return i1.getPoints()-i2.getPoints();
            }
        });


        reboundsAVL = new AVL<>(new Comparator<Player>() {
            public int compare(Player i1,Player i2)
            {
                return i1.getRebounds()-i2.getRebounds();
            }
        });

        assistsRBT = new RBT<>(new Comparator<Player>() {
            public int compare(Player i1,Player i2)
            {
                return i1.getAssists()-i2.getAssists();
            }
        });


        testRBT = new RBT<>(new Comparator<Player>() {
            public int compare(Player i1,Player i2)
            {
                return i1.getPoints()-(i2.getPoints());
            }
        });

   


        try {
            importData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }



    public static final String PLAYERS_FILE_NAME = "data/Dataset.csv";

    public void importData() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(PLAYERS_FILE_NAME));

        String s;
        br.readLine();
        while ((s = br.readLine()) != null) {
            String[] line = s.split(",");
            Player player = new Player(line[0], line[1], Integer.parseInt(line[2]), line[3], Integer.parseInt(line[4]),
                    Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]),
                    Integer.parseInt(line[8]));
     

                    //pointsBST.insert(player);
            
        }
        System.out.println(pointsBST.getWeight());
        //REVISAR ES BST CON ARRAYLIST PARA LOS IGUALES 

        Player param=new Player("name", "lastName", 30, "team", 10, 5, 5, 4, 10);

        pointsBST.searchEquals(pointsBST.getRoot(), param);
        System.out.println(pointsBST.getList());
        //playersBST.inOrderMore(playersBST.getRoot(), p);
        //System.out.println(playersBST.getList());
        //System.out.println(playersBST.getWeight());

    }






}
