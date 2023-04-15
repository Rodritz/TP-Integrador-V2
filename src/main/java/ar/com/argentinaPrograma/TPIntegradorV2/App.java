package ar.com.argentinaPrograma.TPIntegradorV2;

import java.sql.*;

import static conexionSQL.ConectorSQL.DB_URL;
import static conexionSQL.ConectorSQL.PASS;
import static conexionSQL.ConectorSQL.USER;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import ar.com.argentinaPrograma.TPIntegradorV2.models.Equipo;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Partido;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Persona;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Pronostico;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Resultado;



public class App {
	
	public static void main(String[] args) {
		//En la variable args va a viajar la ruta del archivo que queremos que abra el programa
		if(args.length == 0){
			System.out.println("ERROR: No ingresaste ningun archivo como argumento!");
			System.exit(88);
		}
		
		//instancio equipos y creo los partidos
		Equipo equipo1 = new Equipo(1, "Argentina","AFA" );
		Equipo equipo2 = new Equipo(2, "Arabia Saudita", "AFC");
		Equipo equipo3 = new Equipo(3, "Polonia","UEFA" );
		Equipo equipo4 = new Equipo(4, "Mexico", "Concacaf");
		
		List<Partido> partidos = new ArrayList<Partido>();
		Partido partido1 = new Partido(equipo1,equipo2);
		Partido partido2 = new Partido(equipo3,equipo4);
		Partido partido3 = new Partido(equipo1,equipo4);
		Partido partido4 = new Partido(equipo2,equipo3);
		partidos.add(partido1);
		partidos.add(partido2);
		partidos.add(partido3);
		partidos.add(partido4);
		
		//System.out.println(partidos);
		
		//instancio a los apostadores
		Persona jugador1 = new Persona(1, "Mariana");
		Persona jugador2 = new Persona(2, "Pedro");
		
		
		
		//comienzo la lectura de los csv
		
		Connection conexion = null;
		Statement consulta = null;
		
		List <Resultado> listaResultados;
		//List <Pronostico> listaPronosticos;
				
		int puntajeTotal1 = 0;
		int puntajeTotal2 = 0;
		int aciertos1 = 0;
		int aciertos2 = 0;
				
				try {
					//lectura del primer Csv
					listaResultados = new CsvToBeanBuilder(new FileReader(args[0]))                      
							.withType(Resultado.class)
							.build()
							.parse();

					// conexion y lectura de la DB 
		            System.out.println("conectando a la base de datos...");

		            conexion = DriverManager.getConnection(DB_URL, USER, PASS);

		            // Ejecutar una consulta
		            System.out.println("Creating statement...");
		            consulta = conexion.createStatement();
		            String sql;
		            sql = "SELECT id, resultado_id, participante, equipo1, gana1, empata, gana2, equipo2 FROM tpintegrador.pronostico ";

		            //En la variable listaPronosticos obtendremos las distintas filas que nos devolvió la base
		            ResultSet listaPronosticos = consulta.executeQuery(sql);
		            
		            // Obtener las distintas filas de la consulta
		            while (listaPronosticos.next()) {
		                // Obtener el valor de cada columna
		                int id = listaPronosticos.getInt("id");
		                int resultado_id = listaPronosticos.getInt("resultado_id");
		                String participante = listaPronosticos.getString("participante");
		                String equipo1DB = listaPronosticos.getString("equipo1");
		                String gana1 = listaPronosticos.getString("gana1");
		                String empata = listaPronosticos.getString("empata");
		                String gana2 = listaPronosticos.getString("gana2");
		                String equipo2DB = listaPronosticos.getString("equipo2");

		                // Mostrar los valores obtenidos de algunos campos
		                System.out.print("ID: " + id);
		                System.out.print(", participante: " + participante);
		                System.out.print(", equipo1: " + equipo1DB);
		                System.out.println(", equipo2: " + equipo2DB);		                
		                
		            }
		            
					for (Resultado resultado : listaResultados) {
						String ganador;
						String gana = "x";				
						String empateEq1Eq2= "x";
						
						
						
						if(resultado.getGolesEquipo1() > resultado.getGolesEquipo2()) {
							ganador = resultado.getEquipo1();					
							System.out.println("El ganador del partido nº "+resultado.getPartidoId()+" fue "+ ganador);

							for (Pronostico pronostico : listaPronosticos) {
								if(pronostico.getParticipante().equals(jugador1.getNombre())) {
									if(resultado.getPartidoId().equals(pronostico.getPartidoId()) && pronostico.getGana1().equals(gana)) {
										puntajeTotal1++;
										aciertos1++;
										System.out.println(jugador1.getNombre()+" suma 1 punto por acertar el pronostico del partido ");
									}
								}else {
									if(resultado.getPartidoId().equals(pronostico.getPartidoId()) && pronostico.getGana1().equals(gana)) {
										puntajeTotal2++;	
										aciertos2++;
										System.out.println(jugador2.getNombre()+" suma 1 punto por acertar el pronostico del partido ");
									}
								}
							}	

						} else if (resultado.getGolesEquipo1() < resultado.getGolesEquipo2()){
							ganador = resultado.getEquipo2();    					
							System.out.println("El ganador del partido nº "+resultado.getPartidoId()+" fue "+ ganador);

							for (Pronostico pronostico : listaPronosticos) {
								if(pronostico.getParticipante().equals(jugador1.getNombre())) {
									if(resultado.getPartidoId().equals(pronostico.getPartidoId()) && pronostico.getGana2().equals(gana)) {
										puntajeTotal1++;
										aciertos1++;
										System.out.println(jugador1.getNombre()+" suma 1 punto por acertar el pronostico del partido ");
									}
								}else {
									if(resultado.getPartidoId().equals(pronostico.getPartidoId()) && pronostico.getGana2().equals(gana)) {
										puntajeTotal2++;
										aciertos2++;
										System.out.println(jugador2.getNombre()+" suma 1 punto por acertar el pronostico del partido ");
									}
								}
							}
							
						}else  {									
							System.out.println("El partido nº "+resultado.getPartidoId()+" entre "+resultado.getEquipo1()+" y "+resultado.getEquipo2()+" termino en empate");
								
							for (Pronostico pronostico : listaPronosticos) {
								if(pronostico.getParticipante().equals(jugador1.getNombre())) {
									if(resultado.getPartidoId().equals(pronostico.getPartidoId()) && pronostico.getEmpata().equals(empateEq1Eq2)) {
										puntajeTotal1++;
										aciertos1++;
										System.out.println(jugador1.getNombre()+" suma 1 punto por acertar el pronostico del partido ");
									}
								}else {
									
									if(resultado.getPartidoId().equals(pronostico.getPartidoId()) && pronostico.getEmpata().equals(empateEq1Eq2)) {
										puntajeTotal2++;
										aciertos2++;
										System.out.println(jugador2.getNombre()+" suma 1 punto por acertar el pronostico del partido ");
									}
								}
								}
								
							}
						}
				
				// Execpción ante problemas de lectura del csv
				} catch (IOException e) {
					e.printStackTrace();					
				} catch (SQLException se) {
		                // Execpción ante problemas de conexión 
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
				
				//asignamos los puntajes obtenidos a los apostadores
				jugador1.setPuntajeTotal(puntajeTotal1);
				jugador1.setPronosticosAcertados(aciertos1);
				
				jugador2.setPuntajeTotal(puntajeTotal2);
				jugador2.setPronosticosAcertados(aciertos2);
				
				System.out.println("el puntaje total de "+ jugador1.getNombre() + " por haber acertado "+jugador1.getPronosticosAcertados()+" pronosticos es: "+ jugador1.getPuntajeTotal());
				System.out.println("el puntaje total de "+ jugador2.getNombre() + " por haber acertado "+jugador2.getPronosticosAcertados()+" pronosticos es: "+ jugador2.getPuntajeTotal());
				
			}
			
		}



