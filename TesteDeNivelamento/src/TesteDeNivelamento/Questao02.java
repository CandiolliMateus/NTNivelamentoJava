package TesteDeNivelamento;

public class Questao02 {
	
	public static void main(String[] args) {
		
		int divisores = 0;
		for (int numero = 1; numero <= 1000; numero++) {
	
			for(int divisor = 1; divisor <= numero; divisor++) {
				
				if(numero % divisor == 0) {
					
					divisores++;
				}
			}
			
			if(divisores > 2) {
				
				System.out.println(numero + " N�O � primo.");
			} else {
				
				System.out.println(numero + " � primo.");
			}
			divisores = 0;
		}
	}
}
