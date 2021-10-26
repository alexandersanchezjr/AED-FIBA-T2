package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import dataStructures.*;

public class FIBA {

    private ArrayList<Player> players;
    private BST<Player> playersBST;
    private RBT<Player> playersRBT;
    private AVL<Player> playersAVL;
    private BST<String> test;;
    private Comparator<Player>points;
    private Comparator<Player> rebounds;
    private Comparator<Player>assists;
    private Comparator<Player> robberies;
    private Comparator<Player>blocks;


    public FIBA() {
        players = new ArrayList<>();


        playersBST = new BST<>(new Comparator<Player>() {
            public int compare(Player i1,Player i2)
            {
                return i1.getAssists()-i1.getAssists();
            }
        });


        playersRBT = new RBT<>(null);
        playersAVL = new AVL<>(null);
        test=new BST<>(null);

        
        try {
            importData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }



    public static final String PLAYERS_FILE_NAME = "data/test.csv";

    public void importData() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(PLAYERS_FILE_NAME));

        String s;
        br.readLine();
        while ((s = br.readLine()) != null) {
            String[] line = s.split(",");
            Player player = new Player(line[0], line[1], Integer.parseInt(line[2]), line[3], Integer.parseInt(line[4]),
                    Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]),
                    Integer.parseInt(line[8]));
     
            player.setKey("blocks");

            playersBST.insert(player);
            
        }

        Player p=new Player("name", "lastName", 5, "team", 5, 5, 5, 4, 10);
        playersBST.inOrderMore(playersBST.getRoot(), p);
        System.out.println(playersBST.getList());
        System.out.println(playersBST.getWeight());

    }






}
