package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import dataStructures.*;

public class FIBA {

    private BST<Player> players;
    private RBT<Player> playersRBT;
    private AVL<Player> playersAVL;

    public FIBA() throws ClassNotFoundException, IOException {
        players=new BST<>();
        playersRBT=new RBT<>();
        playersAVL=new AVL<>();
        importData();

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
            players.insert(player);
            playersRBT.insert(player);
            playersAVL.insert(player);


        }
        br.close();
    }

}
