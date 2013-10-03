package vista.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.sun.org.apache.bcel.internal.generic.LLOAD;
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

public class Control  implements Initializable {
	@FXML TextField nombre,siglas,jefe,matricula,modalidad;
	@FXML ComboBox<String>acreditado;
	@FXML Label mensaje;
	@FXML private TableView<Carrera>datos;
	
	@FXML protected void Guardar(ActionEvent EVENTO){
		try {
			if(nombre.getText().trim().isEmpty()|siglas.getText().trim().isEmpty()|
					jefe.getText().trim().isEmpty()|matricula.getText().trim().isEmpty()|modalidad.getText().trim().isEmpty()){
				mensaje.setText("Faltan datos por ingresar");	
			}else{
				Carrera p = new Carrera(nombre.getText(),
						siglas.getText(),
						jefe.getText(),
						acreditado.getValue(),
						modalidad.getText(),
						Integer.valueOf(matricula.getText()));
				mensaje.setText(p.Guardar());
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
			if(nombre.getText().trim().isEmpty()|siglas.getText().trim().isEmpty()|
					jefe.getText().trim().isEmpty()|matricula.getText().trim().isEmpty()|modalidad.getText().trim().isEmpty()){
				mensaje.setText("Faltan datos por ingresar");	
			}else{
				Carrera p = new Carrera(nombre.getText(),
						siglas.getText(),
						jefe.getText(),
						acreditado.getValue(),
						modalidad.getText(),
						Integer.valueOf(matricula.getText()));
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
		Carrera c = new Carrera();
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
				Carrera c=datos.getSelectionModel().getSelectedItem();
				nombre.setText(c.getNombre());
				siglas.setText(c.getSiglas());
				jefe.setText(c.getJefe());
				acreditado.setValue(c.getAcreditado());
				modalidad.setText(c.getModalidad());
				matricula.setText(Integer.toString(c.getMatricula()));
			}
		});
	}
	

	
}
