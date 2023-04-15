package ar.com.argentinaPrograma.TPIntegradorV2.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class ClasePronostico {
	
	private Partido partido;
	private Equipo equipo;
	private String resultado;
	
	public int puntos() {		
		String resultadoReal = partido.resultado(equipo);
		if(resultado.equals(resultadoReal)){
		return 1;
		}else {
			return 0;
		}
	}

}
