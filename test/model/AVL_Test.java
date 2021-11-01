import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import dataStructures.AVL;
import dataStructures.BST;
import model.Player;

class AVL_Test {
	
	AVL<Player> players;
	AVL<Player> players2;
	
	private void AVLStage1() {
		players = new AVL<>(new Comparator<Player>() {
            public int compare(Player i1,Player i2) {
                return i1.getPoints() - i2.getPoints();
            }
        });
		
		players2 = new AVL<>(new COmparator<Player>() {
			public int compare(Player i1, Player i2) {
				return i1.getRebounds() - i2.getRebounds();
			}
		});
	}
	
	private void AVLStage2() {
		players = new AVL<>(new Comparator<Player>() {
            public int compare(Player i1,Player i2) {
                return i1.getPoints() - i2.getPoints();
            }
        });
		
		players2 = new AVL<>(new COmparator<Player>() {
			public int compare(Player i1, Player i2) {
				return i1.getRebounds() - i2.getRebounds();
			}
		});
		
		Player player1 = new Player("Jacobo", "xxx", 4, "xxx", 8, 7, 3, 3, 3);
        Player player2 = new Player("Juan", "xxx", 3, "xx", 6, 3, 3, 3, 3);
        Player player3 = new Player("Sebastian", "xx", 10, "xxx", 15, 9, 3, 3, 3);
        
        players.insert(player3);
        players.insert(player2);
        players.insert(player1);
        
        players2.insert(player3);
        players2.insert(player2);
        players2.insert(player1);
	}
	
	@Test
    public void testInsert1() {
		AVLStage1();
		
		Player player1 = new Player("Jacobo", "xxx", 4, "xxx", 8, 7, 3, 3, 3);
        Player player2 = new Player("Juan", "xxx", 3, "xx", 6, 3, 3, 3, 3);
        Player player3 = new Player("Sebastian", "xx", 10, "xxx", 15, 9, 3, 3, 3);
        
        players.insert(player3);
        players.insert(player2);
        players.insert(player1);
        
        players2.insert(player3);
        players2.insert(player2);
        players2.insert(player1);
        
        boolean test1 = player1 == (players.getRoot().getValue().get(0));
        boolean test2 = player2 == (players.getRoot().getLeft().getValue().get(0));
        boolean test3 = player3 == (players.getRoot().getRight().getValue().get(0));
        
        boolean test4 = player1 == (players2.getRoot().getValue().get(0));
        boolean test5 = player2 == (players2.getRoot().getLeft().getValue().get(0));
        boolean test6 = player3 == (players2.getRoot().getRight().getValue().get(0));
         
        assertTrue(test1);
        assertTrue(test2);
        assertTrue(test3);
        assertTrue(players.getWeight()==2);
        
        assertTrue(test4);
        assertTrue(test5);
        assertTrue(test6);
        assertTrue(players2.getWeight()==2);
        
        /*If the method of inserting a node works correctly, 
         the method of balancing and rotations will also work correctly.
         */
	}
	
	@Test
	public void testInsert2() {
		AVLStage2();
		
		Player player4 = new Player("Santiago", "ss", 10, "sss", 12, 10, 3, 3, 3);
		
		players.insert(player4);
		players2.insert(player4);
		
		boolean test1 = player4 == (players.getRoot().getRight().getLeft().getValue().get(0));
        boolean test2 = player4 == (players2.getRoot().getRight().getLeft().getValue().get(0));
        
        assertTrue(test1);
        assertTrue(test2);
        assertTrue(players.getWeight()==3);
        assertTrue(players2.getWeight()==3);
	}
	
	
}
