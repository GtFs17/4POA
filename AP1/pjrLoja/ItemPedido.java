package pjrLoja;

import java.io.Serializable;

public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private int quantidade;
	private double precoUnitario;
	private double subtotal;
	private Produto produto;

	public ItemPedido(int quantidade, double precoUnitario, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.produto = produto;
		calcularSubtotal();
	}

	public double calcularSubtotal() {
		this.subtotal = quantidade * precoUnitario;
		return subtotal;
	}

	public int getQuantidade() { return quantidade; }
	public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
	public double getPrecoUnitario() { return precoUnitario; }
	public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }
	public double getSubtotal() { return subtotal; }
	public Produto getProduto() { return produto; }
	public void setProduto(Produto produto) { this.produto = produto; }

	@Override
	public String toString() {
		return quantidade + "x " + produto.getNome() + " (unit=" + precoUnitario + ", subtotal=" + subtotal + ")";
	}
}
