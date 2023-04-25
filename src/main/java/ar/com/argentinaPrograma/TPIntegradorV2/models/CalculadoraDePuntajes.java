package ar.com.argentinaPrograma.TPIntegradorV2.models;

import java.util.List;
import java.util.Map;

public class CalculadoraDePuntajes {

	public void calculadoraDePuntajes (List<Resultado> listaResultados, List<Pronostico> listaPronosticos, Map<String, Integer> puntajeTotal,
			Map<String, Integer> aciertos,Map<String, Integer> puntajeRonda1,Map<String, Integer> puntajeRonda2, Map<String,Integer>puntajeFase1, Participante jugador1, Participante jugador2) {


		for(Pronostico pronostico : listaPronosticos) {
			for(Resultado resultado : listaResultados) {
				String participante= pronostico.getParticipante();   	
				Equipo equipo = null;
				

				//busco el mismo partido en ambos archivos		        		
				if(resultado.getPartidoId().equals(pronostico.getResultadoId())) {
					//chequeo el participante haya acertado el pronostico 
					if(resultado.resultadoReal(equipo).equals(pronostico.resultadoPronosticado())) {
						//suma un punto si acerto al valor del hashMap
						puntajeTotal.put(participante, puntajeTotal.get(participante)+1);
						aciertos.put(participante, aciertos.get(participante)+1);	
					}
				}
				//busco los aciertos de la primer ronda
				if(resultado.getRonda()==1) {
					if(resultado.getPartidoId().equals(pronostico.getResultadoId())) {
						//chequeo el participante haya acertado el pronostico 
						if(resultado.resultadoReal(equipo).equals(pronostico.resultadoPronosticado())) {
							puntajeRonda1.put(participante, puntajeRonda1.get(participante)+1);
						}
					}
				}
				//busco los aciertos de la segunda ronda
				if(resultado.getRonda()==2) {
					if(resultado.getPartidoId().equals(pronostico.getResultadoId())) {
						//chequeo el participante haya acertado el pronostico 
						if(resultado.resultadoReal(equipo).equals(pronostico.resultadoPronosticado())) {
							puntajeRonda2.put(participante, puntajeRonda2.get(participante)+1);
						}
					}
				}
				
			}	
		}
		
		//recorro los aciertos de la primer ronda para ver si suma puntos extras
		for (String participante : puntajeRonda1.keySet()) {
			Integer valor = puntajeRonda1.get(participante);{

				if (valor == 4) {
					puntajeTotal.put(participante, puntajeTotal.get(participante)+5);
					puntajeFase1.put(participante, puntajeFase1.get(participante)+1);
					System.out.println(participante + " sumo 5 puntos extras por acertar todos los pronosticos de la primer ronda \n");
					
				}     

			}
		}
		
		//recorro los aciertos de la segunda ronda para ver si suma puntos extras
		for (String participante : puntajeRonda2.keySet()) {
			Integer valor = puntajeRonda2.get(participante);{

				if (valor == 4) {
					puntajeTotal.put(participante, puntajeTotal.get(participante)+5);
					puntajeFase1.put(participante, puntajeFase1.get(participante)+1);
					System.out.println(participante + " sumo 5 puntos extras por acertar todos los pronosticos de la segunda ronda \n");
					
				} 
			}
		}
		
		//recorro la fase para ver cuantas rondas acerto y si suma puntos extras
		for (String participante : puntajeFase1.keySet()) {
			Integer valor = puntajeFase1.get(participante);{

				if (valor == 2) {
					puntajeTotal.put(participante, puntajeTotal.get(participante)+10);
					
					System.out.println(participante + " sumo 10 puntos extras por acertar todos los pronosticos de la fase  \n");

				} 
			}
		}
	}
}
