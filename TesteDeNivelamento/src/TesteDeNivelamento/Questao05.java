package TesteDeNivelamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Questao05 {

	public static void main(String[] args) {
			
		System.out.println(troco(400, 600));
	}
	
	public static String troco(double custo, double pagamento) {
		
		double transacao = pagamento - custo;
		BigDecimal trocoArredondado = new BigDecimal(transacao).setScale(2, RoundingMode.HALF_UP);
		
		int trocoSemVirgula = trocoArredondado.multiply(BigDecimal.valueOf(100)).intValue();
		int valorSemCentavos = trocoSemVirgula / 100;
		int valorDosCentavos = trocoSemVirgula % 100;
		
		int trocoDeDuzentos = valorSemCentavos / 200;
		if (trocoDeDuzentos > 0) {
			System.out.println("Quantidade de notas de R$ 200,00: " + trocoDeDuzentos);
			valorSemCentavos = valorSemCentavos - (trocoDeDuzentos * 200);
		}
		int trocoDeCem = valorSemCentavos / 100;
		if (trocoDeCem > 0) {
			System.out.println("Quantidade de notas de R$ 100,00: " + trocoDeCem);
			valorSemCentavos = valorSemCentavos - (trocoDeCem * 100);
		}
		
		int trocoDeCinquenta = valorSemCentavos / 50;
		if (trocoDeCinquenta > 0) {
			System.out.println("Quantidade de notas de R$ 50,00: " + trocoDeCinquenta);
			valorSemCentavos = valorSemCentavos - (trocoDeCinquenta * 50);
		}
		
		int trocoDeVinte = valorSemCentavos / 20;
		if (trocoDeVinte > 0) {
			System.out.println("Quantidade de notas de R$ 20,00: " + trocoDeVinte);
			valorSemCentavos = valorSemCentavos - (trocoDeVinte * 20);
		}
		
		int trocoDeDez = valorSemCentavos / 10;
		if (trocoDeDez > 0) {
			System.out.println("Quantidade de notas de R$ 10,00: " + trocoDeDez);
			valorSemCentavos = valorSemCentavos - (trocoDeDez * 10);
		}
		
		int trocoDeCinco = valorSemCentavos / 5;
		if (trocoDeCinco > 0) {
			System.out.println("Quantidade de notas de R$ 5,00: " + trocoDeCinco);
			valorSemCentavos = valorSemCentavos - (trocoDeCinco * 5);
		}
		
		int trocoDeDois = valorSemCentavos / 2;
		if (trocoDeDois > 0) {
			System.out.println("Quantidade de notas de R$ 2,00: " + trocoDeDois);
			valorSemCentavos = valorSemCentavos - (trocoDeDois * 2);
		}
		
		int trocoMoedaUm = valorSemCentavos / 1;
		if (trocoMoedaUm > 0) {
			System.out.println("Quantidade de moedas de R$ 1,00: " + trocoMoedaUm);
		}
		
		int trocoMoedaCinquenta = valorDosCentavos / 50;
		if (trocoMoedaCinquenta > 0) {
			System.out.println("Quantidade de moedas de R$ 0,50: " + trocoMoedaCinquenta);
			valorDosCentavos = valorDosCentavos - (trocoMoedaCinquenta * 50);
		}
		
		int trocoMoedaVinteECinco = valorDosCentavos / 25;
		if (trocoMoedaVinteECinco > 0) {
			System.out.println("Quantidade de moedas de R$ 0,25: " + trocoMoedaVinteECinco);
			valorDosCentavos = valorDosCentavos - (trocoMoedaVinteECinco * 25);
		}
		
		int trocoMoedaDez = valorDosCentavos / 10;
		if (trocoMoedaDez > 0) {
			System.out.println("Quantidade de moedas de R$ 0,10: " + trocoMoedaDez);
			valorDosCentavos = valorDosCentavos - (trocoMoedaDez * 10);
		}
		
		int trocoMoedaCinco = valorDosCentavos / 5;
		if (trocoMoedaCinco > 0) {
			System.out.println("Quantidade de moedas de R$ 0,05: " + trocoMoedaCinco);
		}
		
		return String.format("O seu troco é R$ " + trocoArredondado);
	}
}
