package model.services;

public interface ServicoPagamentoOnline {
	Double taxaPagamento(Double quantia);
	Double juros(Double quantia, Integer meses);
}
