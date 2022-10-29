
public class Lexema {

	private String token, valor;

	public Lexema(String token, String valor) {
		this.token = token;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "\nLexema(  token: " + token + ", valor: " + valor + "  )";
	}

}
