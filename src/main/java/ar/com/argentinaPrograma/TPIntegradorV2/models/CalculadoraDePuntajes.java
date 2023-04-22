package ar.com.argentinaPrograma.TPIntegradorV2.models;

import java.util.List;
import java.util.Map;

public class CalculadoraDePuntajes {
	
	public void calculadoraDePuntajes (List<Resultado> listaResultados, List<Pronostico> listaPronosticos, Map<String, Integer> puntajeTotal, Participante jugador1, Participante jugador2) {
		//asigno los puntos obtenidos dependiendo del acierto
		int victoria = 3;
		int empata = 1;
		
		for (Resultado resultado : listaResultados) {
			String ganador;
			String gana = "x";				
			String empateEq1Eq2= "x";
			
			
			if(resultado.getGolesEquipo1() > resultado.getGolesEquipo2()) {
				ganador = resultado.getEquipo1();					
				System.out.println("El ganador del partido nº "+resultado.getPartidoId()+" fue "+ ganador + "\n");

				for (Pronostico pronostico : listaPronosticos) {
					String participante= pronostico.getParticipante();
					
					if(pronostico.getParticipante().equals(jugador1.getNombre())) {
						Equipo equipo = null;
						if(resultado.getPartidoId().equals(pronostico.getResultadoId()) && resultado.resultadoReal(equipo).equals(pronostico.resultadoPronosticado())) {
							
							puntajeTotal.put(participante, puntajeTotal.get(participante)+victoria);
							
							//System.out.println(jugador1.getNombre()+" suma "+ victoria +" punto/s por acertar el pronostico del partido ");
							System.out.println(participante+" suma "+ victoria +" punto/s por acertar el pronostico del partido \n");
						}
					}else {
						Equipo equipo = null;
						if(resultado.getPartidoId().equals(pronostico.getResultadoId()) && resultado.resultadoReal(equipo).equals(pronostico.resultadoPronosticado())) {
							
							puntajeTotal.put(participante, puntajeTotal.get(participante)+victoria);
							
							//System.out.println(jugador2.getNombre()+" suma "+ victoria +" punto/s por acertar el pronostico del partido ");
							System.out.println(participante+" suma "+ victoria +" punto/s por acertar el pronostico del partido \n");
						}
					}
				}	

			} else if (resultado.getGolesEquipo1() < resultado.getGolesEquipo2()){
				ganador = resultado.getEquipo2();    					
				System.out.println("El ganador del partido nº "+resultado.getPartidoId()+" fue "+ ganador + "\n");

				for (Pronostico pronostico : listaPronosticos) {
					String participante= pronostico.getParticipante();
					
					if(pronostico.getParticipante().equals(jugador1.getNombre())) {
						//falla aca
						
						Equipo equipo = null;
						if(resultado.getPartidoId().equals(pronostico.getResultadoId()) && resultado.resultadoReal(equipo).equals(pronostico.resultadoPronosticado())) {
							
							puntajeTotal.put(participante, puntajeTotal.get(participante)+victoria);
							
							//System.out.println(jugador1.getNombre()+" suma "+ victoria +" punto/s por acertar el pronostico del partido ");
							System.out.println(participante+" suma "+ victoria +" punto/s por acertar el pronostico del partido \n");
							
						}
					}else {
						
						Equipo equipo = null;
						//falla aca
						if(resultado.getPartidoId().equals(pronostico.getResultadoId()) && resultado.resultadoReal(equipo).equals(pronostico.resultadoPronosticado())) {
							
							puntajeTotal.put(participante, puntajeTotal.get(participante)+victoria);
							
							System.out.println(participante+" suma "+ victoria +" punto/s por acertar el pronostico del partido \n");
							//System.out.println(jugador2.getNombre()+" suma "+ victoria +" punto/s por acertar el pronostico del partido ");
						}
					}
				}
				
			}else  {									
				System.out.println("El partido nº "+resultado.getPartidoId()+" entre "+resultado.getEquipo1()+" y "+resultado.getEquipo2()+" termino en empate \n");
					
				for (Pronostico pronostico : listaPronosticos) {
					
					String participante= pronostico.getParticipante();
					if(pronostico.getParticipante().equals(jugador1.getNombre())) {
						Equipo equipo = null;
						if(resultado.getPartidoId().equals(pronostico.getResultadoId()) && resultado.resultadoReal(equipo).equals(pronostico.resultadoPronosticado())) {
							
							puntajeTotal.put(participante, puntajeTotal.get(participante)+empata);
						
							
							System.out.println(participante+" suma "+ empata +" punto/s por acertar el pronostico del partido \n");
							//System.out.println(jugador1.getNombre()+" suma "+ empata +" punto/s por acertar el pronostico del partido ");
						}
					}else {
						
						Equipo equipo = null;
						if(resultado.getPartidoId().equals(pronostico.getResultadoId()) && resultado.resultadoReal(equipo).equals(pronostico.resultadoPronosticado())) {
							
							puntajeTotal.put(participante, puntajeTotal.get(participante)+empata);
							
							System.out.println(participante+" suma "+ empata +" punto/s por acertar el pronostico del partido \n");
							//System.out.println(jugador2.getNombre()+" suma "+ empata +" punto/s por acertar el pronostico del partido ");
						}
					}
					}
					
				}
			}
		
	}

}
