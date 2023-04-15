package ar.com.argentinaPrograma.TPIntegradorV2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.com.argentinaPrograma.TPIntegradorV2.models.Equipo;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Partido;




public class MainTest {
	
	@Test
	public void validarQueLaCantidadDePartidosSeaLaCorrecta() {
	
	Equipo equipo1 = new Equipo(1, "Argentina","AFA" );
	Equipo equipo2 = new Equipo(2, "Arabia Saudita", "AFC");
	Equipo equipo3 = new Equipo(3, "Polonia","UEFA" );
	Equipo equipo4 = new Equipo(4, "Mexico", "Concacaf");
		
	Partido partido1 = new Partido(equipo1,equipo2);
	Partido partido2 = new Partido(equipo3,equipo4);
	Partido partido3 = new Partido(equipo1,equipo4);
	Partido partido4 = new Partido(equipo2,equipo3);
	
	List<Partido> partidos = new ArrayList<>();
	
	partidos.add(partido1);
    partidos.add(partido2);
    partidos.add(partido3);
    partidos.add(partido4);
    
    int cantidadEsperada = 4;
    int cantidadObtenida = partidos.size();
    
    //cualquiera de las 2 es valida,
    assertTrue(partidos.size() == 4);//para este test no se necesitan las variables
    assertEquals(cantidadEsperada, cantidadObtenida);//para este test se necesitan las variabes  
}
	
	@Test
	public void calcularElPuntajeDeUnaPersonaAlFinalizarUnaRonda() {
		int puntajePartido1 = 0;
		int puntajePartido2 = 0;
		boolean ganaEquipoApostado1 = true;
		boolean ganaEquipoApostado2 = true;
		
		if(ganaEquipoApostado1 = true) {
			puntajePartido1++;
			
		}
		if(ganaEquipoApostado2 = true) {
			puntajePartido1++;
		}
		
		int resultadoEsperado = 2;
		assertEquals(resultadoEsperado, (puntajePartido1 + puntajePartido2));
	}
}
	
	
	


