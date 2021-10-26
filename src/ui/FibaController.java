package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.FIBA;

public class FIBAController{

    @FXML
	private ChoiceBox<String> criteriaBox;
	
	@FXML
	private ChoiceBox<String> comparisonBox;
	
	@FXML
	private TextField valueBox;

    private FIBA test;

    public FIBAController() throws ClassNotFoundException, IOException{
        FIBA test=new FIBA();

    }

    public void search(){}

    public void loadMenu(){
		
		criteriaBox.getItems().addAll("Points","Rebounds","Assists","Robberies","Blocks","Age");
		criteriaBox.setValue("Points");
		comparisonBox.getItems().addAll("=",">","<");
		comparisonBox.setValue("=");
       
	}



}
