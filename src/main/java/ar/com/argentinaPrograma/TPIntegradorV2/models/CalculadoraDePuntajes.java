package ar.com.argentinaPrograma.TPIntegradorV2.models;

import java.util.List;
import java.util.Map;

public class CalculadoraDePuntajes {

	public void calculadoraDePuntajes (List<Resultado> listaResultados, List<Pronostico> listaPronosticos, Map<String, Integer> puntajeTotal,
										Map<String, Integer> aciertos,Map<String, Integer> puntajeRonda1, Participante jugador1, Participante jugador2) {
		

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
				
				if(resultado.getRonda().equals(pronostico.getRonda())) {
					if(resultado.getPartidoId().equals(pronostico.getResultadoId())) {
						//chequeo el participante haya acertado el pronostico 
						if(resultado.resultadoReal(equipo).equals(pronostico.resultadoPronosticado())) {
							puntajeRonda1.put(participante, puntajeRonda1.get(participante)+1);
							
						}
					}
				}
			}	
		}
	}
}
