package ar.com.argentinaPrograma.TPIntegradorV2.models;

import java.util.List;
import java.util.Map;

public class CalculadoraDePuntajes {

	public void calculadoraDePuntajes (List<Resultado> listaResultados, List<Pronostico> listaPronosticos, Map<String, Integer> puntajeTotal, Participante jugador1, Participante jugador2) {
		int puntosRonda1 = 0;

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
					}
				}

				while(pronostico.getRonda()==1) {
					if(resultado.getPartidoId().equals(pronostico.getResultadoId())) {
						//chequeo el participante haya acertado el pronostico 
						if(resultado.resultadoReal(equipo).equals(pronostico.resultadoPronosticado())) {
							puntosRonda1++;
						}
					}

					System.out.println(puntosRonda1);



				}			

			}


		}

	}}
