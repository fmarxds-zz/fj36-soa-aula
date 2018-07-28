package br.com.caelum.estoque.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import br.com.caelum.estoque.rmi.ItemEstoque;

public class TestaLeituraDeObjetos {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("itens.bin"))) {
			@SuppressWarnings("unchecked")
			List<ItemEstoque> itens = (List<ItemEstoque>) ois.readObject();
			
			for (ItemEstoque item : itens){
				System.out.println("Código: " + item.getCodigo());
				System.out.println("Quant.: " + item.getQuantidade());
				System.out.println("----------------------------------");
			}
		}
		
	}

}
