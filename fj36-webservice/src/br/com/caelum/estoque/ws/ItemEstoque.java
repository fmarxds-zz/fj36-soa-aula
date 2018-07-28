package br.com.caelum.estoque.ws;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemEstoque implements Serializable {
	
	private String codigo;
	private Integer quantidade;
	
	/** @deprecated - JAX-WS */
	public ItemEstoque() {
	}

	public ItemEstoque(String codigo, Integer quantidade) {
		this.codigo = codigo;
		this.quantidade = quantidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
