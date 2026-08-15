package pjrLoja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrincipalListaLog {

	private static final String CAMINHO_PASTA = "c:/loja";
	private static final String CAMINHO_LOG = "c:/loja/log_pedidos.txt";

	public static void main(String[] args) {

		List<Pedido> pedidos = montarPedidosDeExemplo();

		gravarLog(pedidos);

		List<String> log = lerLog();

		System.out.println("----- Log de pedidos (" + log.size() + " registros) -----");
		for (String linha : log) {
			System.out.println(linha);
		}
	}

	private static List<Pedido> montarPedidosDeExemplo() {
		List<Pedido> pedidos = new ArrayList<>();

		Cliente c1 = new Cliente(1, "Maria Silva", "maria@email.com", "21999990000");
		Cliente c2 = new Cliente(2, "Joao Souza", "joao@email.com", "21988880000");

		Produto p1 = new Produto(1, "Mouse", 45.90, 100);
		Produto p2 = new Produto(2, "Teclado", 120.00, 50);

		Pedido pedido1 = new Pedido(1, LocalDate.now(), "Aberto", c1);
		pedido1.adicionarItem(new ItemPedido(2, p1.getPreco(), p1));
		pedido1.adicionarItem(new ItemPedido(1, p2.getPreco(), p2));

		Pedido pedido2 = new Pedido(2, LocalDate.now(), "Aberto", c2);
		pedido2.adicionarItem(new ItemPedido(3, p1.getPreco(), p1));

		pedidos.add(pedido1);
		pedidos.add(pedido2);

		return pedidos;
	}

	private static void gravarLog(List<Pedido> pedidos) {
		try {
			File pasta = new File(CAMINHO_PASTA);
			if (!pasta.exists()) pasta.mkdir();

			FileWriter escrita = new FileWriter(CAMINHO_LOG, true);
			BufferedWriter bwEscrita = new BufferedWriter(escrita);

			for (Pedido pedido : pedidos) {
				bwEscrita.write(pedido.toString());
				bwEscrita.newLine();
			}

			bwEscrita.close();
			escrita.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<String> lerLog() {
		List<String> linhas = new ArrayList<>();
		try {
			FileReader leitura = new FileReader(CAMINHO_LOG);
			BufferedReader brLeitura = new BufferedReader(leitura);

			while (brLeitura.ready()) {
				linhas.add(brLeitura.readLine());
			}

			brLeitura.close();
			leitura.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return linhas;
	}
}
