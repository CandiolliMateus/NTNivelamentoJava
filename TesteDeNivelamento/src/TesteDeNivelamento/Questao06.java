package TesteDeNivelamento;

import java.util.Scanner;

public class Questao06 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		String mensagem = new String();
		int opcoes = 0;
		String key = "";
		int chave = 0;
		
		System.out.println("1 - Criptografar");
		System.out.println("2 - Descriptografar");
		
		opcoes = entrada.nextInt();
		entrada.nextLine();
		
		switch (opcoes) {
		case 1:
			
			System.out.print("Informe uma mensagem para criptografar: ");
			mensagem = entrada.nextLine();

			System.out.print("Informe a chave de encriptação: ");
			key = entrada.nextLine();
			chave = Integer.parseInt(key);
			
			String mensagemCriptografada = Encriptacao(mensagem, chave);
			System.out.println("MENSAGEM CRIPTOGRAFADA: " + mensagemCriptografada);
			break;
			
		case 2:
			
			System.out.print("Informe uma mensagem criptografada: ");
			mensagem = entrada.nextLine();
			
			System.out.print("Informe a chave de decriptação: ");
			key = entrada.nextLine();
			chave = Integer.parseInt(key);
			
			String mensagemDecifrada = Decifracao(mensagem, chave);
			System.out.println(mensagemDecifrada);
			break;

		default:
			
			System.out.println("Opção incorreta.");
			break;
		}
		
		entrada.close();
		
		/**
		System.out.print("Informe a chave de encriptação: ");
		chave = entrada.nextInt();
		
		String mensagemCriptografada = Encriptacao(mensagem, chave);
		System.out.println(mensagemCriptografada);
		
		System.out.print("Informe uma mensagem criptografada: ");
		mensagem = entrada.nextLine();
		System.out.print("Informe a chave de decriptação: ");
		chave = entrada.nextInt();
		
		String mensagemDecifrada = Decifracao(mensagem, chave);
		System.out.println(mensagemDecifrada);
		**/
	}
	
	public static final String alpha = "abcdefghijklmnopqrstuvwxyz0123456789 ";
	
	public static String Encriptacao(String mensagem, int chave) {
		 
		mensagem = mensagem.toLowerCase();
		String textoCifrado = "";
		
		for (int i = 0; i < mensagem.length(); i++) {
			
			int posicao = alpha.indexOf(mensagem.charAt(i));
			int chaveValor = (chave + posicao) % 37;
			char trocarValor = alpha.charAt(chaveValor);
			textoCifrado += trocarValor;
		}
		
		return textoCifrado;
	}
	
	public static String Decifracao(String textoCifrado, int chave) {
		 
		textoCifrado = textoCifrado.toLowerCase();
		String mensagem = "";
		
		for (int i = 0; i < textoCifrado.length(); i++) {
			
			int posicao = alpha.indexOf(textoCifrado.charAt(i));
			int chaveValor = (posicao - chave) % 37;
			if(chaveValor < 0) {
				chaveValor = alpha.length() + chaveValor;
			}
			char trocarValor = alpha.charAt(chaveValor);
			mensagem += trocarValor;
		}
		
		return mensagem;
	}
}
