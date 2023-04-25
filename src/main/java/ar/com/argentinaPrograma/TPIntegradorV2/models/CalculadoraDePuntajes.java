package ar.com.argentinaPrograma.TPIntegradorV2.models;

import java.util.List;
import java.util.Map;

public class CalculadoraDePuntajes {

	public void calculadoraDePuntajes (List<Resultado> listaResultados, List<Pronostico> listaPronosticos, Map<String, Integer> puntajeTotal,
			Map<String, Integer> aciertos,Map<String, Integer> puntajeRonda1,Map<String, Integer> puntajeRonda2, Map<String,Integer>puntajeFase1,  Participante jugador1, Participante jugador2) {

		//recorro csv y db para ver los puntos obtenidos segun los pronosticos
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

		//mostramos los aciertos de la primer ronda y vemos si suma puntos
		for (String participante : puntajeRonda1.keySet()) {
			System.out.println(participante + " acerto " + puntajeRonda1.get(participante)+ " pronosticos en la primer ronda \n");

			Integer valorR1 = puntajeRonda1.get(participante);
			if (valorR1 == 4) {
				puntajeTotal.put(participante, puntajeTotal.get(participante)+5);
				puntajeFase1.put(participante, puntajeFase1.get(participante)+1);
				System.out.println(participante + " sumo 5 puntos extras por acertar todos los pronosticos de la primer ronda \n");
			} 
		}

		//mostramos los aciertos de la segunda ronda y vemos si suma puntos
		for (String participante : puntajeRonda2.keySet()) {
			System.out.println(participante + " acerto " + puntajeRonda2.get(participante)+ " pronosticos en la segunda ronda \n");

			Integer valorR2 = puntajeRonda2.get(participante);{
				if (valorR2 == 4) {
					puntajeTotal.put(participante, puntajeTotal.get(participante)+5);
					puntajeFase1.put(participante, puntajeFase1.get(participante)+1);
					System.out.println(participante + " sumo 5 puntos extras por acertar todos los pronosticos de la segunda ronda \n");
				}
			}
		}

		//recorro la fase para ver cuantas rondas acerto y si suma puntos extras
		for (String participante : puntajeFase1.keySet()) {
			Integer valorF1 = puntajeFase1.get(participante);{
				if (valorF1 == 2) {
					puntajeTotal.put(participante, puntajeTotal.get(participante)+10);
					System.out.println(participante + " sumo 10 puntos extras por acertar todos los pronosticos de la fase  \n");
				} 
			}
		}

		//mostramos los aciertos obtenidos por cada participante
		for (String participante : aciertos.keySet()) {
			System.out.println(participante + " logro un total de " + aciertos.get(participante)+ " aciertos \n");
		}

		//mostramos el puntaje total obtenido por cada participante	
		for (String participante : puntajeTotal.keySet()) {
			System.out.println("Hasta el momento "+ participante + " obtuvo un total de " + puntajeTotal.get(participante)+ " puntos \n");
		}
	}
}
