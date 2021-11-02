package model;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import dataStructures.AVL;
import dataStructures.RBT;

public class FIBA_Test {

	private FIBA newFIBA;
	private AVL<Player> pointsAVL;
	private RBT<Player> robberiesRBT;
	
	private void FIBAStage1() {
		newFIBA = new FIBA();
		
		pointsAVL = new AVL<>(new Comparator<Player>() {
            public int compare(Player i1,Player i2) {
                return i1.getPoints() - i2.getPoints();
            }
        });
		
		robberiesRBT = new RBT<>(new Comparator<Player>() {
			public int compare(Player i1, Player i2) {
				return i1.getRobberies() - i2.getRobberies();
			}
		});
		
		Player player1 = new Player("Jacobo", "xxx", 4, "xxx", 8, 7, 12, 13, 3);
        Player player2 = new Player("Juan", "xxx", 3, "xx", 6, 3, 10, 9, 3);
        Player player3 = new Player("Sebastian", "xx", 10, "xxx", 15, 9, 11, 12, 3);
        Player player4 = new Player("Santiago", "ss", 12, "sss", 10, 12, 5, 13, 3);
        Player player5 = new Player("Mateo","Perez", 13, "dfd", 13, 4, 6, 5, 3);
        
        pointsAVL.insert(player1);
        pointsAVL.insert(player2);
        pointsAVL.insert(player3);
        pointsAVL.insert(player4);
        pointsAVL.insert(player5);
        
        robberiesRBT.insert(player1);
        robberiesRBT.insert(player2);
        robberiesRBT.insert(player3);
        robberiesRBT.insert(player4);
        robberiesRBT.insert(player5);
        
        newFIBA.setPointsAVL(pointsAVL);
        newFIBA.setRobberiesRBT(robberiesRBT);
	}
	
	@Test
	public void testSearch1() {
		FIBAStage1(); 
		
		Player playerSearch1 = newFIBA.search("Points", ">", 12).get(0); 
		boolean test1 = playerSearch1.getPoints() > 12;
		
		assertTrue(test1);
		assertEquals(playerSearch1, pointsAVL.getRoot().getRight().getRight().getValue().get(0));
	}
	
	@Test
	public void testSearch2() {
		FIBAStage1();
		
		Player playerSearch2 = newFIBA.search("Robberies", "=", 13).get(0);
		boolean test1 = playerSearch2.getRobberies() == 13;
		
		assertTrue(test1);
	}
}
