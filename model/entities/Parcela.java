package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {
	private LocalDate data;
	private Double quantia;
	
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Parcela() {}
	public Parcela(LocalDate data, Double quantia) {
		this.data = data;
		this.quantia = quantia;
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public Double getQuantia() {
		return quantia;
	}
	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(data.format(formato));
		sb.append(" - ");
		sb.append(String.format("%.2f", quantia));
		
		return sb.toString();
	}
}
