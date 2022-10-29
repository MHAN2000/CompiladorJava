
public class Principal {

	public static void main(String[] args) {
		// Codigo fuente
		String fuente = "//Esto es un comentario del anio 2022 de 1 linea// if (((41e233 + 323.134442) << 10.54)) begin: mario = fact((4)) almaguer = pow((4,2)) end/* //Programa de lexico mostrando gran parte de la gramatica asignada// ";
		// Limpiar espacios
		fuente = fuente.replaceAll("\\s", "");
		// Remover comentarios
		fuente = fuente.replaceAll("[\\/][\\/][a-zA-z0-9]*[\\/][\\/]", "");
		//Imprimir codigo fuente
		System.out.println(fuente);
		// Instanciar clase lexico
		Lexico lexico = new Lexico();
		// Analizar codigo fuente
		lexico.analizar(fuente);
		// Imprimir lexemas
		System.out.println(lexico.lexemas);
	}
}
