package pjrLoja;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private LocalDate data;
	private String status;
	private double total;

	private Cliente cliente;
	private List<ItemPedido> itens;
	private Pagamento pagamento;

	public Pedido(int id, LocalDate data, String status, Cliente cliente) {
		super();
		this.id = id;
		this.data = data;
		this.status = status;
		this.cliente = cliente;
		this.itens = new ArrayList<>();
		this.total = 0.0;
	}

	public void adicionarItem(ItemPedido item) {
		itens.add(item);
		calcularTotal();
	}

	public double calcularTotal() {
		double soma = 0.0;
		for (ItemPedido item : itens) {
			soma += item.getSubtotal();
		}
		this.total = soma;
		return total;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public LocalDate getData() { return data; }
	public void setData(LocalDate data) { this.data = data; }
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	public double getTotal() { return total; }
	public Cliente getCliente() { return cliente; }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }
	public List<ItemPedido> getItens() { return itens; }
	public Pagamento getPagamento() { return pagamento; }
	public void setPagamento(Pagamento pagamento) { this.pagamento = pagamento; }

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", status=" + status + ", total=" + total
				+ ", cliente=" + cliente.getNome() + ", itens=" + itens.size() + "]";
	}
}
