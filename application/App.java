package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.ServicoContrato;
import model.services.ServicoPaypal;

public class App {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do Contrato:");
		System.out.print("Número: ");
		Integer numero = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate data = LocalDate.parse(sc.nextLine(), formato);
		
		System.out.print("Valor do contrato: ");
		Double valorTotal = sc.nextDouble();
		sc.nextLine();
		
		Contrato contrato = new Contrato(numero, data, valorTotal);
		
		System.out.print("Quantia de parcelas: ");
		Integer quantia = sc.nextInt();
		sc.nextLine();
		
		ServicoContrato servico = new ServicoContrato(new ServicoPaypal());
		servico.processarContrato(contrato, quantia);
		
		System.out.println("Parcelas: ");
		for (Parcela parcela : contrato.getParcelas()) {
			System.out.println(parcela);
		}
		
		sc.close();
	}
}
