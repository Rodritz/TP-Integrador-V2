package ar.com.argentinaPrograma.TPIntegradorV2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ar.com.argentinaPrograma.TPIntegradorV2.models.EnumResultado;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Equipo;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Partido;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Pronostico;

public class pronosticoTest {
	
	private Equipo equipo1;
	private Equipo equipo2;

	@Before
	public void setUp() {
		this.equipo1 = new Equipo(1, "Argentina","AFA" );
		this.equipo2 = new Equipo(2, "Arabia Saudita", "AFC");
		
	}
	/*
	@Test
	public void testControlarAciertos() {
		
		// Escenario
		Partido partido = new Partido(this.equipo1, 
				this.equipo2, 2, 3);
		Pronostico pronostico = new Pronostico(partido, this.equipo1, EnumResultado.PERDEDOR);
		
		// Procesar
		int puntos = pronostico.puntos();
		
		// Evaluar
		
		assertEquals(1, puntos);
		
		
	} 
	
	@Test
	public void testControlarDesaciertos() {
		
		// Escenario
		Partido partido = new Partido(this.equipo1, 
				this.equipo2, 2, 3);
		Pronostico pronostico = new Pronostico(partido, this.equipo1, EnumResultado.EMPATE);
		
		// Procesar
		int puntos = pronostico.puntos();
		
		// Evaluar
		
		assertEquals(0, puntos);
		
		
	} */
	
}