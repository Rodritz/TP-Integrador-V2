package ar.com.argentinaPrograma.TPIntegradorV2.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Partido {
	
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	
	
	
	public Partido(Equipo equipo1, Equipo equipo2) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}
	public EnumResultado resultadoReal(Equipo equipo) {
		if(this.golesEquipo1> this.golesEquipo2)
			return EnumResultado.GANADOR;
		
		if(this.golesEquipo1< this.golesEquipo2)
			return EnumResultado.PERDEDOR;
		
		return EnumResultado.EMPATE;
		
		
		
	}
	
}
	

