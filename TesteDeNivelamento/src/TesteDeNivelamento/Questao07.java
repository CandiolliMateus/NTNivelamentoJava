package TesteDeNivelamento;

import java.util.Scanner;

public class Questao07 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int opcoes = 0;
		
		String mensagem = new String();
		String chave = "";
		
		System.out.println("1 - Criptografar");
		System.out.println("2 - Descriptografar");
		
		opcoes = entrada.nextInt();
		entrada.nextLine();
		
		switch (opcoes) {
		case 1:
			
			System.out.print("Informe uma mensagem para criptografar: ");
			mensagem = entrada.nextLine();

			System.out.print("Informe a chave de encriptação: ");
			chave = entrada.nextLine();
			
			String encriptacao = encriptacao(mensagem, chave);
			System.out.println("MENSAGEM CRIPTOGRAFADA: " + encriptacao);
			break;
			
		case 2:
			
			System.out.print("Informe uma mensagem criptografada: ");
			mensagem = entrada.nextLine();
			
			System.out.print("Informe a chave de decriptação: ");
			chave = entrada.nextLine();
			
			
			String mensagemDecifrada = decriptacao(mensagem, chave);
			System.out.println(mensagemDecifrada);
			break;

		default:
			
			System.out.println("Opção incorreta.");
			break;
		}
		
		entrada.close();
	}
	
	public static String encriptacao(String textoBase, String chave) {
		
		StringBuilder textoEcriptado = new StringBuilder();
		textoBase = textoBase.toLowerCase();
		chave = chave.toLowerCase();
		
		int tamanhoChave = chave.length();
		
		for (int i = 0; i < textoBase.length(); i++) {
			
			char caracteresBase = textoBase.charAt(i);
			
			if(Character.isLetter(caracteresBase)) {
				
				char caracteresChave = chave.charAt(i % tamanhoChave);
				int posicaoTroca = caracteresChave - 'a';
				
				char caracteresEncriptados = (char)((caracteresBase - 'a' + posicaoTroca) % 26 + 'a');
				textoEcriptado.append(caracteresEncriptados);
			} else {
				
				textoEcriptado.append(textoBase);
			}
		}
		return textoEcriptado.toString();
	}
	
	public static String decriptacao(String textoEncriptado, String chave) {
		
		StringBuilder textoBase = new StringBuilder();
		textoEncriptado = textoEncriptado.toLowerCase();
		chave = chave.toLowerCase();
		
		int tamanhoChave = chave.length();
		
		for (int i = 0; i < textoEncriptado.length(); i++) {
			
			char caracteresEncriptados = textoEncriptado.charAt(i);
			if(Character.isLetter(caracteresEncriptados)) {
				
				char caracteresChave = chave.charAt(i % tamanhoChave);
				int posicaoTroca = caracteresChave - 'a';
				
				char caracteresDecifrados = (char)((caracteresEncriptados - 'a' - posicaoTroca + 26) % 26 + 'a');
				textoBase.append(caracteresDecifrados);
			} else {
				
				textoBase.append(caracteresEncriptados);
			}
		}
		return textoBase.toString();
	}
}
