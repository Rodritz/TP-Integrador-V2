package ar.com.argentinaPrograma.TPIntegradorV2.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;




public class LectorCsv {
	
	//puede ser el metodo main
	public static void main(String[] args) {
		
	
	//public String rutaArchivo;
	
	//Leer resultado
	//public List <Resultado> listaResultados; //aca vamos a guardas los datos obtenidos al leer el csv
	Path pathResultados = Paths.get("src/main/resources/resultado.csv");
	List<String> lineasResultados = null;
	try {
		lineasResultados = Files.readAllLines(pathResultados);
	} catch (IOException e) {
		System.out.println("No se pudo leer la linea de resultados...");
		System.out.println(e.getMessage());
		System.exit(1);//con esto se termina el programa. solo se permite hacerlo en el main
	}
	
	
	//Leer pronostico
	//public List <Pronostico> listaPronosticos; //aca vamos a guardas los datos obtenidos al leer el csv
		
	//creamos un metodo constructor que recibe la ruta, me setea la ruta archivo y me lee el archivo
	/*public LectorCSV(String ruta) {
		this.rutaArchivo = ruta;
		//this.leerElArchivo();
	}*/

}
}
