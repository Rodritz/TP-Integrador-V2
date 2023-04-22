package ar.com.argentinaPrograma.TPIntegradorV2.models;

import static conexionSQL.ConectorSQL.DB_URL;
import static conexionSQL.ConectorSQL.PASS;
import static conexionSQL.ConectorSQL.USER;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LectorDB {
	
	public List<Pronostico> parsearDBPronosticos() {
		
		List<Pronostico> listaPronosticos = new ArrayList<>();
        
        Connection conexion = null;
		Statement consulta = null;
        
        
		try {
        System.out.println("conectando a la base de datos...");

        conexion = DriverManager.getConnection(DB_URL, USER, PASS);

        // Ejecutar una consulta
        System.out.println("Creating statement...\n");
        consulta = conexion.createStatement();
        String sql;
        sql = "SELECT id, resultado_id, participante, equipo1, gana1, empata, gana2, equipo2 FROM tpintegrador.pronostico ";

        //En la variable resultadoss obtendremos las distintas filas que nos devolvió la base
        ResultSet resultados = consulta.executeQuery(sql);        
               
        // recorremos cada linea de resultados
        while (resultados.next()) {
        	
            // Obtenemos el valor de cada columna y lo asignamos mediante setters a un objeto
        	Pronostico pronostico = new Pronostico();
            pronostico.setId(resultados.getInt("id"));		                
            pronostico.setResultadoId(resultados.getInt("resultado_id"));
            pronostico.setParticipante(resultados.getString("participante"));
            pronostico.setEquipo1(resultados.getString("equipo1"));
            pronostico.setGana1(resultados.getString("gana1"));
            pronostico.setEmpata(resultados.getString("empata"));
            pronostico.setGana2(resultados.getString("gana2"));
            pronostico.setEquipo2(resultados.getString("equipo2"));
            
            //agregamos los objetos a la listaPronosticos
            listaPronosticos.add(pronostico);

        }
        resultados.close();
        consulta.close();
        conexion.close();

	} catch (SQLException se) {
        // Excepción ante problemas de conexión 
        se.printStackTrace();		               
    } finally {
        // Esta sentencia es para que ante un problema con la base igual se cierren las conexiones
        try {
            if (consulta != null)
                consulta.close();
        } catch (SQLException se2) {
        }
        try {
            if (conexion != null)
                conexion.close();
        } catch (SQLException se) {
            se.printStackTrace();	
	
        }
        
    }
		return listaPronosticos;
        
	}

}


