package ar.com.argentinaPrograma.TPIntegradorV2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ar.com.argentinaPrograma.TPIntegradorV2.models.EnumResultado;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Equipo;
import ar.com.argentinaPrograma.TPIntegradorV2.models.Partido;


public class partidoTest {

	private Equipo equipo1;
	private Equipo equipo2;
	private Partido partido ;

	@Before
	public void setUp() {
		this.equipo1 = new Equipo(1, "Argentina","AFA" );
		this.equipo2 = new Equipo(2, "Arabia Saudita", "AFC");
		this.partido = new Partido(this.equipo1,this.equipo2,2,2);
	}
	
	

	@Test
	public void testPartidoGanado() {

		// tomo los datos del @Before pero modifico la cant de goles de cada equipo
		this.partido.setGolesEquipo1(3);
		this.partido.setGolesEquipo2(1);
		
		EnumResultado resultado1 = partido.resultadoReal(equipo1);

		assertEquals(EnumResultado.GANADOR, resultado1);
	}
	
		@Test
		public void testPartidoPerdido() {

			// tomo los datos del @Before pero modifico la cant de goles de cada equipo
			this.partido.setGolesEquipo1(2);
			this.partido.setGolesEquipo2(4);
	
			EnumResultado resultado2 = partido.resultadoReal(equipo1);

			// Evaluar
			assertEquals(EnumResultado.PERDEDOR, resultado2);
				
			
	}
	
	@Test
	public void testPartidoEmpatado() {

		//toma los datos del @Before
		
		EnumResultado resultadoObtenido = partido.resultadoReal(equipo1);

		// Evaluar
		assertEquals(EnumResultado.EMPATE, resultadoObtenido);

	}

	

}