package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import dataStructures.*;

public class FIBA {

    private AVL<Player> reboundsAVL;
    private AVL<Player> pointsAVL;
    private RBT<Player> assistsRBT;
    private RBT<Player> robberiesRBT;
    private BST<Player> blocksBST;

    public FIBA() {

        pointsAVL = new AVL<>(new Comparator<Player>() {
            public int compare(Player i1, Player i2) {
                return i1.getPoints() - i2.getPoints();
            }
        });

        reboundsAVL = new AVL<>(new Comparator<Player>() {
            public int compare(Player i1, Player i2) {
                return i1.getRebounds() - i2.getRebounds();
            }
        });

        assistsRBT = new RBT<>(new Comparator<Player>() {
            public int compare(Player i1, Player i2) {
                return i1.getAssists() - i2.getAssists();
            }
        });

        robberiesRBT = new RBT<>(new Comparator<Player>() {
            public int compare(Player i1, Player i2) {
                return i1.getRobberies() - (i2.getRobberies());
            }
        });

        blocksBST = new RBT<>(new Comparator<Player>() {
            public int compare(Player i1, Player i2) {
                return i1.getBlocks() - (i2.getBlocks());
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

            reboundsAVL.insert(player);
            pointsAVL.insert(player);
            assistsRBT.insert(player);
            robberiesRBT.insert(player);
            blocksBST.insert(player);

        }

        br.close();

    }

    public ArrayList<Player> search(String criteria, String comparison, int value) {

        BST<Player> players = new BST<>(null);
        Player param = new Player("name", "lastName", 0, "team", 0, 0, 0, 0, 0);

        switch (criteria) {
        case "Points":
            players = pointsAVL;
            param.setPoints(value);

            break;

        case "Rebounds":
            players = reboundsAVL;
            param.setRebounds(value);

            break;

        case "Robberies":
            players = robberiesRBT;
            param.setRobberies(value);

            break;
        case "Blocks":
            players = blocksBST;
            param.setBlocks(value);

            break;
        case "Assists":
            players = assistsRBT;
            param.setAssists(value);

            break;

        default:
            break;
        }

        players.eraseNodes();

        switch (comparison) {
        case ">":
            players.inOrderMore(players.getRoot(), param);

            break;

        case "<":

            players.inOrderLess(players.getRoot(), param);

            break;

        case "=":
            players.searchEquals(players.getRoot(), param);

            break;

        default:
            break;
        }

        ArrayList<Player> playersList = players.getList();

        return playersList;
    }

}
