package ar.com.argentinaPrograma.TPIntegradorV2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.argentinaPrograma.TPIntegradorV2.models.CalculadoraDePuntajes;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Equipo;
import ar.com.argentinaPrograma.TPIntegradorV2.models.LectorCsv;
import ar.com.argentinaPrograma.TPIntegradorV2.models.LectorDB;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Partido;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Participante;
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
		Equipo equipo5 = new Equipo(5, "Estados Unidos", "Concacaf");
		Equipo equipo6 = new Equipo(6, "Inglaterra", "UEFA");
		Equipo equipo7 = new Equipo(7, "Nigeria", "CAF");
		Equipo equipo8 = new Equipo(8, "Brasil", "	Conmebol");


		List<Partido> partidos = new ArrayList<Partido>();
		partidos.add(new Partido(equipo1,equipo2));
		partidos.add(new Partido(equipo3,equipo4));
		partidos.add(new Partido(equipo1,equipo4));
		partidos.add(new Partido(equipo2,equipo3));
		partidos.add(new Partido(equipo5,equipo6));
		partidos.add(new Partido(equipo7,equipo8));
		partidos.add(new Partido(equipo5,equipo8));
		partidos.add(new Partido(equipo6,equipo7));



		//instancio a los participantes con su puntaje inicial
		Participante jugador1 = new Participante("Mariana",0,0);
		Participante jugador2 = new Participante("Pedro",0,0);
		
	
		//Creo la coleccion para guardar los participantes y el puntaje que van acumulando
		Map<String,Integer>puntajeTotal = new HashMap<>();
		
		puntajeTotal.put(jugador1.getNombre(),jugador1.getPuntajeTotal());
		puntajeTotal.put(jugador2.getNombre(),jugador2.getPuntajeTotal());
		
		//Creo la coleccion para guardar los participantes y los aciertos que van acumulando
		Map<String,Integer>aciertos = new HashMap<>();
		
		aciertos.put(jugador1.getNombre(),jugador1.getAciertos());
		aciertos.put(jugador2.getNombre(),jugador2.getAciertos());
		
		//Creo la coleccion para guardar los pronosticos acertados en la primer ronda
		Map<String,Integer>puntajeRonda1 = new HashMap<>();
		puntajeRonda1.put(jugador1.getNombre(),jugador1.getPuntajeRonda1());
		puntajeRonda1.put(jugador2.getNombre(),jugador2.getPuntajeRonda1());


		//comienzo la lectura del csv
		LectorCsv lectorArchivosCsv = new LectorCsv();
		List <Resultado> listaResultados = lectorArchivosCsv.parsearCsvResultados(args[0]);

		//comienzo la lectura de la DB
		LectorDB lectorArchivosDB = new LectorDB();
		List<Pronostico> listaPronosticos = lectorArchivosDB.parsearDBPronosticos();

		
		//llamo al metodo calculadoraDePuntajes de la clase calculadora
		CalculadoraDePuntajes calculadora = new CalculadoraDePuntajes();
		calculadora.calculadoraDePuntajes(listaResultados, listaPronosticos, puntajeTotal, aciertos, puntajeRonda1, jugador1, jugador2);


		/*for(Pronostico pronostico : listaPronosticos) {
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
			}			

		}*/

		//mostramos el puntaje obtenido por cada participante	
		for (String participante : puntajeTotal.keySet()) {
			System.out.println("Hasta el momento "+ participante + " obtuvo un total de " + puntajeTotal.get(participante)+ " puntos \n");
		}	
		//mostramos los aciertos obtenidos por cada participante
		for (String participante : aciertos.keySet()) {
			System.out.println(participante + " lleva " + aciertos.get(participante)+ " aciertos \n");
		}
		
		for (String participante : puntajeRonda1.keySet()) {
			System.out.println("Hasta el momento "+ participante + " obtuvo un total de " + puntajeRonda1.get(participante)+ " puntos en la primer ronda \n");
		}	
		
	}
}




