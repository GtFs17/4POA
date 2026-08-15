package pjrLoja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class PrincipalSerializacaoPedido {

	private static final String CAMINHO_PASTA = "c:/loja";
	private static final String CAMINHO_SER = "c:/loja/pedido.ser";

	public static void main(String[] args) {

		Cliente cliente = new Cliente(1, "Ana Paula", "ana@email.com", "21990001111");
		Produto produto = new Produto(10, "Monitor", 899.90, 15);

		Pedido pedido = new Pedido(100, LocalDate.now(), "Aberto", cliente);
		pedido.adicionarItem(new ItemPedido(1, produto.getPreco(), produto));

		try {
			File pasta = new File(CAMINHO_PASTA);
			if (!pasta.exists()) pasta.mkdir();

			FileOutputStream arqOSer = new FileOutputStream(CAMINHO_SER);
			ObjectOutputStream oOSer = new ObjectOutputStream(arqOSer);
			oOSer.writeObject(pedido);
			oOSer.close();

			System.out.println("--------- Antes de alterar o status -------------");
			System.out.println(pedido);

			pedido.setStatus("Cancelado");

			System.out.println("--------- Depois de alterar o status em memoria -------------");
			System.out.println(pedido);

			FileInputStream arqISer = new FileInputStream(CAMINHO_SER);
			ObjectInputStream iOSer = new ObjectInputStream(arqISer);
			Pedido pedidoRecuperado = (Pedido) iOSer.readObject();
			iOSer.close();

			System.out.println("--------- Depois de recuperar do arquivo .ser -------------");
			System.out.println(pedidoRecuperado);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
