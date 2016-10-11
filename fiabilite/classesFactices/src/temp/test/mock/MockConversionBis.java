package temp.test.mock;

import model.IConversion;

/**
 * Mock de la classe Conversion qui utilise une interface
 * plutôt que d'hériter de la classe concrète
 * (on suppose que la classe implémentera la même interface)
 * @author l21003949
 *
 */
public class MockConversionBis implements IConversion {

	@Override
	public double convF2C(double temperature) {
		//Vérifier qu'on est pas en-dessous du zéro absolu (IllegalArgumentException)
		return (temperature-32.0)*5.0/9.0;
	}

	@Override
	public double convC2F(double temperature) {
		//Vérifier qu'on est pas en-dessous du zéro absolu (IllegalArgumentException)
		return temperature*9.0/5.0+32.0;
	}
	
}
