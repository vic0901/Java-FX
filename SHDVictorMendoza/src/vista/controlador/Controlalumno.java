package vista.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import entidades.Alumno;
import entidades.Carrera;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controlalumno  implements Initializable {
	@FXML TextField nombre,apaterno,amaterno,fecha,sexo;
	@FXML ComboBox<String>carrera;
	@FXML Label mensaje;
	@FXML private TableView<Alumno>datos;
	
	@FXML protected void Guardar(ActionEvent EVENTO){
		try {
			if(nombre.getText().trim().isEmpty()|apaterno.getText().trim().isEmpty()|
					amaterno.getText().trim().isEmpty()|fecha.getText().trim().isEmpty()|sexo.getText().trim().isEmpty()|carrera.getPromptText().trim().isEmpty()){
				mensaje.setText("Faltan datos por ingresar");	
			}else{
				Alumno p = new Alumno(nombre.getText(),
						apaterno.getText(),
						amaterno.getText(),
						fecha.getText(),
						sexo.getText(),
						carrera.getPromptText());
				llenar();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML protected void Borrar(ActionEvent EVENTO){
		try {
			if(nombre.getText().trim().isEmpty()){
				mensaje.setText("Faltan datos por ingresar");
			}else{
				Carrera c = new Carrera();
				c.setNombre(nombre.getText());
				mensaje.setText(c.Borrar());
				llenar();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML protected void Modificar(ActionEvent EVENTO){
		System.out.println("hace algo");
		try {
			if(nombre.getText().trim().isEmpty()|apaterno.getText().trim().isEmpty()|
					amaterno.getText().trim().isEmpty()|fecha.getText().trim().isEmpty()||sexo.getText().trim().isEmpty()|carrera.getPromptText().trim().isEmpty()){
				mensaje.setText("Faltan datos por ingresar");	
			}else{
				Alumno p = new Alumno(nombre.getText(),
						apaterno.getText(),
						amaterno.getText(),
						fecha.getText(),
						sexo.getText(),
						carrera.getPromptText());
				
				mensaje.setText(p.Modificar());
				llenar();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML protected void salir(ActionEvent s){
		System.exit(0);
	}
	
	public void llenar(){
		Alumno c = new Alumno();
			try {
				datos.setItems(c.getDatos());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		llenar();
		
		datos.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent event){
				Alumno c=datos.getSelectionModel().getSelectedItem();
				nombre.setText(c.getNombre());
				apaterno.setText(c.getApaterno());
				amaterno.setText(c.getAmaterno());
				fecha.setText(c.getFecha());
				sexo.setText(c.getSexo());
				carrera.setPromptText(c.getCarrera());
			}
		});
	}
	

	
}
