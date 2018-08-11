package br.com.caelum.camel;

import java.util.Scanner;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TesteRoteamento {
	
	public static void main(String[] args) throws Exception {
		
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				errorHandler(
					deadLetterChannel("file:falha")
					.useOriginalMessage()
					.maximumRedeliveries(2)
					.redeliveryDelay(2*1000)
					.retryAttemptedLogLevel(LoggingLevel.ERROR)
				);
				
				from("file:entrada?delay=5s")
				.log(LoggingLevel.INFO, "Processando mensagem: ${id}")
				.to("validator:file:xsd/pedido.xsd")
				.to("file:saida");				
			}
		});
		
		System.out.println("Pressione ENTER para sair...");
		context.start();
		new Scanner(System.in).nextLine();
		context.stop();
		
	}

}
