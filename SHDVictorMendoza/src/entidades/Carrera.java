package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Carrera {
	
	private String nombre,siglas,jefe,acreditado,modalidad;
	private Integer matricula,id;
	private conexion con;
	
		public Carrera(){
			this.nombre = "";
			this.siglas=jefe=acreditado=modalidad="";
			this.matricula = 0;
			this.con = new conexion();
		}
		
		public Carrera(String _nombre,String _siglas,String _jefe,
				String _acreditado,String _modalidad,Integer _matricula){
			this.nombre= _nombre;
			this.siglas= _siglas;
			this.jefe= _jefe;
			this.modalidad= _modalidad;
			this.matricula= _matricula;
			this.acreditado= _acreditado;
			this.con = new conexion();
		}
		/*hola*/
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getSiglas() {
			return siglas;
		}

		public void setSiglas(String siglas) {
			this.siglas = siglas;
		}

		public String getJefe() {
			return jefe;
		}

		public void setJefe(String jefe) {
			this.jefe = jefe;
		}

		public String getAcreditado() {
			return acreditado;
		}

		public void setAcreditado(String acreditado) {
			this.acreditado = acreditado;
		}

		public String getModalidad() {
			return modalidad;
		}

		public void setModalidad(String modalidad) {
			this.modalidad = modalidad;
		}

		public Integer getMatricula() {
			return matricula;
		}

		public void setMatricula(Integer matricula) {
			this.matricula = matricula;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String toString(){
			return this.nombre+" "+
					this.jefe+" "+
					this.acreditado+" "+
					this.siglas+" "+
					this.matricula+ " "+
					this.modalidad;
		}
		
		public String Guardar(){
				String mensaje="";
				try {
						if(con.conectar()==true){
							String query="insert into carrera values(default,?,?,?,?,?,?)";
							PreparedStatement comando = con.getConexion().prepareStatement(query);
								comando.setString(1, this.nombre);
								comando.setString(2, this.siglas);
								comando.setString(3, this.jefe);
								comando.setInt(4, this.matricula);
								comando.setString(5, this.acreditado);								
								comando.setString(6, this.modalidad);
								comando.executeUpdate();
								mensaje="Datos ingresados correctamente";
						}
					
				} catch (Exception e) {
					mensaje="Datos no insertados";
				}finally{
					con.desconectar();	
				}
			return mensaje;	
		}
		
		public String Borrar(){
			String mensaje="";
				try {
						if (con.conectar()==true) {
							String query="delete from carrera where nombre=?";
							PreparedStatement comando = con.getConexion().prepareStatement(query);
							comando.setString(1, this.nombre);
							comando.executeUpdate();
							mensaje="Datos borrados con exito";					
						} 					
				} catch (Exception e) {
					mensaje="Error al borrar datos";
				}finally{
					con.desconectar();
				}
				return mensaje;
		}
		
		public String Modificar(){
			String mensaje="";
				try {
						if(con.conectar()==true){
							String query="update carrera set siglas=?,jefe=?,matricula=?,acreditado=?,modalidad=? where nombre='"+this.nombre+"'";
							PreparedStatement comando = con.getConexion().prepareStatement(query);
							comando.setString(1, this.siglas);
							comando.setString(2, this.jefe);
							comando.setInt(3, this.matricula);
							comando.setString(4, this.acreditado);
							comando.setString(5, this.modalidad);
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
		
		public ObservableList<Carrera> getDatos() throws SQLException{
			ResultSet rs = null;
			ObservableList<Carrera> tabla=FXCollections.observableArrayList();
			Carrera p=null;
				try {
						if(con.conectar()==true){
							String query="Select * from carrera";
							PreparedStatement comando = con.getConexion().prepareStatement(query);
							rs=comando.executeQuery();
								while(rs.next()){
									p= new Carrera();
										p.setNombre(rs.getString("nombre"));
										p.setSiglas(rs.getString("siglas"));
										p.setJefe(rs.getString("jefe"));
										p.setMatricula(rs.getInt("matricula"));
										p.setAcreditado(rs.getString("acreditado"));
										p.setModalidad(rs.getString("modalidad"));
										p.setId(rs.getInt("id"));
										tabla.add(p);
								}
						}
				} catch (Exception e) {
					e.printStackTrace();
				}	finally{
					rs.close();
					con.desconectar();
				}
				return tabla;
		}
		
		public static void main(String[] args) {
		
		}
		
}
