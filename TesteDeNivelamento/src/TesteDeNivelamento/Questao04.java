package TesteDeNivelamento;

public class Questao04 {
	
	public static void main(String[] args) {
		
		MatrizIdentidade(5);
	}
	
	public static int MatrizIdentidade(int tamanho) {
		
		int linhas, colunas;
		
		for (linhas = 0; linhas < tamanho; linhas++) {
			
			for(colunas = 0; colunas < tamanho; colunas++) {
				
				if(linhas == colunas) {
					
					System.out.print(1 + " ");
				} else {
					
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}	
		return 0;
	}
}
