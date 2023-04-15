package ar.com.argentinaPrograma.TPIntegradorV2.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Pronostico {
	
	private Integer id;
    private Integer resultadoId;		
	private String participante;	
	private String equipo1;	
	private String gana1;	
	private String empata;	
	private String gana2;	
	private String equipo2;
	
	//private Partido partido;
	//private Equipo equipo;
	//private EnumResultado resultado;
	
	
}
