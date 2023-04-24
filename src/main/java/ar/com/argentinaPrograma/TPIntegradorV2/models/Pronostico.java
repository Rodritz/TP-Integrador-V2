package ar.com.argentinaPrograma.TPIntegradorV2.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Pronostico {
	
	private Integer id;
	private Integer fase;
	private Integer ronda;
    private Integer resultadoId;		
	private String participante;	
	private String equipo1;	
	private String gana1;	
	private String empata;	
	private String gana2;	
	private String equipo2;
	
	
	public EnumResultado resultadoPronosticado() {
		
		if(this.gana1.equals("x"))
			return EnumResultado.GANADOR;
		
		if(this.gana2.equals("x"))
			return EnumResultado.PERDEDOR;
		
		return EnumResultado.EMPATE;
	}


	
	
	
}
