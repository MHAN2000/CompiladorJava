
public class Principal {

	public static void main(String[] args) {
		// Codigo fuente
		String fuente = "if (((5 + 3) >> 10)) begin: mario = fact((4)) end/*";
		// Limpiar espacios
		fuente = fuente.replaceAll("\\s", "");
		System.out.println(fuente);
		// Instanciar clase lexico
		Lexico lexico = new Lexico();
		// Analizar codigo fuente
		lexico.analizar(fuente);
		// Imprimir lexemas
		System.out.println(lexico.lexemas);
	}
}
