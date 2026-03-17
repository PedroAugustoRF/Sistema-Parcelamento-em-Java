package model.services;

public class ServicoPaypal implements ServicoPagamentoOnline{
	@Override
	public Double taxaPagamento(Double quantia) {
		return quantia * 0.02;
	}
	
	@Override
	public Double juros(Double quantia, Integer meses) {
		return quantia * 0.01 * meses;
	}
}
