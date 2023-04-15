package ar.com.argentinaPrograma.TPIntegradorV2.models;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Persona {
	
	//atributos
	private int id;
	private String nombre;
	private int puntajeTotal;
	private int pronosticosAcertados;
	
	public Persona(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	
	
}
