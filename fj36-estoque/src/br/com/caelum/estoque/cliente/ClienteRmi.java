package br.com.caelum.estoque.cliente;

import java.rmi.Naming;
import java.util.Scanner;

import br.com.caelum.estoque.rmi.EstoqueRmi;
import br.com.caelum.estoque.rmi.ItemEstoque;

public class ClienteRmi {

	public static void main(String[] args) throws Exception {

		EstoqueRmi estoque = (EstoqueRmi) Naming.lookup("rmi://localhost:1099/estoque");

		Scanner sc = new Scanner(System.in);
		
		System.out.println(estoque.toString());

		while (sc.hasNextLine()) {
			ItemEstoque item = estoque.getItemEstoque(sc.nextLine());
			System.out.println("Qauntidade: " + item.getQuantidade());
		}
		
		sc.close();

	}

}
