
public class Principal {
	
	public static void main(String[] args) {
		//Codigo fuente
		String fuente = "if ((5 >> 10)) begin: mario = fact((4)) end/*";
		//String fuente = "if ((xc [";
		//Limpiar espacios
		fuente = fuente.replaceAll("\\s", "");
		System.out.println(fuente);
		System.out.println();
		//Instanciar clase lexico
		Lexico lexico = new Lexico();
		//Analizar codigo fuente
		lexico.analizar(fuente);
		//Imprimir lexemas
		System.out.println(lexico.lexemas);
	}
}
