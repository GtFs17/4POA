package pjrLoja;

import java.io.Serializable;
import java.time.LocalDate;

public class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String forma;
	private double valor;
	private LocalDate data;
	private String status;

	public Pagamento(int id, String forma, double valor) {
		super();
		this.id = id;
		this.forma = forma;
		this.valor = valor;
		this.data = LocalDate.now();
		this.status = "Pendente";
	}

	public void processar() {
		this.status = "Aprovado";
		System.out.println("Pagamento " + id + " processado via " + forma + " no valor de " + valor);
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getForma() { return forma; }
	public void setForma(String forma) { this.forma = forma; }
	public double getValor() { return valor; }
	public void setValor(double valor) { this.valor = valor; }
	public LocalDate getData() { return data; }
	public void setData(LocalDate data) { this.data = data; }
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", forma=" + forma + ", valor=" + valor + ", data=" + data + ", status=" + status + "]";
	}
}
