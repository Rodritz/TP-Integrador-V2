package ar.com.argentinaPrograma.TPIntegradorV2.models;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Participante {
	
	//atributos
	private int id;
	private String nombre;
	private int puntajeTotal;
	
	
	public Participante(String nombre, int puntajeTotal) {
		super();
		this.nombre = nombre;
		this.puntajeTotal = puntajeTotal;
	}
	
	
	
	
	
}
