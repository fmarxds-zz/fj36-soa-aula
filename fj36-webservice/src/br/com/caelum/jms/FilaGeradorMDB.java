package br.com.caelum.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig={
	@ActivationConfigProperty(propertyName="destinationLookup", propertyValue="jms/FILA.GERADOR"),
	@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue")})
public class FilaGeradorMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage msg = (TextMessage) message;
		try {
			System.out.println("MENSAGEM RECEBIDA: " + msg.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
