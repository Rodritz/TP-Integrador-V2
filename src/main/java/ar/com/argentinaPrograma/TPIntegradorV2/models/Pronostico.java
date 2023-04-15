package ar.com.argentinaPrograma.TPIntegradorV2.models;

import com.opencsv.bean.CsvBindByPosition;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Pronostico {
		
	@CsvBindByPosition(position = 0)
    private Integer partidoId;	
	
	@CsvBindByPosition(position = 1)
	private String participante;
	
	@CsvBindByPosition(position = 2)
	private String equipo1;
	
	@CsvBindByPosition(position = 3)
	private String gana1;
	
	@CsvBindByPosition(position = 4)
	private String empata;
	
	@CsvBindByPosition(position = 5)
	private String gana2;
	
	@CsvBindByPosition(position = 6)
	private String equipo2;
	
	private Partido partido;
	private Equipo equipo;
	//private EnumResultado resultado;
	
	
}
