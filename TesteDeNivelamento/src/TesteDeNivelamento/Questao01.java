package TesteDeNivelamento;

public class Questao01 {
	
	public static void main(String[] args) {
		
		System.out.println(Fatorial(10));
	}
	
	public static int Fatorial(int numero) {
		
		int fatoracao = 1;
		for (int i = numero; i > 0; i--) {
			
			fatoracao = fatoracao * (numero);
			numero--;
		}
		return fatoracao;
	}
}
