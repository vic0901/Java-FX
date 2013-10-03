package principal;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Entrar extends Application {
	
	@FXML private Button Carrera;
	
	public void start(Stage primaStage) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("../vista/fxml/Menu.fxml"));
		Scene escena = new Scene(root);
		primaStage.setTitle("Clase Carrera");
		primaStage.setScene(escena);
		primaStage.show();
	}
	
	@FXML protected void clikCarrera(ActionEvent e) throws IOException{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../vista/fxml/Carrera.fxml"));
		Scene escena = new Scene(root);
		primaryStage.setTitle("Clase Carrera");
		primaryStage.setScene(escena);
		primaryStage.initModality(Modality.WINDOW_MODAL);
		primaryStage.initOwner(((Node)e.getSource()).getScene().getWindow());
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML protected void clickAlumno(ActionEvent e) throws IOException{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../vista/fxml/alumno.fxml"));
		Scene escena = new Scene(root);
		primaryStage.setTitle("Clase Carrera");
		primaryStage.setScene(escena);
		primaryStage.initModality(Modality.WINDOW_MODAL);
		primaryStage.initOwner(((Node)e.getSource()).getScene().getWindow());
		primaryStage.show();
	}
	public static void main1(String[] args) {
		launch(args);
	}
	
	
	
}
