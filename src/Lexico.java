import java.util.ArrayList;
import java.util.Arrays;

public class Lexico {
	int estado;
	ArrayList<Lexema> lexemas = new ArrayList<>();
	String valor = "";
	int indice = 0;

	String[][] matrizEstados = {
			{ "", "<", "\\=", "\\{", "]", "}", "\\+", ">", "\\)", ",", "|", "\\[", "/", "-", "\\*", "\\(", "&", "!",
					":", ";", "[a-z]", "[0-9]" },
			{ "0", "2", "27", "6", "8", "9", "11", "12", "16", "18", "19", "21", "22", "23", "24", "25", "30", "32",
					"35", "38", "1", "39" },
			{ "1", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000",
					"1000", "1000", "1000", "1000", "1000", "1000", "1000", "1", "1000" },
			{ "2", "3", "5", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500",
					"500", "500", "4", "500", "500", "500" },
			{ "3", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001",
					"1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001", "1001" },
			{ "4", "500", "5", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500",
					"500", "500", "500", "500", "500", "500", "500" },
			{ "5", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002",
					"1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002", "1002" },
			{ "6", "500", "500", "7", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500",
					"500", "500", "500", "500", "500", "500", "500" },
			{ "7", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003",
					"1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003", "1003" },
			{ "8", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004",
					"1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004", "1004" },
			{ "9", "500", "500", "500", "500", "10", "500", "500", "500", "500", "500", "500", "500", "500", "500",
					"500", "500", "500", "500", "500", "500", "500" },
			{ "10", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005",
					"1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005", "1005" },
			{ "11", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006",
					"1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006", "1006" },
			{ "12", "500", "500", "500", "500", "500", "500", "13", "500", "500", "500", "500", "500", "500", "500",
					"500", "500", "500", "14", "500", "500", "500" },
			{ "13", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007",
					"1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007", "1007" },
			{ "14", "500", "15", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500",
					"500", "500", "500", "500", "500", "500", "500" },
			{ "15", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008",
					"1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008", "1008" },
			{ "16", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "17", "1010", "1010", "1010", "1010",
					"1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010", "1010" },
			{ "17", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009",
					"1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009", "1009" },
			{ "18", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011",
					"1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011", "1011" },
			{ "19", "500", "500", "500", "500", "500", "500", "500", "500", "500", "20", "500", "500", "500", "500",
					"500", "500", "500", "500", "500", "500", "500" },
			{ "20", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012",
					"1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012", "1012" },
			{ "21", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013",
					"1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013", "1013" },
			{ "22", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014",
					"1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014", "1014" },
			{ "23", "1015", "1015", "1015", "1015", "1015", "1015", "1015", "1015", "1015", "1015", "1015", "1015",
					"1015", "1015", "1015", "1015", "1015", "1015", "1015", "1015", "1015" },
			{ "24", "1016", "1016", "1016", "1016", "1016", "1016", "1016", "1016", "1016", "1016", "1016", "1016",
					"1016", "1016", "1016", "1016", "1016", "1016", "1016", "1016", "1016" },
			{ "25", "1018", "1018", "1018", "1018", "1018", "1018", "1018", "1018", "1018", "1018", "1018", "1018",
					"1018", "1018", "26", "1018", "1018", "1018", "1018", "1018", "1018" },
			{ "26", "1017", "1017", "1017", "1017", "1017", "1017", "1017", "1017", "1017", "1017", "1017", "1017",
					"1017", "1017", "1017", "1017", "1017", "1017", "1017", "1017", "1017" },
			{ "27", "1019", "1019", "1019", "1019", "1019", "1019", "1019", "1019", "1019", "1019", "1019", "1019",
					"1019", "1019", "1019", "1019", "1019", "28", "1019", "1019", "1019" },
			{ "28", "500", "29", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500",
					"500", "500", "500", "500", "500", "500", "500" },
			{ "29", "1020", "1020", "1020", "1020", "1020", "1020", "1020", "1020", "1020", "1020", "1020", "1020",
					"1020", "1020", "1020", "1020", "1020", "1020", "1020", "1020", "1020" },
			{ "30", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500",
					"500", "31", "500", "500", "500", "500", "500" },
			{ "31", "1021", "1021", "1021", "1021", "1021", "1021", "1021", "1021", "1021", "1021", "1021", "1021",
					"1021", "1021", "1021", "1021", "1021", "1021", "1021", "1021", "1021" },
			{ "32", "1022", "33", "1022", "1022", "1022", "1022", "1022", "1022", "1022", "1022", "1022", "1022",
					"1022", "1022", "1022", "1022", "1022", "1022", "1022", "1022", "1022" },
			{ "33", "500", "34", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500",
					"500", "500", "500", "500", "500", "500", "500" },
			{ "34", "1023", "1023", "1023", "1023", "1023", "1023", "1023", "1023", "1023", "1023", "1023", "1023",
					"1023", "1023", "1023", "1023", "1023", "1023", "1023", "1023", "1023" },
			{ "35", "1026", "36", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026", "1026",
					"1026", "1026", "1026", "1026", "1026", "37", "1026", "1026", "1026" },
			{ "36", "1024", "1024", "1024", "1024", "1024", "1024", "1024", "1024", "1024", "1024", "1024", "1024",
					"1024", "1024", "1024", "1024", "1024", "1024", "1024", "1024", "1024" },
			{ "37", "1025", "1025", "1025", "1025", "1025", "1025", "1025", "1025", "1025", "1025", "1025", "1025",
					"1025", "1025", "1025", "1025", "1025", "1025", "1025", "1025", "1025" },
			{ "38", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027",
					"1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027", "1027" },
			{ "39", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028",
					"1028", "1028", "1028", "1028", "1028", "1028", "1028", "1028", "39" }, };
	String[] palabrasClave = { "function", "begin", "returning", "end", "number", "decimal", "string", "starting", "if",
			"elseif", "else", "while", "for", "into", "do", "printing", "inputing", "fact", "pow", "absolute",
			"minimal", "maximal", "range", "or", "and" };

	
	/**
	 * Metodo encargado de analizar el codigo fuente, y detectar los estados finales.
	 * @param codigoFuente
	 */
	void analizar(String codigoFuente) {
		// Leer codigo fuente caracter por caracter mientras el indice actual no sea igual a la longitud del codigo fuente, es decir aun no hallamos acabado de leer el codigo fuente
		while (indice != (codigoFuente.length())) {
			// Caracter actual del codigo fuente
			char actual = codigoFuente.charAt(indice);
			// Recorrer matriz de estados
			for (int x = 1; x < matrizEstados[0].length; x++) {
				if (String.valueOf(actual).matches(matrizEstados[0][x])) {
					// Preguntar si nos encontramos en un estado final, si si lo estamos, quiere decir que hemos detectado el fin de algo significativo, o sea un lexema
					if (estado >= 1000) {
						// Restar el indice de la lectura del codigo fuente a -2, para no perder simbolos por leer
						indice -= 2;
						// Detectar lexema, o sea algo significativo (numero, palabra clave, operador, signo, etc)
						detectarLexema(estado);
						// Como hemos llegado a un estado final, es requerido empezar desde el estado 0 de nuevo, para poder encontrar otro lexema
						estado = 0;
						// Reiniciar el string que nos almacena el valor de cada lexema, esto es el valor significativo(numero, palabra clave, operador, signo, etc)
						valor = "";
						// Como ya encontramos un lexema, no es necesario seguir probando con los demas simbolos restantes de la matriz
						break;
					}
					// De no ser un estado final seguir encontrado el proximo estado hasta encontrar algo significativo, o sea un lexema
					estado = Integer.parseInt(matrizEstados[estado + 1][x]);
					// Concatenar el caracter actual a lo que podria ser nuestro valor significativo
					valor += actual;
					// Al haber coincidido con un simbolo de la matriz, no es necesario seguir comparando el caracter actual con los demas simbolos, esto para mejorar el rendimiento
					break;
				}
			}
			// Movernos al caracter siguiente sumando 1 al indice actual
			indice++;
		}
	}

	/**
	 * Metodo encargado de agregar los lexemas sean palabras clave, numeros, operadores, etc.
	 * @param estado Estado a consultar
	 */
	void detectarLexema(int estado) {
		String palabra = valor.substring(0, valor.length() - 1);
		switch (estado) {
		// Si es una palabra comprobar que sea una palabra clave que exista en la lista, de lo contrario sera una variable/identificador
		case 1000:
			if (Arrays.asList(palabrasClave).contains(palabra)) {
				lexemas.add(new Lexema("Palabra reservada", palabra));
				break;
			}

			lexemas.add(new Lexema("Identificador", palabra));
			break;
		case 1006: case 1014:case 1015:case 1016:
			lexemas.add(new Lexema("Operador", palabra));
			break;
		case 1028:
			lexemas.add(new Lexema("Numero", palabra));
			break;

		default:
			lexemas.add(new Lexema("Signo", palabra));
			break;
		}
	}
}
