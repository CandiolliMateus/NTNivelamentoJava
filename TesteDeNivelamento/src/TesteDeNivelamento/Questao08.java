package TesteDeNivelamento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Questao08 {

	public static void main(String[] args) {

		List<List<String>> dados = MatrizAlunos("Estudantes.txt");

		try {
			@SuppressWarnings("unused")
			var analiseResultadosAlunos = AnaliseResultadosAlunos(dados);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/**
		 * PRIMEIRA VERSÃO DO FOR
		 * AINDA SEM UMA QUANTIDADE DE NOTAS INDETERMINADA
		 * 
		for (int i = 0; i < dados.size(); i++) {
			
			for (int j = 0; j < dados.get(i).size(); j++) {
				
				System.out.println(dados.get(i).get(j));
			}
			
			int frequencia = Integer.parseInt(dados.get(i).get(1));
			int nota01 = Integer.parseInt(dados.get(i).get(2));
			int nota02 = Integer.parseInt(dados.get(i).get(3));
			int nota03 = Integer.parseInt(dados.get(i).get(4));
			double media = (nota01 + nota02 + nota03) / 3;
			
			if(frequencia > 70 && media > 7) {
				System.out.println("Média: " + media + ". APROVADO.");
			} else if (frequencia > 70 && media > 4) {
				System.out.println("Média: " + media + ". Recuperação.");
			} else {
				System.out.println("Média: " + media + ". Reprovado.");
			}
		}
		**/
	}
	
	public static List<List<String>> MatrizAlunos(String file) {
		
		List<List<String>> dados = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader("Estudantes.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(";");
				List<String> rowData = new ArrayList<>();
				for (String part : parts) {
					rowData.add(part);
				}
				dados.add(rowData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dados;
	}
	
	public static BufferedWriter AnaliseResultadosAlunos(List<List<String>> dados) throws IOException {
		
		BufferedWriter escreverArquivo = new BufferedWriter(new FileWriter("Resultado.txt"));
		
		for (int i = 0; i < dados.size(); i++) {
			
			escreverArquivo.write("Nome: " + dados.get(i).get(0));
			
			/**
			for (int j = 0; j < dados.get(i).size(); j++) {
				
			}
			**/
			
			int frequencia = Integer.parseInt(dados.get(i).get(1));
			escreverArquivo.write("\n" + "Frequência: " + frequencia);
			
			int contador = 0;
			double media = 0;
			for (int j = 2; j < dados.get(i).size(); j++) {
				
				int nota = Integer.parseInt(dados.get(i).get(j)); 
				media = media + nota;
				contador = contador + 1;
			}
			media = media / contador;
			
			if(frequencia > 70 && media > 7) {
				escreverArquivo.write(String.format("\n" + "Média: %.2f", media));
				escreverArquivo.write("\n" + "Situação: Aprovado." + "\n" + "\n");
			} else if (frequencia > 70 && media > 4) {
				escreverArquivo.write(String.format("\n" + "Média: %.2f", media));
				escreverArquivo.write("\n" + "Situação: Recuperação." + "\n" + "\n");
			} else {
				escreverArquivo.write(String.format("\n" + "Média: %.2f", media));
				escreverArquivo.write("\n" + "Situação: Reprovado." + "\n" + "\n");
			}
		}
		
		escreverArquivo.close();		
		return escreverArquivo;
	}
}
