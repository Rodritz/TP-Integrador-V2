package ar.com.argentinaPrograma.TPIntegradorV2.models;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
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
	
	public String resultado(Equipo equipo) {
		if(equipo.equals(equipo1)) {
			if(golesEquipo1>golesEquipo2) {
				return "ganador";
			}else if(golesEquipo1<golesEquipo2) {
				return "perdedor";
			}else if(golesEquipo1==golesEquipo2) {
				return "partido empatado";
			}
		/*}else if(equipo.equals(equipo2)) {
			if(golesEquipo1>golesEquipo2) {
				return "perdedor";
			}else if(golesEquipo1<golesEquipo2) {
				return "ganador";
			}else if(golesEquipo1==golesEquipo2) {
				return "partido empatado";
			}*/
		}
		return "el partido llego a su fin";
	
	}
}
	

