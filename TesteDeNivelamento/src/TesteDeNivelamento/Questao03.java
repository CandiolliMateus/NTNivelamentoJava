package TesteDeNivelamento;

public class Questao03 {
	
	public static void main(String[] args) {
		
		String texto = "omiss�ssimo";
		String textoInvertido = "";
		
		for (int i = texto.length() - 1; i >= 0; i--) {

			textoInvertido += texto.charAt(i);
		}
		
		if(texto.toUpperCase().equals(textoInvertido.toUpperCase())) {
			System.out.println(texto + " � um PALINDROMO.");
		} else {
			System.out.println(texto + " N�O � um PALINDROMO.");
		}
	}
}
