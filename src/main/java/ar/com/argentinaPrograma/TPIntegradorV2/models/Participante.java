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
	private int aciertos;
	private int puntajeRonda1;
	private int puntajeRonda2;
	private int puntajeFase1;
	
	public Participante(String nombre, int puntajeTotal, int aciertos) {
		super();
		this.nombre = nombre;
		this.puntajeTotal = puntajeTotal;
		this.aciertos = aciertos;
	}
	
	
	
	
	
	
	
	
	
	
}
