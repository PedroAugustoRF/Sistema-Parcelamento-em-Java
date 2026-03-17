package model.services;

import java.time.LocalDate;

import model.entities.Contrato;
import model.entities.Parcela;

public class ServicoContrato {
	private ServicoPagamentoOnline servicoPagamentoOnline;

	public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}
	
	public void processarContrato(Contrato contrato, Integer meses) {
		double parcelaBase = contrato.getValorTotal() / meses;
		
		for (int i = 1; i <= meses; i++) {
			LocalDate dataVencimento = contrato.getData().plusMonths(i);

			double juros = servicoPagamentoOnline.juros(parcelaBase, i);
			double taxaPagamento = servicoPagamentoOnline.taxaPagamento(parcelaBase + juros);
			double parcela = parcelaBase + juros + taxaPagamento;
			
			contrato.getParcelas().add(new Parcela(dataVencimento, parcela));
		}
	}
	
}
