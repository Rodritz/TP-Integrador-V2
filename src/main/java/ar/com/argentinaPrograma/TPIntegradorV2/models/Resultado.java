package ar.com.argentinaPrograma.TPIntegradorV2.models;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Resultado {
	
	@CsvBindByPosition(position = 0)
    private Integer partidoId;		
	
    @CsvBindByPosition(position = 1)
    private String equipo1;
        
    @CsvBindByPosition(position = 2)
    private Integer golesEquipo1;
    
    @CsvBindByPosition(position = 3)   
    private Integer golesEquipo2;
    
    @CsvBindByPosition(position = 4)
    private String equipo2;
    
    
}
