package authenticator.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import authenticator.ConnectToTerminal;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import model.ICard;
import model.IValidator;
import model.IllegalCardException;

public class ConnectToTerminalTest {
	@Mocked
	private ICard card;
	
	@Mocked
	private IValidator validator;
	
	private ConnectToTerminal connector;

	@Test
	public void testValidateCardNumber() {
	
	}
	
	@Test
	public void testAuthenticateCode() throws IllegalCardException {
		new Expectations() {{
			validator.validateCard(21003949);
			times=1;
		}};
		
		connector = new ConnectToTerminal(validator);
		assertEquals(true,connector.validateCardNumber(21003949));
		
		new Verifications() {{
			card.checkSecretCode(anyInt);times=0;
			card.isConnected();times=0;
			card.setConnection(anyBoolean);times=0;
			card.isValid();times=0;
			card.setValidation(anyBoolean);times=0;
		}};
	}
	
	@Test(expected = IllegalCardException.class)
	public void testAuthenticateCodeIllegalCardException() throws IllegalCardException {
		new Expectations() {{
			validator.validateCard(21003949);
			result = null;
			times = 1;
		}};
		
		connector = new ConnectToTerminal(validator);
		connector.validateCardNumber(21003949);
	}
}
