import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
	
	static String codigoFuente = "";
	
	public static void abrirArchivo(String ruta) {
		BufferedReader lector;
		try {
			// Inicializar nuestro objeto encargado de leer nuestro archivo, asi como asignarle nuestro archivo a leer
			lector = new BufferedReader(new FileReader(ruta));
			// Leer primera linea
			String linea = lector.readLine();
			// Leer todas las linea mientras linea y agregarla a codigocodigoFuente mientras sea diferente de null
			while(linea != null) {
				// Agregar linea actual a nuestra variable codigocodigoFuente
				codigoFuente += linea;
				// Leer la siguiente linea
				linea = lector.readLine();
			}
		} catch (IOException e) {
			// En caso de que algo falle imprimir el error
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Leer archivo
		abrirArchivo("src/archivo.txt");
		// Limpiar espacios
		codigoFuente = codigoFuente.replaceAll("\\s", "");
		// Remover comentarios simples y multiples
		codigoFuente = codigoFuente.replaceAll("([\\/][\\/][a-zA-z0-9,\"]*[\\/][\\/])|([\\/][*][a-zA-z0-9,\"]*[*])", "");		//Imprimir codigo codigoFuente
		System.out.println(codigoFuente);
		// Instanciar clase lexico
		Lexico lexico = new Lexico();
		// Analizar codigo codigoFuente
		lexico.analizar(codigoFuente);
		// Imprimir lexemas
		System.out.println(lexico.lexemas);
	}
}
