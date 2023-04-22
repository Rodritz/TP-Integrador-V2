package ar.com.argentinaPrograma.TPIntegradorV2.models;

import ar.com.argentinaPrograma.TPIntegradorV2.models.EnumResultado;
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
	
	
}
	

