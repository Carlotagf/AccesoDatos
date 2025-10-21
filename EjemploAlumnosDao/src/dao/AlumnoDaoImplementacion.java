package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import entidad.AlumnoEntidad;

public class AlumnoDaoImplementacion implements AlumnoDao{
	
	private static AlumnoDaoImplementacion instancia;
	private DataSource dataSource;
	
	
	
	public AlumnoDaoImplementacion(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public AlumnoDaoImplementacion getInstancia(DataSource dataSource) {
		if (instancia == null)
			instancia = new
			AlumnoDaoImplementacion(dataSource);
		return instancia;
	}

	@Override
	public void crearAlumno(AlumnoEntidad alumno) {
		String sql = "insert into alumno (codAlumno, nombreAlumno, apellidosAlumno, fechaNacimiento, grupo)";
		
		try {
			Connection connection = dataSource.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, alumno.getCodAlumno());
			statement.setString(2, alumno.getNombreAlumno());
			statement.setString(3, alumno.getApellidosAlumno());
			statement.setDate(4, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
			statement.setString(5, String.valueOf(alumno.getGrupo()));
			
			statement.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public AlumnoEntidad obtenerAlumnoPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlumnoEntidad> obtenerTodosLosAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarAlumno(AlumnoEntidad alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAlumno(String id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
