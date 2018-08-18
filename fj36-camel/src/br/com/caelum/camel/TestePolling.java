package br.com.caelum.camel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.util.jndi.JndiContext;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import br.com.caelum.livraria.modelo.Livro;

public class TestePolling {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
		dataSource.setServerName("localhost");
		dataSource.setDatabaseName("fj36_camel");
		dataSource.setPort(3306);
		dataSource.setUser("root");
		dataSource.setPassword("caelum");
		
		JndiContext jndiContext = new JndiContext();
		jndiContext.rebind("mysqlDataSource", dataSource);
		
		CamelContext ctx = new DefaultCamelContext(jndiContext);
		ctx.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("http://localhost:8088/fj36-livraria/loja/livros/mais-vendidos").delay(1000)
				.unmarshal()
					.json()
				.process(new Processor() {
					@SuppressWarnings("unchecked")
					@Override
					public void process(Exchange exchange) throws Exception {
						List<?> listaDeLivros = (List<?>) exchange.getIn().getBody();
						
						ArrayList<Livro> livros = (ArrayList<Livro>) listaDeLivros.get(0);
						
						Message message = exchange.getIn();
						message.setBody(livros);
					}
				})
				.log("${body}")
				.to("direct:livros");
				
				from("direct:livros")
				.split(body())
				.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						Message inboud = exchange.getIn();
						Livro livro = inboud.getBody(Livro.class);
						String nomeAutor = livro.getNomeAutor();
						System.out.println();
						inboud.setHeader("nomeAutor", nomeAutor);
					}
				})
				.setBody(simple("INSERT INTO Livros (nomeAutor) values (:?nomeAutor)"))
				.to("jdbc:mysqlDataSource?useHeadersAsParameters=true");
			}
		});
		
		System.out.println("Pressione ENTER para sair...");
		ctx.start();
		new Scanner(System.in).nextLine();
		ctx.stop();
		
	}

}
