package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.FIBA;
import model.Player;

public class FIBAController {

	@FXML
	private AnchorPane mainPane;

	@FXML
	private ChoiceBox<String> criteriaBox;

	@FXML
	private ChoiceBox<String> comparisonBox;

	@FXML
	private TextField valueBox;

	@FXML
	private TableView<Player> tablePlayers;

	@FXML
	private TableColumn<Player, String> idName;

	@FXML
	private TableColumn<Player, String> idLastName;

	@FXML
	private TableColumn<Player, Integer> idAge;

	@FXML
	private TableColumn<Player, String> idTeam;

	@FXML
	private TableColumn<Player, Integer> idPoints;

	@FXML
	private TableColumn<Player, Integer> idRebounds;

	@FXML
	private TableColumn<Player, Integer> idAssists;

	@FXML
	private TableColumn<Player, Integer> idRobberies;

	@FXML
	private TableColumn<Player, Integer> idBlocks;

	private ArrayList<Player> players;

	private FIBA fiba;

	public FIBAController(FIBA fiba) {
		this.fiba = fiba;

	}

	@FXML
	public void search(ActionEvent event) throws IOException {

		if (valueBox.getText() != null && valueBox.getText().trim().isEmpty() == false) {
			double start = System.currentTimeMillis();

			String criteria = criteriaBox.getValue();
			String comparison = comparisonBox.getValue();
			int value = Integer.parseInt(valueBox.getText());

			players = fiba.search(criteria, comparison, value);
			double end = System.currentTimeMillis();
			double time = end - start;

			loadTable();

			System.out.println("THE TIME OF THE SEARCH IN MILISECONDS IS : " + time);
		}

	}

	private void loadTable() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Table.fxml"));
		fxmlLoader.setController(this);
		Parent pane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().addAll(pane);

		tablePlayers.getItems().clear();
		if (players.isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Players not found");
			alert.setContentText("No players with those characteristics were found");
			alert.showAndWait();
		} else {
			ObservableList<Player> list = FXCollections.observableArrayList(players);
			tablePlayers.setItems(list);
			idName.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
			idLastName.setCellValueFactory(new PropertyValueFactory<Player, String>("lastName"));
			idAge.setCellValueFactory(new PropertyValueFactory<Player, Integer>("age"));
			idTeam.setCellValueFactory(new PropertyValueFactory<Player, String>("team"));
			idPoints.setCellValueFactory(new PropertyValueFactory<Player, Integer>("points"));
			idRebounds.setCellValueFactory(new PropertyValueFactory<Player, Integer>("rebounds"));
			idAssists.setCellValueFactory(new PropertyValueFactory<Player, Integer>("assists"));
			idRobberies.setCellValueFactory(new PropertyValueFactory<Player, Integer>("robberies"));
			idBlocks.setCellValueFactory(new PropertyValueFactory<Player, Integer>("blocks"));
		}

	}

	@FXML
	public void loadMenu() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		fxmlLoader.setController(this);
		Parent pane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().addAll(pane);

		criteriaBox.getItems().addAll("Points", "Rebounds", "Assists", "Robberies", "Blocks");
		criteriaBox.setValue("Points");
		comparisonBox.getItems().addAll("=", ">", "<");
		comparisonBox.setValue("=");

	}

}