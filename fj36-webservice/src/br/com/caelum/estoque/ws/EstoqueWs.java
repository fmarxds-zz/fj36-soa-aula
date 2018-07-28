package br.com.caelum.estoque.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.sun.org.glassfish.gmbal.ParameterNames;

@Stateless
@WebService(targetNamespace="http://caelum.com.br/estoquews/v1")
public class EstoqueWs {

	private Map<String, ItemEstoque> repositorio = new HashMap<>();

	public EstoqueWs() {
		repositorio.put("ARQ", new ItemEstoque("ARQ", 5));
		repositorio.put("SOA", new ItemEstoque("SOA", 2));
		repositorio.put("TDD", new ItemEstoque("TDD", 3));
		repositorio.put("RES", new ItemEstoque("RES", 4));
		repositorio.put("LOG", new ItemEstoque("LOG", 3));
		repositorio.put("WEB", new ItemEstoque("WEB", 4));
	}
	
	@WebMethod(operationName="QuantidadeEmEstoquePeloCodigo")
	@WebResult(name="ItemEstoque")
	public List<ItemEstoque> getQuantidade(@WebParam(name="codigoItem") List<String> codigoItem, @WebParam(name="tokenUsuario", header=true) String token) {
		
		boolean tokenEhInvalido = token == null || !"TOKEN123".equals(token);
		if (tokenEhInvalido) {
			throw new AutorizacaoException("Nao autorizado");
		}
		
		List<ItemEstoque> itens = new ArrayList<>();
		if(codigoItem == null || codigoItem.isEmpty()){
			return itens;
		}
		codigoItem.forEach(item -> {
			ItemEstoque livro = repositorio.get(item);
			itens.add(livro);
		});
		return itens;
	}

}
