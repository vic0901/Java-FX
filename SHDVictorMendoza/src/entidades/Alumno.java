package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Alumno {
	
	private String nombre,apaterno,amaterno,fecha,sexo,carrera;
	private conexion con;
	
		public Alumno(){
			this.nombre = "";
			this.apaterno=amaterno=fecha=sexo=carrera="";
			this.con = new conexion();
		}
		
		public Alumno(String _nombre,String _apaterno,String _amaterno,
				String _fecha,String _sexo,String _carrera){
			this.nombre= _nombre;
			this.apaterno= _apaterno;
			this.amaterno= _amaterno;
			this.fecha= _fecha;
			this.sexo= _sexo;
			this.carrera= _carrera;
			this.con = new conexion();
		}
		public String getNombre() {
			return nombre;
		}
		
		public String getApaterno(){
			return apaterno;
		}
		
		public String getAmaterno(){
			return amaterno;
		}
		
		public String getFecha(){
			return fecha;
		}
		
		public String getSexo(){
			return sexo;
		}
		
		public String getCarrera(){
			return carrera;
		}
		public void setnombre(String nombre) {
			this.nombre = nombre;
		}
		
		public void setapaterno(String apaterno){
			this.apaterno = apaterno;
		}
		
		public void setamaterno(String amaterno){
			this.amaterno= amaterno;
		}
		
		
		public void setfecha(String fecha){
			this.fecha=fecha;
		}
		
		public void setsexo(String sexo){
			this.sexo=sexo;
		}
		
		public void setcarrera(String carrera){
			this.carrera=carrera;
		}
		
		
		public String toString(){
			return this.nombre+" "+
					this.apaterno+" "+
					this.amaterno+" "+
					this.fecha+" "+
					this.sexo+ " "+
					this.carrera;
		}
		
		public String Guardar(){
			String mensaje="";
			try {
					if(con.conectar()==true){
						String query="insert into carrera values(default,?,?,?,?,?,?)";
						PreparedStatement comando = con.getConexion().prepareStatement(query);
							comando.setString(1, this.nombre);
							comando.setString(2, this.apaterno);
							comando.setString(3, this.amaterno);
							comando.setString(4, this.fecha);
							comando.setString(5, this.sexo);								
							comando.setString(6, this.carrera);
							comando.executeUpdate();
							mensaje="Datos ingresados correctamente";
					}
			} catch (Exception e) {
				mensaje="Los Datos no fueron insertados";
			}finally{
				con.desconectar();	
			}
		return mensaje;	
	}
	
		
		
		
		
		public String Borrar(){
			String mensaje="";
				try {
						if (con.conectar()==true) {
							String query="delete from alumno where nombre=?";
							PreparedStatement comando = con.getConexion().prepareStatement(query);
							comando.setString(1, this.nombre);
							comando.executeUpdate();
							mensaje="Datos eliminados con exito";					
						} 					
				} catch (Exception e) {
					mensaje="Error al eliminar datos";
				}finally{
					con.desconectar();
				}
				return mensaje;
		}
		
		public String Modificar(){
			String mensaje="";
				try {
						if(con.conectar()==true){
							String query="update alumno set apaterno=?,amaterno=?,fecha=?,sexo=?,carrera=? where nombre='"+this.nombre+"'";
							PreparedStatement comando = con.getConexion().prepareStatement(query);
							comando.setString(1, this.apaterno);
							comando.setString(2, this.amaterno);
							comando.setString(3, this.fecha);
							comando.setString(4, this.sexo);
							comando.setString(5, this.carrera);
							comando.executeUpdate();
							mensaje="Datos actualizados";
						}
				} catch (Exception e) {
					mensaje="Error al modificar los datos";
				}finally{
					con.desconectar();
				}
				return mensaje;
		}

		public ObservableList<Alumno> getDatos() {
			// TODO Auto-generated method stub
			return null;
		}
}