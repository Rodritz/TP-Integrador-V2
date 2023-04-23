package ar.com.argentinaPrograma.TPIntegradorV2.models;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Resultado {
	
	@CsvBindByPosition(position = 0)
    private Integer fase;	
	
	@CsvBindByPosition(position = 1)
    private Integer ronda;	
	
	@CsvBindByPosition(position = 2)
    private Integer partidoId;		
	
    @CsvBindByPosition(position = 3)
    private String equipo1;
        
    @CsvBindByPosition(position = 4)
    private Integer golesEquipo1;
    
    @CsvBindByPosition(position = 5)   
    private Integer golesEquipo2;
    
    @CsvBindByPosition(position = 6)
    private String equipo2;
    
   public EnumResultado resultadoReal(Equipo equipo) {
		if(this.golesEquipo1> this.golesEquipo2)
			return EnumResultado.GANADOR;
		
		if(this.golesEquipo1< this.golesEquipo2)
			return EnumResultado.PERDEDOR;
		
		return EnumResultado.EMPATE;
		
		
		
	}
}
