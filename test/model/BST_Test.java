package model;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.hamcrest.Description.NullDescription;
import org.junit.jupiter.api.Test;

import dataStructures.BST;



public class BST_Test {
    BST<Player> players;



    private void stage1() {
         players =new BST<>();

    }


    private void stage2(){
        players =new BST<>();

        Player player1=new Player("Jacobo", "xxx", 4, "xxx", 3, 3, 3, 3, 3);

        Player player2=new Player("Juan", "xxx", 3, "xx", 3, 3, 3, 3, 3);
    
    
        Player player3=new Player("Sebastian", "xx", 10, "xxx", 3, 3, 3, 3, 3);
        players.insert(player3);
        players.insert(player2);
        players.insert(player1);
    }



    @Test
    public void testInsert() {

        stage1();

        Player player1=new Player("Jacobo", "xxx", 4, "xxx", 3, 3, 3, 3, 3);

        Player player2=new Player("Juan", "xxx", 3, "xx", 3, 3, 3, 3, 3);
    
    
        Player player3=new Player("Sebastian", "xx", 10, "xxx", 3, 3, 3, 3, 3);
        players.insert(player3);
        players.insert(player2);
        players.insert(player1);

    
        boolean test1=  player3==(players.getRoot().getValue());
        boolean test2=player2==(players.getRoot().getLeft().getValue());
       boolean test3=player1==(players.getRoot().getLeft().getRight().getValue());
         
        assertTrue(test1);
        assertTrue(test2);
        assertTrue(test3);

        assertTrue(players.getWeight()==3);
    
    }


    @Test
    public void testSearch(){
        stage2();

        Player player=new Player("xxx", "xxxx", 11, "sdfsdf", 3, 3, 3, 3, 3);


        try {
           players.search(player);
        } catch (NullPointerException e) {
            assertTrue(true);
        }

        Player player3=new Player("Sebastian", "xx", 10, "xxx", 3, 3, 3, 3, 3);


        assertNotNull(player3);

        
    }


    @Test
    public void testDelete(){
        stage2();


        Player player3=new Player("Sebastian", "xx", 10, "xxx", 3, 3, 3, 3, 3);

        players.delete(player3);
        boolean test=3==players.getRoot().getValue().getAge();

        assertTrue(test);

        
    }









 


}