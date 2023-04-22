package ar.com.argentinaPrograma.TPIntegradorV2.models;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;


public class LectorCsv {
	
	public List<Resultado> parsearCsvResultados(String rutaArchivo) {
        List<Resultado> listaResultados = null;
        try {
            // En esta primera línea definimos el archivos que va a ingresar
        	listaResultados = new CsvToBeanBuilder(new FileReader(rutaArchivo))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1) 
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(',')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(Resultado.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        e.printStackTrace();
    }
        return listaResultados;
    }

}
